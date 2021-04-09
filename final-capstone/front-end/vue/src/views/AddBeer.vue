<template>
  <div class="addBeer">
    <h1>Add a New Beer</h1>
    <new-beer />
  </div>
</template>

<script>

import NewBeer from '@/components/NewBeer.vue';

export default {
  name: 'addBeer',
  data() {
    return {
    };
  },
  components: {
      NewBeer
  }
}

</script>
