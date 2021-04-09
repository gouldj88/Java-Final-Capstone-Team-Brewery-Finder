import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import VueSimpleAlert from 'vue-simple-alert';
import vuetify from './plugins/vuetify';

Vue.use(VueSimpleAlert);

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')


