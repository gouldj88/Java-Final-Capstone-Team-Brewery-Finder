<template>
  <div class="home">
    <h1>BrewFinder</h1>
    <p>Welcome to your selected list of local breweries!</p>
    <select name="Country" id="">
      <option value="Country">---</option>
      <option value="Country"></option>
      <option value="Country">USA</option>
      
    </select>
    <brewery-list />
  </div>
</template>

<script>

import BreweryList from '@/components/BreweryList.vue';

export default {
  name: 'Home',
  components: {
      BreweryList
  }
}
</script>
