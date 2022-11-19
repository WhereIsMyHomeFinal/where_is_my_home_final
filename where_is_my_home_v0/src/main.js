import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import "@/api/lib/fontAwesomeIcon.js"; // fontAwesomeIcon.js 불러옴
import "@/api/lib/vueBootstrap.js";

import DashboardPlugin from './plugins/dashboard-plugin';
// plugin setup
Vue.use(DashboardPlugin);

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
