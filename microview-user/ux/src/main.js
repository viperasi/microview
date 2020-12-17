import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import { AXIOS } from './components/http-common'

Vue.prototype.$axios = AXIOS
Vue.config.productionTip = false

let instance = null

function render() {
    instance = new Vue({
        vuetify,
        render: h => h(App)
    }).$mount('#app')
}

if (!window.__POWERED_BY_QIANKUN__) {
    render()
}

export async function bootstrap() {
    // eslint-disable-next-line no-console
    console.log('vue app bootstraped')
}

export async function mount(props) {
    // eslint-disable-next-line no-console
    console.log('props from main framework', props)
    render()
}

export async function unmount() {
    instance.$destroy()
    instance = null
}