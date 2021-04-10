<template>
  <div class="breweryInfo">
    <h1>Brewery Information</h1>
    <brewery-info />
  </div>
</template>

<script>

import BreweryInfo from '@/components/BreweryInfo.vue';

export default {
  name: 'goofyGoober',
  data() {
    return {
    };
  },
  components: {
      BreweryInfo
  }
}

</script>
