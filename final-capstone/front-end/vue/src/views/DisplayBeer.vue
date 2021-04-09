<template>
  <div class="beer-list">
     <beer-list/>

  </div>
</template>
<script>

import beerList  from '@/components/beerList';
export default {
  name: beerList,
  data () {
    return {

    };
  },
  components: {
    beerList
  }
}


</script>

