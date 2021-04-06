<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <brewery-list />
  </div>
</template>

<script>

import BreweryList from '@/components/BreweryList.vue';

export default {
  name: 'Home',
  components: {
      BreweryList
  }
}
</script>
