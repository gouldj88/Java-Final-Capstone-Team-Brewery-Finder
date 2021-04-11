<template>
    <div>
        <div>
        <img src="../assets/hops.png" style="width: 40px">
        <span>BreweryFinder </span>
        <div id="whoareyou" v-if="this.$store.state.token">
            Logged in as {{this.$store.state.user.username}}.
            Your role is {{ this.$store.state.user.authorities[0].name }}</div>
        </div>
        <template>
            
  <div id="loginbutton">
    
    <form class="form-signin" v-if="!this.$store.state.token">
    <v-menu offset-y :close-on-content-click="false" transition="slide-y-transition">
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="primary"
          dark
          v-bind="attrs"
          v-on="on"
        >
          Log In
        </v-btn>
      </template>
        <br>
        <v-text-field
            label="User"
            v-model="user.username"
            outlined
        ></v-text-field>

        <v-text-field
            label="Password"
            v-model="user.password"
            outlined
        ></v-text-field>

        <v-btn rounded color="primary" @click="login" dark>
            LOG IN
        </v-btn>

        <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
        >Invalid username and password!</div>

    </v-menu>
    </form>
  </div>
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
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/addBeer");
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

span {
    font-family: chango;
    font-size: 40px;
    margin: 0 auto;
}

#whoareyou {
    float: right;
}

</style>
