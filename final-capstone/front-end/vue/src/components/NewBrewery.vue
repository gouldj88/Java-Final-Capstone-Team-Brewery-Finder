<template>
<div class='new-brewery'>
<div id="NewBreweryForm">

<form> 
    <p> Brewery Name: </p>
    <input type="text" v-model="inputName"> <br>
    <p> Street Name: </p>
    <input type="text" v-model="inputStreet"> <br>
    <p> City: </p>
    <input type="text" v-model="inputCity"><br>
    <p> State: </p>
    <input type="text" v-model="inputState"><br>
    <p> Zip Code: </p>
    <input type="text" v-model="inputZip"><br>
    <p> URL: </p>
    <input type="text" v-model="inputURL"><br>
    <p> Phone Number: </p>
    <input type="text" v-model="inputPhoneNumber"><br>
    <p> UserName: </p>
    <input type="text" v-model="inputBreweryUserName"><br>
    <br>
    <input type="button" value="Add Brewery" v-on:click="addBrewery()" />
 </form>



</div>
</div>
</template>

<script>

</script>

<style scoped>
.NewBreweryForm {
    display: grid;
    grid-template-columns: 1fr 1fr;
}


</style>