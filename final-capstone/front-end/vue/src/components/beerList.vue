<template>
  <div class="beer-list">
  <div v-for="beerId in results" v-bind:key="beerId.name" class="beer-list">
    {{ brewery.name }}
    <br>{{beer.name}}
    <br>{{beer.image}}, {{beer.description}} {{beer.abv}}
    <br>{{beer.type}}

    </div>
  </div>



</template>