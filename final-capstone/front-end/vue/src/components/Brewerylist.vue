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
