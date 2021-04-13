<template>
  <div class="review-list">
    <h1>Beer Reviews</h1>
    <review-list/>
  </div>
</template>

<script>

import ReviewList from '../components/ReviewList.vue';

export default {
  name: 'review-list',
  data() {
    return {
    };
  },
  components: {
      ReviewList
  }
}

</script>