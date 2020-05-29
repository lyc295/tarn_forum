<template>
  <div id="app">
    <app-headers v-if="headers_show"></app-headers>
    <app-navigation v-if="navigation_show"></app-navigation>
    <router-view v-on:headers="headers" v-on:footers="footers"  v-on:navigation="navigation"></router-view>
    <app-footers v-if="footers_show"></app-footers>
  </div>
</template>

<script>
  import headers from './components/assembly/headers'
  import navigation from './components/assembly/navigation'
  import footers from './components/assembly/footers'

  export default {
    name: 'App',
    data() {
      return {
        headers_show: true,
        navigation_show: true,
        footers_show: true,
      }
    },
    watch:{
      $route(next,prev){
        if(next.name == 'centre' || next.name == 'login' || next.name == 'reg'){
          this.navigation_show = false
        }else{
          this.navigation_show = true
        }
      }
    },
    components: {
      'app-headers': headers,
      'app-navigation': navigation,
      'app-footers': footers,
    },
    methods: {
      //是否显示头部
      headers: function (bool) {
        this.headers_show = bool;
      },
      //是否显示导航栏
      navigation: function (bool) {
        this.navigation_show = bool;
      },
      //是否显示底部
      footers: function (bool) {
        this.footers_show = bool;
      }
    }
  }
</script>
