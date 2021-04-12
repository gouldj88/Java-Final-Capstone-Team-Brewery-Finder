<template>

  <div id="app">
    <body>
    <link href='https://fonts.googleapis.com/css?family=Fira Sans' rel='stylesheet'>
    <link href='https://fonts.googleapis.com/css?family=Syncopate' rel='stylesheet'>

    <img src="@/assets/brewery-front.jpg" id="bg" alt="">
    

    <div class="theHeader">
    <the-header></the-header>
    </div>

    <article class="container">
      <router-view />
    </article>

    <aside class="sidebar-left">
      
    </aside>

    <aside class="sidebar-right">
       
  <br>
  <br>
  <br>
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
  grid-template-columns: 10% 80% 10% ;
  grid-template-rows: 10% auto 10%;
  height: 100vh;

 grid-template-areas:
    "header         header        header"
    "sidebar-left   container     sidebar-right"
    "footer         footer        footer";
}

#bg {
  position: fixed; 
  top: 0; 
  left: 0; 
	
  /* Preserve aspet ratio */
  min-width: 100%;
  min-height: 100%;

  user-drag: none; 
  user-select: none;
  -moz-user-select: none;
  -webkit-user-drag: none;
  -webkit-user-select: none;
  -ms-user-select: none;
}

.theHeader {
    grid-area: header;
    background-color: rgb(145, 88, 3);   
    padding: 10px;
    color: white;
    display: flex;
    align-items: center;
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

