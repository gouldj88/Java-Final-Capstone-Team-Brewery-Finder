<template>
 <div class="brewery-info">
    <v-btn
          color="#1B5E20"
          dark
          v-bind="attrs"
          v-on="on"
          id="register"
        >
          ADD A BEER
        </v-btn>
            <v-btn
          color="#1B5E20"
          dark
          v-bind="attrs"
          v-on="on"
          id="register"
        >
          UPDATE BREWERY INFORMATION
        </v-btn> 
 <div v-for="brewery in results" v-bind:key="brewery.name" class="brewery-information">
  <div class="brewery-name"> 
  <h1>{{brewery.name.toUpperCase()}}</h1>
  </div>
  <div class="brewery-address-etc">
  <h1>{{brewery.street.toUpperCase()}}</h1>
  <h1>{{brewery.city.toUpperCase()}}, 
      {{brewery.state.toUpperCase()}}
      {{brewery.postal_code.toUpperCase()}}</h1>
  <h1>{{brewery.website_url}}</h1>
  </div>
  <div class="brewery-phone">
  <h1>{{brewery.phone}}</h1>
  <br>
 </div>
 </div>

 <template>      
      <v-app id="inspire">
        <v-data-table
          :headers="headers"
          :items="beerResults"
          :single-expand="true"
          :items-per-page="10"
          item-key="name"
          show-expand
          hide-default-header
          hide-default-footer
          class="elevation-1"
          >
  
          <template v-slot:expanded-item="{ headers, item }">
            <td :colspan="headers.length">
              <div>
              <div>
                 <p class="text-info">
                   {{item.name}} 
                   {{item.type}} <br>
                   {{item.description}}
                  </p>
              </div>
            <div class="beer-image">
           <img v-bind:src="item.image" id="beer-image">
            </div>
          </div>

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
#inspire {
  font-family: "Archivo Narrow";

}
#beer-image {
  margin-bottom: 15px;
  height: 110px;
  float: left;
  position: relative;
  margin-top: 15px;
}

#text-center {
  height: 30px;
  float: center;
  margin-top: 15px;
}

.brewery-information{
    color: white;
    font-size: 15px;
    position: relative;
    margin: auto;
}

.brewery-address-etc{
  font-family: "Abel";
  font-size: 60%;
}

.brewery-name {
  font-family: "Syncopate";
  font-size: 200%;

}
.brewery-phone {
  font-family: "Syncopate";
  font-size: 60%

}
.text-info{
  font-family: "Archivo Narrow";
  font-size: 15px;
  float: right;
  padding-top: 40px;
}

/*.text-desc {
  font-family: "Verdana";
  font-size: 15px
}

.text-type {
  font-family: "Verdana";
  font-size: 15px
  float right;
  
}
*/

</style>
