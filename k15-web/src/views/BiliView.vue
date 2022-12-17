<template>
  <div >
    <el-container>
      <el-header>
        <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
          <el-row type="flex" class="row-bg" justify="center" align="middle">
            <el-col class="img" :span="4">
              <img src="@/assets/image/logo.png" height="40" />
            </el-col>
            <el-col  :span="1">
              <el-menu-item index="1"><B>首页</B></el-menu-item>
            </el-col>
            <el-col  :span="1">
              <el-menu-item index="2"><B>电影</B></el-menu-item>
            </el-col>
            <el-col  :span="1">
              <el-menu-item index="3"><B>片剧</B></el-menu-item>
            </el-col>
            <el-col  :span="1">
              <el-menu-item index="4"><B>动漫</B></el-menu-item>
            </el-col>
            <el-col  :span="1">
              <el-menu-item index="5"><B>综艺</B></el-menu-item>
            </el-col>
            <el-col  :span="1">
              <el-menu-item index="6"><B>舞蹈</B></el-menu-item>
            </el-col>
            <el-col  :span="1">
              <el-menu-item index="7"><B>资讯</B></el-menu-item>
            </el-col>
            <el-col  :span="6">
              <el-form :inline="true" class="demo-form-inline">
                <div style="margin-top: 15px">
                  <el-form-item size="small" label="">
                    <el-input size="small" v-model="moveName" placeholder="请输入片名" class="input-with-select">
                      <el-button slot="append" icon="el-icon-search" >查找</el-button>
                    </el-input>
                  </el-form-item>
                </div>
              </el-form>
            </el-col>
            <el-col  :span="1">
              <el-link  type="warning"><B><i class="el-icon-time"></i></B></el-link>
            </el-col>
          </el-row>
        </el-menu>
      </el-header>
      <el-main class="el-main">
        <div class="el-main-first">
          <el-row type="flex" class="row-bg" justify="center" align="middle">
            <el-col  :span="1">
              <el-link  type="warning"><B><i class="el-icon-bell"></i></B></el-link>
            </el-col>
            <el-col  :span="23">
               {{msg}}
            </el-col>
          </el-row>
        </div>
        <div class="el-main-second">
          <el-row type="flex" class="row-bg" justify="center" align="middle">
            <el-col  :span="14">
              <div class="block">
                <span class="demonstration"></span>
                <el-carousel height="">
                  <el-carousel-item v-for="item in imgList" :key="item">
                      <img alt="" :src=item.imgSrc />
                  </el-carousel-item>
                </el-carousel>
              </div>
            </el-col>
            <el-col  :span="10">
<!--              <el-row type="flex" class="row-bg" justify="center" align="middle">1-->

<!--              </el-row>-->
              <el-row type="flex" class="row-bg" justify="center" align="middle">
                  <el-col  :span="6" class="moreOne"><el-button class="row-bb" type="warning">最新韩剧</el-button></el-col>
                  <el-col  :span="6" class="moreOne"><el-button class="row-bb" type="warning">最新日剧</el-button></el-col>
                  <el-col  :span="6" class="moreOne"><el-button class="row-bb" type="warning">最新美剧</el-button></el-col>
                  <el-col  :span="6" class="moreOne"><el-button class="row-bb" type="warning">最新英剧</el-button></el-col>
              </el-row>
              <el-row type="flex" class="row-bg" justify="center" align="middle">
                <el-col  :span="6" class="moreOne"><el-button class="row-bb" type="warning">新微电影</el-button></el-col>
                <el-col  :span="6" class="moreOne"><el-button class="row-bb" type="warning">新记录片</el-button></el-col>
                <el-col  :span="6" class="moreOne"><el-button class="row-bb" type="warning">火热综艺</el-button></el-col>
                <el-col  :span="6" class="moreOne"><el-button class="row-bb" type="warning">院线新片</el-button></el-col>
              </el-row>
              <el-row type="flex" class="row-bg el-main code" justify="center" align="middle" >
                <el-col  :span="12" >
                  <img id="code" src="../assets/img/code.png" height="144px" />
                </el-col>
                <el-col  :span="12" >
                  <el-row  justify="center" align="middle">
                    <el-col id="qidai" :span="12" >
                      <img   src="../assets/img/qidai.png" height="144px" />
                    </el-col>
                  </el-row>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </div>
        <div class="el-main-three">
          <el-row type="flex" class="row-bg" justify="center" align="middle">
            <el-col  :span="14">
              <el-tag class="icon" type="danger"><B>VIP电影网推荐</B></el-tag>
            </el-col>
            <el-col  :span="10" class="more">
              <el-link class="more" type="danger"><B>更多......</B></el-link>
            </el-col>
          </el-row>
        <el-row type="flex" class="row-bg" justify="center" align="middle">
          <el-divider></el-divider>
        </el-row>

        <el-row type="flex" class="row-bg" justify="center" align="middle" >
          <el-col  :span="8" class="more" >
            <el-card :body-style="{ padding: '0px' }" shadow="hover" >
