import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

      getBeersByBrewery(breweryId) {
        return http.get(`/breweries/${breweryId}/beerlist`);
      },

      getBeerInfo(beerId) {
        return http.get(`/beers/${beerId}`);
      },

      addBeer(newBeer) {
        return http.post('/beers/maintenance/addBeer', newBeer);
      },

      deleteBeer(beerId) {
          return http.post(`/beers/maintenance/deleteBeer/${beerId}`)
      },

      getBeerReviewsById(beerId) {
        return http.get(`/reviews/${beerId}`)
    },


  }