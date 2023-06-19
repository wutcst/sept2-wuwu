import Vue from 'vue'
import VueRouter from 'vue-router'


//添加以下代码
/* const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
} */

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    /* redirect:'../views/login.vue', */
    component: () => import('@/views/login')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/login')
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('../views/register.vue')
  },
  {
    path: '/main',
    name: 'main',
    component: () => import('../views/main.vue')
  },
  
]

const router = new VueRouter({
  routes
})


export default router