<!--              <video height="300px" width="360px"></video>-->
              <img  height="300px" width="360px" src="../assets/img/5.png"  />
              <div style="padding: 14px;" height="80px">
                <el-row  >
                  <div class="tex"><B>重启地球</B></div>
                </el-row>
                <el-row >
                  <div class="tex-1">
                    <span>凡人之躯拯救地球</span>
                  </div>
                </el-row>
              </div>
            </el-card>
          </el-col>
          <el-col  :span="16" class="more">
            <el-row type="flex" class="row-bg" justify="center" align="middle">
              <el-col  :span="6" class="more" >
                <el-card :body-style="{ padding: '0px' }" shadow="hover" class="moreOne">
<!--                  <video height="100px" ></video>-->
                  <img  height="100px" src="../assets/img/6.png"  />
                  <div style="padding: 14px;">
                    <el-row  >
                      <div class="tex"><B>羞羞的铁拳</B></div>
                    </el-row>
                    <el-row >
                      <div class="tex-1">
                        <span>开心麻花第三部电影</span>
                      </div>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col  :span="6" class="more" >
                <el-card :body-style="{ padding: '0px' }" shadow="hover" class="moreOne">
                  <!--                  <video height="100px" ></video>-->
                  <img  height="100px" src="../assets/img/7.png"  />
                  <div style="padding: 14px;">
                    <el-row  >
                      <div class="tex"><B>中国医生</B></div>
                    </el-row>
                    <el-row >
                      <div class="tex-1">
                        <span>向医护人员致敬</span>
                      </div>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col  :span="6" class="more" >
                <el-card :body-style="{ padding: '0px' }" shadow="hover" class="moreOne">
                  <!--                  <video height="100px" ></video>-->
                  <img  height="100px" src="../assets/img/8.png"  />
                  <div style="padding: 14px;">
                    <el-row  >
                      <div class="tex"><B>暴疯语</B></div>
                    </el-row>
                    <el-row >
                      <div class="tex-1">
                        <span>刘青云黄晓明对戏</span>
                      </div>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col  :span="6" class="more" >
                <el-card :body-style="{ padding: '0px' }" shadow="hover" class="moreOne">
                  <!--                  <video height="100px" ></video>-->
                  <img  height="100px" src="../assets/img/9.png"  />
                  <div style="padding: 14px;">
                    <el-row  >
                      <div class="tex"><B>荡寇风云</B></div>
                    </el-row>
                    <el-row >
                      <div class="tex-1">
                        <span>纵横无敌威震天下</span>
                      </div>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row type="flex" class="row-bg" justify="center" align="middle">
              <el-col  :span="6" class="more" >
                <el-card :body-style="{ padding: '0px' }" shadow="hover" class="moreOne">
                  <!--                  <video height="100px" ></video>-->
                  <img  height="100px" src="../assets/img/10.png"  />
                  <div style="padding: 14px;">
                    <el-row  >
                      <div class="tex"><B>太平轮·彼岸 1949</B></div>
                    </el-row>
                    <el-row >
                      <div class="tex-1">
                        <span>章子怡乱世之情</span>
                      </div>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col  :span="6" class="more" >
                <el-card :body-style="{ padding: '0px' }" shadow="hover" class="moreOne">
                  <!--                  <video height="100px" ></video>-->
                  <img  height="100px" src="../assets/img/11.png"  />
                  <div style="padding: 14px;">
                    <el-row  >
                      <div class="tex"><B>一句顶一万句</B></div>
                    </el-row>
                    <el-row >
                      <div class="tex-1">
                        <span>Someone to Talk to</span>
                      </div>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col  :span="6" class="more" >
                <el-card :body-style="{ padding: '0px' }" shadow="hover" class="moreOne">
                  <!--                  <video height="100px" ></video>-->
                  <img  height="100px" src="../assets/img/12.png"  />
                  <div style="padding: 14px;">
                    <el-row  >
                      <div class="tex"><B>何以笙箫默</B></div>
                    </el-row>
                    <el-row >
                      <div class="tex-1">
                        <span>制服杨幂诱惑</span>
                      </div>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col  :span="6" class="more" >
                <el-card :body-style="{ padding: '0px' }" shadow="hover" class="moreOne">
                  <!--                  <video height="100px" ></video>-->
                  <img  height="100px" src="../assets/img/13.png"  />
                  <div style="padding: 14px;">
                    <el-row  >
                      <div class="tex"><B>边缘行者</B></div>
                    </el-row>
                    <el-row >
                      <div class="tex-1">
                        <span>生死兄弟快意恩仇</span>
                      </div>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
        </div>
      </el-main>
      <el-footer class="footer">
        <div class="el-footer-first">
          <el-row type="flex" class="row-bg" justify="center" align="middle">
            <el-col>
              CopyRight © 2022 电影中心官方网站| 某ICP证123456
            </el-col>
          </el-row>
        </div>
      </el-footer>
    </el-container>

  </div>
