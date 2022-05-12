import Vue from 'vue'
import VueRouter from 'vue-router'
import MainPage from '../views/MainPage.vue'
import LoginPage from "../views/LoginPage.vue"
import RegisterPage from "../views/RegisterPage.vue"
import UserPage from "../views/UserPage.vue"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'main',
    component:MainPage 
  },
  {
    path: '/login',
    name: 'login',
    component:LoginPage
  },
  {
    path: '/register',
    name: 'register',
    component:RegisterPage
  },
  {
    path: '/user',
    name: 'user',
    component:UserPage
  }
]

const router = new VueRouter({
  mode:'history',
  routes
})

export default router
