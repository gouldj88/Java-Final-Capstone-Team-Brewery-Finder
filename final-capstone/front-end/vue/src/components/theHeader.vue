<template>
    <div id="theentireheader">
        <div>
          <router-link to="/"> 
          <div v-show="$route.name !=='home'">
        <img id="hopimg" src="../assets/hops.png" width="20px">
        <span>BreweryFinder </span>
          </div>
          </router-link>
          
        <div id="whoareyou" v-if="this.$store.state.token">
            Logged in as {{this.$store.state.user.username}}.
            Your role is {{ this.$store.state.user.authorities[0].name }}</div>
        </div>
        <template>
                
    <form id="loginoutbuttons" v-if="!this.$store.state.token">
    <v-menu offset-y :close-on-content-click="false" transition="slide-y-transition">
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
            label="User"
            v-model="user.username"
            outlined
        ></v-text-field>

        <v-text-field
            label="Password"
            type="password"
            v-model="user.password"
            outlined
        ></v-text-field>

        <v-btn rounded color="#33691E" @click="login" id="sexyfont">
            LOG IN
        </v-btn>
        <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
        >Invalid username and password!</div>
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
        user: {
          username: "",
          password: ""
      },
      invalidCredentials: false
    };
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
    }
   } 
}
</script>

<style scoped>
    @import url('https://fonts.googleapis.com/css2?family=Chango&display=swap');

#theentireheader{
  width: 100%;
}

#loginoutbuttons{
  font-family: "Fira Sans";
  position: absolute;
  top: 5.5%;
  right: 3%;
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


</style>
