<template>
  <div class="home">
    <h1>Search For a Brewery</h1>
    <p>Find breweries based on your search type</p>
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