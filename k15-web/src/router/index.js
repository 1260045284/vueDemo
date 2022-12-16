import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue' // @ 相当于src的绝对路径

Vue.use(VueRouter)

// path的路径一定是跟在 #后面的
const routes = [                    
  { path: '/', redirect: '/login'},
  { path: '/login', name: 'login', component: () => import('../views/Login.vue')},
  { path: '/home', name: 'home', component: HomeView, 
        children : [
            {path:'', name: 'welcome', component: () => import('../views/WelcomeView.vue')},
            {path: '/welcome', name: 'welcomeAgain', component: () => import('../views/WelcomeAgain.vue') },
            {path: '/teacher', name: 'teacher', component: () => import('../views/TeacherView.vue')},
            {path: '/user', name: 'user', component: () => import('@/views/UserView.vue') }
        ]
    }
]

const router = new VueRouter({
  routes
})

export default router

// to：路由对象，即将要进入的目标
// from：表示从哪里来
// next：回调函数，通过 next 回调函数你可以让 vue-router 去处理导航、取消导航、重定向到其它地方或执行其它操作。
// 配置路由守卫
router.beforeEach((to, from, next) => {
    // 是否是去登录
    if(to.path == '/login') {
        // 如果要去登录，直接放行
        next();
    } else {
        let token = window.localStorage.getItem('token');

        // token不存在，去登录
        if(!token) {
            next('/login')
            return;
        }
        
        let expTime = JSON.parse(atob(token.split('\.')[1])).exp;
        let nowtime = (new Date()).getTime() / 1000;
        if(nowtime >= expTime) { // 如果过期，去登录
            next('/login');
        } else {    // 否则放行
            next();
        }
    }
});