import Vue from 'vue'
import axios from 'axios'

const username = 'personapi'
const password = 'passworddefault'
const token = Buffer.from(`${username}:${password}`, 'utf8').toString('base64')

Vue.use({
  install(Vue) {
    Vue.prototype.$http = axios.create({
      baseURL: 'http://localhost:8080/',
      headers: {
        Authorization: `Basic ${token}`
      }
    })
  }
})