<template>
  <div class="addBrewery">
    <h1>Add a New Brewery</h1>
    <new-brewery />
  </div>
</template>

<script>

import NewBrewery from '@/components/NewBrewery.vue';

export default {
  name: 'addBrewery',
  data() {
    return {
    };
  },
  components: {
      NewBrewery
  }
}
</script>