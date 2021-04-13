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
 </div>
 </div>


<!-- NEW CODE WENT HERE -->


<div v-for="details in detailResults" v-bind:key="details.obdb_id" class="brewery-information">
<div class="history">
      <h1>{{details.history.toUpperCase()}}</h1>
  </div>
  </div>



<div v-for="details in detailResults" v-bind:key="details.obdb_id" class="brewery-information">
  
    <div class="week-hours">
      <h1>{{details.hour_open.toUpperCase()}}</h1>
      <h1>{{details.hour_closed.toUpperCase()}}</h1>
      <h1>{{details.open_sun}}</h1>
      <h1>{{details.open_mon}}</h1>
      <h1>{{details.open_tue}}</h1>
      <h1>{{details.open_wed}}</h1>
      <h1>{{details.open_thu}}</h1>
      <h1>{{details.open_fri}}</h1>
      <h1>{{details.open_sat}}</h1>
  </div>
</div>

<div v-for="details in detailResults" v-bind:key="details.obdb_id" class="brewery-information">
<div class="jeffs-pic">
  <img v-bind:src="details.image_url" id="bar-image">
  </div>
  </div>
<br>



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


   name: "brewery-informazione",

    data (){
        return{
            results: [],
            beerResults: [],
            detailResults:[],
            headers: [
        {
          text: 'Beer',
          align: 'start',
          sortable: false,
          value: 'name'
        },
        { text: 'Brewery', value: 'brewery' },
        { text: 'ABV', value: 'abv' },
        { text: 'Type', value: 'type'},   
            ]
        }
    },

    methods: {
      userCheck() {
      return this.$store.state.user.authorities[0].name;
      },

     usernameCheck(){
      return this.$store.state.user.username;
      },

      breweryOwnerCheck(){
      return this.results[0].username;
      }
    },

    created() {
        BreweryServices.getSingleBreweryInfo(this.$route.params.id).then(response => {
        this.results = response.data;
        })
        BreweryServices.getBreweryDetailsById(this.$route.params.id).then(response => {
        this.detailResults = response.data;
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

#maPetiteLemke {
  float: right;
}


.week-hours {
  font-family: "Archivo";
  font-size: 12px;
  height: 40px;
  left: 87.75%;
  position: absolute;
}

.jeffs-pic {

  width: 70%;
  height: 20%;
  margin: auto;
}
  
.history {
  font-family: "archivo";
  position: absolute;
  font-size: 12px;
  width: 20%;
  padding-right: 40px;


}


</style>
