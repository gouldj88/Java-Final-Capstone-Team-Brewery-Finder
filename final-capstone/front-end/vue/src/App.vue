<template>
  <div id="app">
    <header>
        <div id="nav">
          <!--<router-link v-bind:to="{ name: 'home' }">Back To Search</router-link>&nbsp;|&nbsp;-->
          <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
          <router-link v-bind:to="{ name: 'addBrewery' }">Add New Brewery</router-link>
        
        </div>
        </header>
        <router-view />

    

    <article class="container">
    </article>

    <aside class="sidebar-left">
      <h1>HI</h1>
    </aside>

    <aside class="sidebar-right">
    </aside>


    <footer>
    </footer>
  </div>

</template>

<style scoped>

header {
    background-color: rgb(138, 106, 0);
}

.container {
  background-color: rgb(138, 106, 0);
  
}

.sidebar-left {
  background-color: rgb(138, 106, 0);
  width: 20%;
  
  
}

.sidebar-right {
  background-color: rgb(138, 106, 0);
  width: 20%;
}

footer {
  background-color: rgb(138, 106, 0);
  height: 50px;
}


</style>
