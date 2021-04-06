import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

      getBreweriesByName(name) {
        return http.get(`/breweries/name/${name}`);
      },

      getBreweriesByCity(city) {
        return http.get(`/breweries/name/${city}`);
      },

      getBreweriesByState(state) {
        return http.get(`/breweries/name/${state}`);
      },

      getBreweriesByZipCode(zipCode) {
        return http.get('/breweries/name/98402');
      },

      getBreweriesByName() {
        return http.get('/topics');
      }
  }
