import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/body/index'
import login from '@/components/body/login'
import reg from '@/components/body/reg'
import add from '@/components/body/add'
import edit from '@/components/body/edit'
import centre from '@/components/body/centre'
import detail from '@/components/body/detail'
import notFound from '@/components/error/404'
import mode from '@/components/body/mode'

Vue.use(Router)

//当前路由再次跳转
const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error => error)
}

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index,
      meta: {
        title: '首页',
      }
    },
    {
      path: '/login',
      name: 'login',
      component: login,
      meta: {
        title: '登录',
      }
    },
    {
      path: '/reg',
      name: 'reg',
      component: reg,
      meta: {
        title: '注册',
      }
    },
    {
      path: '/add',
      name: 'add',
      component: add,
      meta: {
        title: '发布新帖',
      }
    },
    {
      path: '/edit/'+ "postId=" + ':postId',
      name: 'edit',
      component: edit,
      meta: {
        title: '编辑帖子',
      }
    },
    {
      path: '/detail/' + "postId=" + ':postId',
      name: 'detail',
      component: detail,
      meta: {
        title: '详情页面',
      },
    },
    {
      path: '/centre/' + "userId=" + ':userId',
      name: 'centre',
      component: centre,
      meta: {
        title: '个人中心',
      }
    },

    {
      path: '/mode/' + "modeValue=" + ':modeValue',
      name: 'mode',
      component: mode,
      meta: {
        title: '小模块',
      }
    },

    //页面不存在是跳转到404页面
    {
      path: '*',
      redirect: '/404'
    },
    {
      path: '/404',
      name: 'notFound',
      component: notFound,
      meta: {
        title: '404',
      }
    },
  ]
})
