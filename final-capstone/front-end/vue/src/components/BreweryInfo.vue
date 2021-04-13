<template>
 <div class="brewery-info">
  
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
  <h1>{{brewery.phone}}</h1>
  </div>
  <br>
 </div>


<!-- NEW CODE WENT HERE -->

<div>

<div v-for="details in detailResults" v-bind:key="details.obdb_id">
  <v-img v-bind:src="details.image_url" max-height="175"
  max-width="900" id="bar-image"></v-img>
  </div>
  <br>

<div v-for="details in detailResults" v-bind:key="details.obdb_id" id="history">
      <h1>{{details.history}}</h1>
      <br>
  </div>




<div v-for="details in detailResults" v-bind:key="details.obdb_id" id="history">
  
      <h1>{{details.hour_open.toUpperCase()}} - {{details.hour_closed.toUpperCase()}}</h1>
      <h1>WEDNESDAY THROUGH SUNDAY</h1>
<!--      <h1>{{details.open_sun}}</h1>      <h1>{{details.open_sun}}</h1>
      <h1>{{details.open_mon}}</h1>      <h1>{{details.open_mon}}</h1>
      <h1>{{details.open_tue}}</h1>      <h1>{{details.open_tue}}</h1>
      <h1>{{details.open_wed}}</h1>      <h1>{{details.open_wed}}</h1>
      <h1>{{details.open_thu}}</h1>      <h1>{{details.open_thu}}</h1>
      <h1>{{details.open_fri}}</h1>      <h1>{{details.open_fri}}</h1>
      <h1>{{details.open_sat}}</h1>      <h1>{{details.open_sat}}</h1> -->

<br>
</div>
</div>



 <template id="tapAndList">    

   <div class="brewery-information"> 
    <h1 id="ontap">ON TAP</h1>
    <br>
   </div>  
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
          @item-expanded="getBeerReviews"
          class="elevation-1"
          >

          <template v-slot:[`item.active`]="{ item }">

              <div v-if="item.active == 'Y'">  
                Active
              </div>

              <div v-if="item.active == 'N'">  
                Inactive
              </div>

          </template>
  
          <template v-slot:expanded-item="{ headers, item }">
            <td :colspan="headers.length" id="expander">
              <div id="beerimageandinfo">
            <div class="beer-image">
                <img v-bind:src="item.image" id="beer-image">
            </div>
              <div>
                 <p class="text-info">
                   {{item.name}} 
                   {{item.type}} <br>
                   {{item.description}}
                  </p>
              </div>
              </div>

              <v-divider></v-divider>
<div id="review-container">
<template>
  <v-simple-table>
    <template v-slot:default>
      <tbody>
        <tr
          v-for="review in reviewResults"
          :key="review.username"
          >
                <td>{{review.username}} said "{{review.review_text}}"</td>

                    <td><v-rating
                :value='review.star_rating'
                :readonly="true"
                background-color="green lighten-3"
                color="green"
                size="20"
        ></v-rating></td>

        </tr>
      </tbody>
    </template>
  </v-simple-table>
</template>
</div>


            </td>
          </template>
        </v-data-table>
      </v-app>
    </template>

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
            reviewResults:[],
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
        { text: 'Active', value: 'active'},    
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
      },

      getBeerReviews({item}){
        BeerService.getBeerReviewsById(item.beer_id).then(response => {
        this.reviewResults = response.data;
        })
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
  max-width: 675px;
  margin: auto;

}
#beer-image {
  margin-left: 20px;
  margin-bottom: 15px;
  height: 110px;
  float: left;
  position: relative;
  margin-top: 15px;
}

#text-center {
  height: 30px;
  margin-top: 15px;
}

.brewery-information{
    font-family: "Syncopate";
    color: white;
    font-size: 15px;
    position: relative;
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
  padding-top: 40px;
}

.week-hours {
  font-family: "Archivo Narrow";
  font-size: 12px;
  height: 40px;
  left: 87.75%;
  position: relative;
}

#bar-image {
margin: auto;
}

#history {
  font-family: "Archivo Narrow";
  position: relative;
  font-size: 12px;
  color: white;
  max-width: 700px;
  margin: auto;

}

#beerimageandinfo {
  padding-bottom: 30px;
}

#reviewbutton {
  position: relative;
  margin: auto;
  padding-right: 100px;
}

#review-container {
 position: relative;
 padding: 9px;
}

</style>
