import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router";
import { createPinia } from 'pinia';
// @ts-ignore
import vClickOutside from "click-outside-vue3";


const app = createApp(App).use(router).use(vClickOutside)
const pinia = createPinia();
app.use(pinia);
app.mount('#app')
