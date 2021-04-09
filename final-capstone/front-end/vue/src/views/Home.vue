<template>
  <div class="home">
    <h1>Search For a Brewery</h1>
    <p>Find breweries based on your search type</p>
    <brewery-list-test />
  </div>
</template>

<script>

import BreweryListTest from '@/components/BreweryListTest';

export default {
  name: 'Home',
  data() {
    return {
    };
  },
  components: {
      BreweryListTest
  }
}
</script>

<style>

button.page-link {
	display: inline-block;
}
button.page-link {
    font-size: 20px;
    color: #29b3ed;
    font-weight: 500;
}
.offset{
  width: 500px !important;
  margin: 20px auto;  
}

</style>