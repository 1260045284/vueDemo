<template>
  <div >
    <!-- 导航开始 -->
    <el-row>
      <el-col :span="24">
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>管理</el-breadcrumb-item>
          <el-breadcrumb-item>列表</el-breadcrumb-item>
        </el-breadcrumb>
      </el-col>
    </el-row>
    <!-- 导航结束 -->


  </div>
</template>

<script>
export default {
  mounted() {

  },
  created(){
  // //和风天气插件调用
  // window.WIDGET = {
  //   "CONFIG": {
  //     "modules": "01234",
  //     "background": "5",
  //     "tmpColor": "FFFFFF",
  //     "tmpSize": "16",
  //     "cityColor": "FFFFFF",
  //     "citySize": "16",
  //     "aqiColor": "FFFFFF",
  //     "aqiSize": "16",
  //     "weatherIconSize": "24",
  //     "alertIconSize": "18",
  //     "padding": "10px 10px 10px 10px",
  //     "shadow": "0",
  //     "language": "auto",
  //     "fixed": "false",
  //     "vertical": "top",
  //     "horizontal": "left",
  //     "key": "ec8e2727d25b490a831b3271cb9596f4"
  //   }
  // };
  // (function (d) {
  //   var c = d.createElement('link');
  //   c.rel = 'stylesheet';
  //   c.href = 'https://widget.heweather.net/simple/static/css/he-simple.css?v=1.4.0';
  //   var s = d.createElement('script');
  //   s.src = 'https://widget.heweather.net/simple/static/js/he-simple.js?v=1.4.0';
  //   var sn = d.getElementsByTagName('script')[0];
  //   sn.parentNode.insertBefore(c, sn);
  //   sn.parentNode.insertBefore(s, sn);
  // })(document);
},
}

</script>
<!-- scoped 让定义的样式，仅仅在当前组件有戏 -->
<style scoped>

</style>