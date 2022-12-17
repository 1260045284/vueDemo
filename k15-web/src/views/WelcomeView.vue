<template>
  <div id="first">
    <div v-for="(item,i) in vedioList" :key="i">

<!--      <video muted="muted" :id="startvideo+i" class="video" :src="item.path" type="video/mp4" poster="false.png" autoplay="autoplay" controls="controls" loop="-1">-->
<!--        <p>你的浏览器不支持video标签.</p>-->
<!--      </video>-->
      <video muted="muted"  class="video" src="../assets/file/1.mp4" type="video/mp4"  autoplay="autoplay" controls="controls" loop="-1">
                <p>你的浏览器不支持video标签.</p>
              </video>
    </div>
  </div>
</template>

<script>
    export default {
        name: 'WelcomeView',
        data: function() {
            return {
                isOk: true,
                vedioList: [{ path: "http://vjs.zencdn.net/v/oceans.mp4" }],
                count:0,
            }
        },
      methods:{
        start(){
          setInterval(this.hideArea, 100); // 注意: 第一个参数为方法名的时候不要加括号;
        },
        hideArea() {
          this.count++;
          if(this.count==620 && this.$router.currentRoute.path=="/home"){
            this.$router.push({name: 'bili'});
          }
        },

      },
      created: function() {
        this.start();
      },
      mounted() {

      }
    }
</script>

<style scoped>

    .video {
      object-fit: fill;
      width: 100%;
      height: 659px;
    }
</style>