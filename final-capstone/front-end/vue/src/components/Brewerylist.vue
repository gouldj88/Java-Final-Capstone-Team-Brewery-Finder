<template>
    <div class='brewery-list'>
        <div v-for="brewery in results" v-bind:key="brewery.name" class="brewery">
                {{ brewery.name }}
                
    </div>
  </div>


</template>

<script>
import BreweryServices from '@/services/BreweryServices.js';

export default{
name: 'brewery-list',

data () {
    return {
        results: []
    }
},
created() {
        BreweryServices.getBreweriesByZipCode().then(response => {
            this.results = response.data;
    })
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

</style>
