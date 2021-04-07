<template>
<div class='new-brewery'>
<div id="NewBreweryForm">

<form> 
    <p> Brewery Name: </p>
    <input type="text" v-model="newBrewery.name"> <br>
    <p> Street Name: </p>
    <input type="text" v-model="newBrewery.street"> <br>
    <p> City: </p>
    <input type="text" v-model="newBrewery.city"><br>
    <p> State: </p>
    <input type="text" v-model="newBrewery.state"><br>
    <p> Zip Code: </p>
    <input type="text" v-model="newBrewery.postal_code"><br>
    <p> URL: </p>
    <input type="text" v-model="newBrewery.website_url"><br>
    <p> Phone Number: </p>
    <input type="text" v-model="newBrewery.phone"><br>
    <p> UserName: </p>
    <input type="text" v-model="newBrewery.username"><br>
    <br>
    <input type="button" value="Add Brewery" v-on:click="addBrewery()" />
 </form>



</div>
</div>
</template>

<script>

import breweryService from '../services/BreweryServices';

export default {
  data() {
    return {
       newBrewery: {
        name: "",
        street: "",
        city: "",
        state: "",
        postal_code: "",
        website_url: "",
        phone: "",
        username: ""
       }
    };
  },
  methods: {
    addBrewery(){
      breweryService.addBrewery(this.newBrewery).then(response => {  // send the API response to a function 
      if(response.status === 201) { // if post was successful (HTTP status 201)
          console.log("This worked wonderfully! Hurrah!");
    }
  })
}
}
}
</script>

<style scoped>
.NewBreweryForm {
    display: grid;
    grid-template-columns: 1fr 1fr;
}


</style>