import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080"
});

export default {

      getSingleBreweryInfo(obdbId){
        return http.get(`/breweries/${obdbId}`)
      },

      getBreweriesByName(name) {
        return http.get(`/breweries/name/${name}`);
      },

      getBreweriesByCity(city) {
        return http.get(`/breweries/location/city/${city}`);
      },

      getBreweriesByState(state) {
        return http.get(`/breweries/location/state/${state}`);
      },

      getBreweriesByZipCode(zipCode) {
        return http.get(`/breweries/location/zip/${zipCode}`);
      },

      addBrewery(newBrewery) {
        return http.post('/addBrewery', newBrewery);
      },

      getBreweryDetailsById(obdbId){
        return http.get(`/breweries/${obdbId}/details`)
      },

      addBreweryDetails(addDetails) {
        return http.post('/breweries/addDetails', addDetails);
      },

      updateBreweryHistory(updateDetails) {
        return http.post('/breweries/addDetails/history', updateDetails);
      },
      
      updateBreweryImage(updateDetails) {
        return http.post('/breweries/addDetails/image', updateDetails);
      },

      updateBreweryHourOpen(updateDetails) {
        return http.post('/breweries/addDetails/hourOpen', updateDetails);
      },

      updateBreweryHourClosed(updateDetails) {
        return http.post('/breweries/addDetails/hourClosed', updateDetails);
      },

      updateBreweryOpenSun(updateDetails) {
        return http.post('/breweries/addDetails/openSun', updateDetails);
      },

      updateBreweryOpenMon(updateDetails) {
        return http.post('/breweries/addDetails/openMon', updateDetails);
      },

      updateBreweryOpenTue(updateDetails) {
        return http.post('/breweries/addDetails/openTue', updateDetails);
      },

      updateBreweryOpenWed(updateDetails) {
        return http.post('/breweries/addDetails/openWed', updateDetails);
      },

      updateBreweryOpenThu(updateDetails) {
        return http.post('/breweries/addDetails/openThu', updateDetails);
      },

      updateBreweryOpenFri(updateDetails) {
        return http.post('/breweries/addDetails/openFri', updateDetails);
      },

      updateBreweryOpenSat(updateDetails) {
        return http.post('/breweries/addDetails/openSat', updateDetails);
      },
  }
