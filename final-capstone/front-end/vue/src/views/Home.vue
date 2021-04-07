<template>
  <div class="home">
    <h1>BrewFinder</h1>
    <p>Welcome to your selected list of local breweries!</p>
    <brewery-list />
  </div>
</template>

<script>

import BreweryList from '@/components/BreweryList';

export default {
  name: 'Home',
  data() {
    return {
    };
  },
  components: {
      BreweryList
  }
}
</script>