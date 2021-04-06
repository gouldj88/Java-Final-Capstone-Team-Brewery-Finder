<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <brewery-list />
  </div>
</template>

<script>

import Brewerylist from '@/components/Brewerylist.vue';

export default {
  name: "home",
  components: {
      Brewerylist
  }
}
</script>
