import {router} from './router/Router'

// Create vue instance with our router, and mount onto #app
var vue = new Vue({router});
var app = vue.$mount('#app');