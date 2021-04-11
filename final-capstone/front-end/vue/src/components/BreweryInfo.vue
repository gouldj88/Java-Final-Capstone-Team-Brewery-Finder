<template>
 <div class="brewery-info">
 <div v-for="brewery in results" v-bind:key="brewery.name" class="brewery-information">
  <h1>{{brewery.name}}</h1>
  <h1>{{brewery.street}}</h1>
  <h1>{{brewery.city}}</h1>
  <h1>{{brewery.state}}</h1>
  <h1>{{brewery.postal_code}}</h1>
  <h1>{{brewery.website_url}}</h1>
  <h1>{{brewery.phone}}</h1>
 </div>
 
 <template>      
      <v-app id="inspire">
        <v-data-table
          :headers="headers"
          :items="beerResults"
          :single-expand="singleExpand"
          :items-per-page="10"
          item-key="name"
          show-expand
          hide-default-header
          hide-default-footer
          class="elevation-1"
          >

          <template v-slot:expanded-item="{ headers, item }">
            <td :colspan="headers.length">
           {{item.name}}
           {{item.description}}
           {{item.abv}}
           {{item.type}}
           <img v-bind:src="item.image">


            </td>
          </template>
        </v-data-table>
      </v-app>
    </template>
 
 
 
 
 </div>
</template>
<script>

import BreweryServices from '@/services/BreweryServices';
import BeerService from '@/services/BeerService';


 export default{    

    data (){
        return{
            results: [],
            beerResults: [],
            headers: [
        {
          text: 'Beer',
          align: 'start',
          sortable: false,
          value: 'name'
        },
        { text: 'Brewery', value: 'brewery' },
        { text: 'ABV', value: 'abv' },
        { text: 'Type', value: 'type'}
      ],
        }
    },
    created() {
        BreweryServices.getSingleBreweryInfo(this.$route.params.id).then(response => {
        this.results = response.data;
        })
        BeerService.getBeersByBrewery(this.$route.params.id).then(response => {
        this.beerResults = response.data;
        })
    },
    }

</script>

<style scoped>
 
</style>
