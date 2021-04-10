<template>
  <div class="brewery-info">
    <h1>Brewery Information</h1>
    <brewery-info />
  </div>
</template>

<script>

import BreweryInfo from '@/components/BreweryInfo.vue';

export default {
  name: 'brewery-info',
  data() {
    return {
    };
  },
  components: {
      BreweryInfo
  }
}

</script>
