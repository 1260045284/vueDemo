import Vue from 'vue'
import router from './router'
import './plugins/axios'
import './plugins/element.js'
import App from './App.vue'

Vue.config.productionTip = false

//希望axios每次发送后台请求都带上axios
axios.interceptors.request.use(
    function(config) {
        //Authorization为发送到服务器请求头的键
      config.headers.token = window.localStorage.getItem('token');
      //console.log(token);
      return config
    },
    function(error) {
      // Do something with request error
      return Promise.reject(error)
    }
);


// 运行时写法
// new Vue({
//   router,
//   render: h => h(App)
// }).$mount('#app')
new Vue({
    el: '#app',
    components: {App},
    router,
    template: "<App/>"
});

