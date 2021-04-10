<template>
   <div id='brewery-list'>
     <v-container >
       <div class="dropdown-and-search">
           <v-select
             v-model="dropdown"
             :items="ddItems"
             item-text="type"
              item-value="ddValue"
              label="Please Select Search Type"
              filled
              persistent-hint
              return-object
              single-line
           ></v-select>
 
    
              <div v-if="this.dropdown.ddValue > 1">
                <v-form v-on:submit.prevent="textSearch()"> 
                  <v-text-field type="text" v-model="searchText" label="Please enter your search information here."></v-text-field>
                  <v-btn v-on:click="textSearch()">Search</v-btn>
                </v-form>
              </div>
    </div>

    <template>      
      <v-app id="inspire">
        <v-data-table v-if="resultsNotHidden"
          :headers="headers"
          :items="results"
          :single-expand="singleExpand"
          :items-per-page="10"
          item-key="name"
          show-expand
          class="elevation-1"
          >

            <template v-slot:[`item.name`]="{ item }">

              <div v-if="item.website_url !== null && item.username == null">  
               <a target="_blank" :href="item.website_url"> 
                {{ item.name }}
              </a>
              </div>

              <div v-if="item.website_url == null && item.username == null">  
                {{ item.name }}
              </div>

              <div v-if="item.username !== null">
                <router-link>
                  {{ item.name }}
                </router-link>
              </div>

            </template>


          <template v-slot:expanded-item="{ headers, item }">
            <td :colspan="headers.length">
              <iframe
                width=100%
                height="250"
                style="border:0"
                loading="lazy"
                allowfullscreen
                v-bind:src="googleMapsAPI + item.street + '+' + item.city + '+' + item.state + '+' + item.postal_code + '+USA'">
              </iframe>
            </td>
          </template>
        </v-data-table>
      </v-app>
    </template>  
  </v-container>
  </div>
</template>

<script>
import BreweryServices from '@/services/BreweryServices';

export default{
name: 'brewery-info',

data () {
    return {
        googleMapsAPI: "https://www.google.com/maps/embed/v1/place?key=AIzaSyCA0ZsJtAez-gVSYp1Z8Blv5N1iFiLu1Ug&q=",
        singleExpand: true,
        resultsNotHidden: false,
        searchBarNotHidden: false,
        searchText: "",
        selectedValue: 1,
        expanded: [],
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
        { text: 'Phone', value: 'phone'}
      ],
        dropdown: { type: '', ddValue: '1' },
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
        this.resultsNotHidden = !this.resultsNotHidden;
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

#SearchForm {
  display: inline
}

.dropdown-and-search{
margin: 0 auto;
width: 40%;
}

</style>
