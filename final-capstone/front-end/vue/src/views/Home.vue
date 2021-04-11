<template>
  <div class="home">
    <brewery-list />
  </div>
</template>

<script>

import BreweryList from '@/components/BreweryList';

export default {
  name: 'Home',
  data() {
    return {
    };
  },
  components: {
      BreweryList
  }
}
</script>

<style>

button.page-link {
	display: inline-block;
}
button.page-link {
    font-size: 20px;
    color: #29b3ed;
    font-weight: 500;
}
.offset{
  width: 500px !important;
  margin: 20px auto;  
}

</style>