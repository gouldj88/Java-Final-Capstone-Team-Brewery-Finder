<template>
  <div class="reviews">
    <review-display
      v-for="review in filteredReviews"
      v-bind:key="review.title"
      v-bind:review="review"
    />
  </div>
</template>

<script>
import ReviewDisplay from "./ReviewList.vue";

export default {
  name: "review-list",
  components: {
    ReviewDisplay
  },
  computed: {
    filteredReviews() {
      const activeProduct = this.$store.state.products.find(
        p => p.id == this.$store.state.activeProduct
      );
      const reviewsFilter = this.$store.state.filter;
      return activeProduct.reviews.filter(review => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.rating;
      });
    }
  }
};
</script>

<style>

</style>
