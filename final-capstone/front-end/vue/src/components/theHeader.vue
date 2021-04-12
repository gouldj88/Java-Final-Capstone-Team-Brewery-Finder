<template>
    <div id="theentireheader">
        <div>
          <router-link to="/"> 
            <div v-show="$route.name !=='home'">
            <img id="hopimg" src="../assets/hops.png" width="20px">
            <span>BreweryFinder </span>
           </div>
          </router-link>

        <div id="whoareyou" v-if="tokenCheck && $route.name =='home' && userCheck !== 'ROLE_ADMIN'">
            Welcome back, {{this.$store.state.user.username}}.
        </div>

        <div id="whoareyou-admin" v-if="tokenCheck && $route.name =='home' && userCheck == 'ROLE_ADMIN'">
            * * ADMINISTRATOR MODE  * *
        </div>


        </div>
        <template>



       <form id="registerbutton-admin" v-if="tokenCheck && $route.name =='home' && userCheck == 'ROLE_ADMIN'">
    <v-menu offset-y :close-on-content-click="false" :close-on-click="true" transition="slide-y-transition">
      <template v-slot:activator="{ on, attrs }">
     <v-btn
          color="#1B5E20"
          dark
          v-bind="attrs"
          v-on="on"
          id="register"
        >
          NEW BREWERY
        </v-btn>

     </template>
        <div id="userpwmenu">
          <v-text-field
            label="Username"
            v-model="user.username"
            outlined
        ></v-text-field>

        <v-text-field
            label="Password"
            type="password"
            v-model="user.password"
            outlined
        ></v-text-field>

        <v-text-field
            label="Confirm Password"
            type="password"
            v-model="user.confirmPassword"
            outlined
        ></v-text-field>

      <v-radio-group col v-model="user.role">
      <v-radio
      label="Beer Lover"
      value="user"
      ></v-radio>
      <v-radio
      label="Brewer"
      value="brewer"
      >
        
      </v-radio>
      </v-radio-group>

        <div class="register-alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
        </div>

        <v-btn rounded color="#33691E" @click="register" id="registersubmitbutton">
          CREATE ACCOUNT
        </v-btn>
        </div>

    </v-menu>
    </form>




    






    <form id="registerbutton" v-if="!tokenCheck && $route.name =='home'">
    <v-menu offset-y :close-on-content-click="false" :close-on-click="true" transition="slide-y-transition">
      <template v-slot:activator="{ on, attrs }">
     <v-btn
          color="#1B5E20"
          dark
          v-bind="attrs"
          v-on="on"
          id="register"
        >
          REGISTER
        </v-btn>

     </template>
        <div id="userpwmenu">
          <v-text-field
            label="Username"
            v-model="user.username"
            outlined
        ></v-text-field>

        <v-text-field
            label="Password"
            type="password"
            v-model="user.password"
            outlined
        ></v-text-field>

        <v-text-field
            label="Confirm Password"
            type="password"
            v-model="user.confirmPassword"
            outlined
        ></v-text-field>

      <v-radio-group col v-model="user.role">
      <v-radio
      label="Beer Lover"
      value="user"
      ></v-radio>
      <v-radio
      label="Brewer"
      value="brewer"
      >
        
      </v-radio>
      </v-radio-group>

        <div class="register-alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
        </div>

        <v-btn rounded color="#33691E" @click="register" id="registersubmitbutton">
          CREATE ACCOUNT
        </v-btn>
        </div>

    </v-menu>
    </form>


    <form id="loginoutbuttons" v-if="!tokenCheck">
    <v-menu offset-y :close-on-content-click="false" :close-on-click="true" transition="slide-y-transition">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="#1B5E20"
          dark
          v-bind="attrs"
          v-on="on"
          id="sexyfont"
        >
          Log In
        </v-btn>
      </template>
        <div id="userpwmenu">
          <v-text-field
            label="Username"
            v-model="user.username"
            outlined
        ></v-text-field>

        <v-text-field
            label="Password"
            type="password"
            v-model="user.password"
            outlined
        ></v-text-field>

        <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
        >Invalid username or password</div>

        <v-btn rounded color="#33691E" @click="login" id="submitbutton">
          LOG IN
        </v-btn>
        </div>

    </v-menu>
    </form>

  <v-btn id="loginoutbuttons" v-if="this.$store.state.token" 
  elevation="2"
  color="#B71C1C"
  @click="logout"
  >LOG OUT</v-btn>
</template>

    </div>
</template>

<script>

import authService from '@/services/AuthService';

export default {
    name: 'theHeader',

    data() {
      return {
      invalidCredentials: false,
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
      user: {
          username: "",
          password: ""
      },
      regUser: {
          username: '',
          password: '',
          confirmPassword: '',
          role: '',
      },
    }
  },

  computed: {
    userCheck() {
      return this.$store.state.user.authorities[0].name;
    },

    tokenCheck() {
      return this.$store.state.token;
    }
  },

    methods: {
    logout(){
      this.$store.commit("LOGOUT");
      this.$router.push("/");
      location.reload();
    },
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push("/");
              location.reload();
              this.registered == !this.registered;

            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
   } 
}
</script>

<style scoped>
    @import url('https://fonts.googleapis.com/css2?family=Chango&display=swap');

#theentireheader{
  width: 100%;
}

#whoareyou{
  font-family: "Fira Sans";
  position: absolute;
  top: 6%;
  left: 3%;
  color: white;
}

#whoareyou-admin{
  font-family: "Fira Sans";
  position: absolute;
  top: 7%;
  left: 43.75%;
  color: white;
}

#loginoutbuttons{
  font-family: "Fira Sans";
  position: absolute;
  top: 5.5%;
  right: 3%;
}

#register{
  font-family: "Fira Sans";
  position: absolute;
  top: 5.5%;
  left: 3%;
}

#hopimg{
  position: absolute;
  size: 10px;
  top: 5%;
  left: 3%;
}

#userpwmenu{
  background: #FFFFFF;
  padding-top: 15px;
  padding-left: 10px;
  padding-bottom: 15px;
  padding-right: 10px;
  margin-right: 5%;
  color: white;
}

span {
    top: 5.5%;
    left: 6%;
    font-family: chango;
    font-size: 20px;
    position: absolute;
    margin: auto;
    color: white;
}

.alert-danger {
  font-family: "Fira Sans";
  color: red;
  font-size: 140%;
  text-align: center;
  padding-bottom: 10px;
}

.register-alert-danger {
  font-family: "Fira Sans";
  color: red;
  font-size: 140%;
  text-align: center;
  padding-bottom: 10px;
}

#registersubmitbutton {
  margin-left: 10%;
  color: white;
}

#submitbutton {
  margin-left: 28%;
  color: white;
}

</style>
