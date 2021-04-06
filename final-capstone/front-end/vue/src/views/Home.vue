<template>
  <div class="home">
    <h1>BrewFinder</h1>
    <p>Welcome to your selected list of local breweries!</p>
    <div id="SearchForm">
    <select id="SearchType">
      <option>Select Search Type</option>
      <option id="state">State</option>
      <option id="city">City</option>
      <option id="zipCode">Zip Code</option>
      <option id="name">Brewery Name</option>
    </select>      
    
    <form> 
      <input type="text" v-model="searchText"><input type="button" value="Search" v-on:click="submitSearch()" />
    </form>

    </div>
    <brewery-list />
  </div>
</template>

<script>

import BreweryList from '@/components/BreweryList.vue';
import breweryService from '../services/BreweryServices';

export default {
  name: 'Home',
  data() {
    return {
      searchText:""
    };
  },
  components: {
      BreweryList
  },
  methods: {
    submitSearch() {
      if (SearchType == "State") {
        BreweryList
      // Needs a promise here.
      }
      }
    }
  }

</script>
