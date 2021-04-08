<template>

  <div id="app">
    <body>

        <div id="nav">        
        </div>
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
       <h1>HI</h1>
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

  export default {
    components: {
      theHeader,
      theFooter 
    }
  };
  
</script>

<style scoped>


body{
  display: grid;  
  grid-gap: 20px;
  grid-template-columns: 15% 67.5% 15% ;
  grid-template-rows: 1fr auto;
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
  justify-content: center;
  align-items: top;
  text-align: center;
  grid-row-start: 2;

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
  max-height: 90px;
}


img {
  align-items: center;
}

a:active, a:visited {
  color: white;
  text-decoration: none;
}


</style>

