<template>
  <div id="app">
    <body>
    <header>
        <div id="nav">         
          <img src="./assets/hops.png" style="width: 30px">
          <span> Brewery Finder </span>
          <router-link v-bind:to="{ name: 'home' }">Find A Brewery</router-link>&nbsp;|&nbsp;
          <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
          <router-link v-bind:to="{ name: 'addBrewery' }">Add New Brewery</router-link>
          
 
        </div>
    </header>

    <article class="container">
      <router-view />
    </article>

    <aside class="sidebar-left">
      <h1>HI</h1>
    </aside>

    <aside class="sidebar-right">
       <h1>HI</h1>
    </aside>


    <footer>
    </footer>

</body>
</div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Chango&display=swap');

body{
  display: grid;  
  grid-gap: 20px;
  grid-template-columns: 15% 67.5% 15% ;
  grid-template-rows: 10% 85% 10%;
  height: 100vh;

 grid-template-areas:
    "header         header        header"
    "sidebar-left   container     sidebar-right"
    "footer         footer        footer";
}
header {
    grid-area: header;
    background-color: rgb(46, 81, 155);   
    padding: 10px;
    color: white;
    display: flex;
    justify-content: left;
    align-items: center; 

}
.container {
  grid-area: container;
  background-color: rgb(255, 255, 255);
  justify-content: center;
  align-items: center;
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
  background-color: rgb(0, 83, 138);
  padding: 10px;
  margin-bottom: 0px;
}

span {
  font-family: chango;
  font-size: 40px ;
}

img {
  align-items: center;
}

a:active, a:visited {
  color: white;
  text-decoration: none;
}



</style>

