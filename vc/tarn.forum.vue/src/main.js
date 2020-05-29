// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import myUtils from './utils/myUtils'
import title from 'vue-wechat-title'
import layer from 'layui-layer'
import './utils/ajax'

Vue.prototype.$baseUrl = process.env.API_HOST
Vue.use(title)
Vue.prototype.layer = layer
Vue.prototype.myUtils = myUtils
Vue.prototype.$ajax = axios
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'

})