</template>

<script>
export default {
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      moveName:"",
      msg:"提供最新最全免费VIP电影，电视剧，动漫、综艺节目。每日更新，如果播放不了请留言。",
      imgList: [
        {id: 1, imgSrc: require("../assets/img/1.jpg")},
        {id: 2, imgSrc: require("../assets/img/2.jpg")},
        {id: 3, imgSrc: require("../assets/img/3.jpg")},
        {id: 4, imgSrc: require("../assets/img/4.jpg")},
      ]
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}

</script>
<!-- scoped 让定义的样式，仅仅在当前组件有戏 -->
<style scoped>
  .el-header {
    padding: 0px;
  }
  .el-menu-demo{
    text-align:center
  }
  .img{
    text-align:left
  }
  .demo-form-inline{
    text-align:right
  }
  el-menu-item{

  }
  .el-icon-time{
    font-size:25px;
  }
  .el-main{
    background-color:rgba(215,213,214,0.4);
    padding-left: 200px ;
    padding-right: 200px ;
  }
  .el-main-first{
    background-color:rgb(255,255,253);
    padding:18px;
  }
  .el-main-second{
    margin-top: 20px;
    background-color:rgb(255,255,253);
    padding:18px;
  }
  .el-main-three{
    margin-top: 20px;
    background-color:rgb(255,255,253);
    padding:18px;
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
  .icon{
    text-align:center
  }
  .more{
    text-align:right;
  }
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
  .moreOne{
    margin-top: 8px;
    margin-bottom: 8px;
    margin-left: 8px;
  }
  .code{
    margin-left: 8px;
    margin-right: 8px;
  }
  .imgCode{
    margin: 0;
  }
  #icon_13{
    float: right;
  }
  #code{
    margin-left: -150px;
  }
  .footer{
    background-color:rgba(215,213,214,0.4);
    padding-left: 200px ;
    padding-right: 200px ;
    text-align:center
  }
  .row-bb{
    background-color: #69b3f0;
    border-color:  #69b3f0;
  }
  .row-bb:hover{
    background-color: red;
    border-color:  red;
  }
  .tex{
    text-align:left;
  }
  .tex-1{
    margin-top: 12px;
    text-align:left;
    font-size: 9px;
  }
  #qidai{
    margin-left: 20px;
  }
</style>