import Vue from 'vue'
import axios from 'axios'

const username = 'personapi'
const password = 'passworddefault'
const token = Buffer.from(`${username}:${password}`, 'utf8').toString('base64')

Vue.use({
  install(Vue) {
    Vue.prototype.$http = axios.create({
      // Ou irá pegar a URL do netlify ou acessar a API do docker
      baseURL: process.env.API_URL || 'http://localhost:4000',
      headers: {
        Authorization: `Basic ${token}`
      }
    })
  }
})