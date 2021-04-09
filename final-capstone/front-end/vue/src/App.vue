<template>

  <div id="app">
    <body>
        <div class="theHeader">
    <the-header></the-header>
    </div>

    <article class="container">
      <router-view />
    </article>

    <aside class="sidebar-left">
      <h1>HI</h1>
    </aside>

    <aside class="sidebar-right">
       
  <br>
  <br>
  <br>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Sign up to write a review!</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link><br>
      <button type="submit">Sign in</button>
    </form>
  </div>
    </aside>
    <footer>
    

    <the-footer></the-footer>
</footer>
</body>
</div>
</template>

<script>
  import theHeader from './components/theHeader.vue'
  import theFooter from './components/theFooter.vue'
  import authService from './services/AuthService'


  export default {
    name: "app",

    components: {
      theHeader,
      theFooter,
    },

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
};




</script>

<style scoped>


body{
  display: grid;  
  grid-gap: 20px;
  grid-template-columns: 15% 67.5% 15% ;
  grid-template-rows: 15% auto 15%;
  justify-content:flex-start;
  align-items: flex-start;
  height: 100vh;

 grid-template-areas:
    "header         header        header"
    "sidebar-left   container     sidebar-right"
    "footer         footer        footer";
}

.theHeader {
    grid-area: header;
    background-color: rgb(145, 88, 3);   
    padding: 10px;
    color: white;
    display: flex;
    align-items: center;
    max-height: 90px;
}

.container {
  grid-area: container;
  background-color: rgb(255, 255, 255);
  justify-content: top;
  align-items: top;
  text-align: center;
}

.sidebar-left {
  grid-area: sidebar-left;
  background-color: white;
  align-items: center;
  text-align: center;
}

.sidebar-right {
  grid-area: sidebar-right;
  background-color: white;
  align-items: center;
  text-align: center;
}

footer {
  grid-area: footer;
  background-color: rgb(145, 88, 3);  
  padding: 10px;
  margin-bottom: 0px;
  grid-row-start: 3;
  grid-row-end: 3;
  max-height: 50px;
}

img {
  align-items: center;
}

a:active, a:visited {
  color: white;
  text-decoration: none;
}
</style>

