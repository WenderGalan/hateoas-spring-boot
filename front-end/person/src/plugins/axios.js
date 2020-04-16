import Vue from 'vue'
import axios from 'axios'

const username = 'personapi'
const password = 'passworddefault'
const token = Buffer.from(`${username}:${password}`, 'utf8').toString('base64')

Vue.use({
  install(Vue) {
    Vue.prototype.$http = axios.create({
      baseURL: 'https://person-vue-spring-boot.herokuapp.com',
      headers: {
        Authorization: `Basic ${token}`
      }
    })
  }
})