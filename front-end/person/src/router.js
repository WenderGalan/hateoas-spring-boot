import Vue from 'vue'
import Router from 'vue-router'
import PersonTable from './components/person/PersonTable'
import About from './components/About'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    { path: '/', component: PersonTable },
    { path: '/about', component: About }
  ]
})