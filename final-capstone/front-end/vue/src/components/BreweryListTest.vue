<template>

    <div class='brewery-list'>
    
    <div id="SearchForm">

    <v-container fluid>
  
        <v-col cols="6">
          <v-select
            v-model="dropdown"
            :hint="`${dropdown.type}`"
            :items="ddItems"
            item-text="type"
            item-value="ddValue"
            label="Select"
            persistent-hint
            return-object
            single-line
          ></v-select>
        </v-col>
    </v-container>
    
        <v-form v-on:submit.prevent="textSearch()"> 
            <v-text-field type="text" v-model="searchText" label="Please enter your search information here."></v-text-field>
            <v-btn v-on:click="textSearch()">Search</v-btn>
        </v-form>
    </div>


<div id="app">
  <v-app id="inspire">
    <v-data-table
      :headers="headers"
      :items="results"
      :items-per-page="5"
      class="elevation-1"
    >
    
    </v-data-table>
  </v-app>
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
        results: [],
        headers: [
        {
          text: 'Brewery',
          align: 'start',
          sortable: false,
          value: 'name'
        },
        { text: 'Address', value: 'street' },
        { text: 'City', value: 'city' },
        { text: 'State', value: 'state' },
        { text: 'Zip Code', value: 'postal_code' },
      ],
        dropdown: { type: 'Select Search Type', ddValue: '1' },
        ddItems: [
        { type: 'City', ddValue: '2' },
        { type: 'State', ddValue: '3' },
        { type: 'Zip Code', ddValue: '4' },
        { type: 'Brewery Name', ddValue: '5' },
      ],
    }
},
methods: {
    textSearch(){
        if (this.dropdown.ddValue == 2){
            this.citySearch();
        }
        if (this.dropdown.ddValue == 3){
            this.stateSearch();
        }
        if (this.dropdown.ddValue == 4){
            this.zipSearch();
        }
        if (this.dropdown.ddValue == 5){
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

.v-text-field{
      width: 400px;
      justify-content: center;
}

</style>
