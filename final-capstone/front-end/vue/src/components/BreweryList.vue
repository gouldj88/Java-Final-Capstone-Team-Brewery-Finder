<template>

    <div class='brewery-list'>
    
    <div id="SearchForm">
        <select v-model="selectedValue" name="SearchType">
            <option value="1">Select Search Type</option>
            <option value="2">City</option>
            <option value="3">State</option>
            <option value="4">Zip Code</option>
            <option value="5">Brewery Name</option>
        </select>      
    
        <form v-on:submit.prevent="textSearch()"> 
            <input type="text" v-model="searchText">
            <input type="button" value="Search" v-on:click="textSearch()">
        </form>
    </div>

    <div v-for="brewery in results" v-bind:key="brewery.name" class="brewery">
    {{ brewery.name }}
    <br>{{brewery.street}}
    <br>{{brewery.city}}, {{brewery.state}} {{brewery.postal_code}}
    <br>{{brewery.phone}}
    <br><a v-bind:href="brewery.website_url">{{brewery.website_url}}</a>
    <br><a v-bind:href="'http://www.google.com/maps/place/'+brewery.street+'+'+brewery.city+'+'+brewery.state+'+USA'">View Map</a>


     
    </div>
  </div>


</template>

<script>
import BreweryServices from '@/services/BreweryServices';

export default{
name: 'brewery-list',

data () {
    return {
        searchText: "",
        selectedValue: 1,
        results: []
    }
},
methods: {

    textSearch(){
        if (this.selectedValue == 2){
            this.citySearch();
        }
        if (this.selectedValue == 3){
            this.stateSearch();
        }
        if (this.selectedValue == 4){
            this.zipSearch();
        }
        if (this.selectedValue == 5){
            this.nameSearch();
        }
    },

    zipSearch(){
        BreweryServices.getBreweriesByZipCode(this.searchText).then(response => {
        this.results = response.data;
        })
    },

    citySearch(){
        BreweryServices.getBreweriesByCity(this.searchText).then(response => {
        this.results = response.data;
        })
    },

    nameSearch(){
        BreweryServices.getBreweriesByName(this.searchText).then(response => {
        this.results = response.data;
        })
    },

    stateSearch(){
        BreweryServices.getBreweriesByState(this.searchText).then(response => {
        this.results = response.data;
        })
    },
  }
}


</script>

<style scoped>
.brewery{
padding: 30px 50px;
    max-width: 1050px;
    margin: 0 auto;
    border-top: 1px solid #d8d8d8;
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    position: relative;
    font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}

#SearchForm {
  display: inline
}

</style>
