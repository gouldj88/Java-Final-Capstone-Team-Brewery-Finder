<template>
<body>
  <div id="app">
    <header>
        <div id="nav">
          <!--<router-link v-bind:to="{ name: 'home' }">Back To Search</router-link>&nbsp;|&nbsp;-->
          <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
          <router-link v-bind:to="{ name: 'addBrewery' }">Add New Brewery</router-link>
        
        </div>
        </header>
      

    

    <article class="container">
       <router-view />
       <h1>HI</h1>
    </article>

    <aside class="sidebar-left">
      <h1>HI</h1>
    </aside>

    <aside class="sidebar-right">
       <h1>HI</h1>
    </aside>


    <footer>
    </footer>
  </div>
</body>
</template>

<style scoped>
body{
  display: grid;
    grid-template-columns: 100% 100% 100% ;

 grid-template-areas:
 "header header header"
 "sidebar-left  container sidebar-right"
 "footer footer footer"
}
header {
  grid-area: header;
    background-color: rgb(138, 106, 0);
    width: 100%;
}

.container {
  grid-area: container;
  background-color: rgb(175, 44, 34);
  justify-content: center;
  width: 66%;
  
}

.sidebar-left {
  grid-area: sidebar-left;
  background-color: rgb(39, 138, 0);
  width: 10%;
  float: left;
  height: 236%;
  
  
}

.sidebar-right {
  grid-area: sidebar-right;
  background-color: rgb(138, 106, 0);
  width: 10%;
  float: right;
  height: 236%;
}

footer {
  background-color: rgb(138, 106, 0);
  height: 50px;
}


</style>
