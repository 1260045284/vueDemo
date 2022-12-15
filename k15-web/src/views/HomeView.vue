<template>
    <div id="home-main">
        <el-container>
            <el-header>
                <el-row type="flex" class="row-bg" justify="center" align="middle">
                    <el-col class="img" :span="4">
                        <img src="@/assets/image/logo.png" height="40" />
                    </el-col>
                    <el-col :span="3">
                      <h2><el-link type="danger"><B> {{smiles[value%smiles.length]}}</B></el-link></h2>
                    </el-col>
                  <el-col :span="2" class="gg">
                    <h3> <B>公告 :</B> <el-link type="warning"><i class="el-icon-message-solid"  ></i></el-link>&nbsp;&nbsp;&nbsp;</h3>
                  </el-col>
                  <el-col :span="11" class="msg" >
                     {{msg.replaceAll("龘","&nbsp&nbsp&nbsp")}}
                  </el-col>
                  <div id="he-plugin-simple"></div>
                    <el-col :span="3">
                        <h4>欢迎您: <el-link type="danger"><B>{{username}}</B></el-link></h4>
                    </el-col>
                  <el-avatar v-popover:popover class="avatar"  :size="size" :src=user.avatar> </el-avatar>
                    <el-popover :span="5"
                        ref="popover"
                        placement="top-start"
                        title=""
                        width="20px"
                        trigger="hover"
                        content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。">

                      <el-badge :value="2"  type="warning">
                        <el-button  size="mini" type="success" round icon="el-icon-message" @click="btnLogout"></el-button>
                      </el-badge>

                      <el-badge :value="null" class="meg" type="warning">
                        <el-button  size="mini"  type="primary" round icon="el-icon-edit" @click="btnLogout"></el-button>
                      </el-badge>

                      <el-badge :value="null" class="meg" type="warning">
                        <el-button type="danger" size="mini" round icon="el-icon-close" @click="btnLogout"></el-button>
                      </el-badge>

                    </el-popover>
                </el-row>
            </el-header>

            <el-container>
                <el-aside width="200px">
                    <el-menu 
                        default-active="1"
                        class="el-menu-vertical-demo"
                        background-color="#545c64"
                        text-color="#fff"
                        active-text-color="#ffd04b"
                        router
                        >

                        <el-submenu :index="menu.id+''"  v-for="menu in menuItem" :key="menu.id">
                            <template slot="title">
                                <i :class="menu.icon"></i>
                                <span>{{menu.name}}</span>
                            </template>
                            <el-menu-item-group>
                                <el-menu-item :index="childer.link"  v-for="childer in menu.childerList" :key="childer.id">{{childer.name}}</el-menu-item>
                            </el-menu-item-group>
                        </el-submenu>

                    </el-menu>
                </el-aside>

                <el-main>
                    <!--子路由-->
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: 'HomeView',
        data: function() {
            return {
                username: "",
                user:{avatar:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"},
                menuItem:[], //接收用户的菜单数据
                size:"small",
                timer: "",
                value: 0,
                smiles: ["(＝^ω^＝)","(๑> 灬 <)","( ˘•灬•˘ )","(ง •̀灬•́)ง"],
                msg:"视频看完有惊喜！！！",
                num:0,
            };
        },
        methods: {
            // 加载用户的菜单方法
            loadMenu: function() {
                this.$axios.get("/api/perms/menu")
                    .then((res) => {
                        if(res.data.status == 200) {
                            this.menuItem = res.data.data;
                            //console.log(this.menuItem);
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.msg,
                                type: "warning"
                            });
                        }
                    })
                    .catch((err) => {
                        this.$message({
                            showClose: true,
                            message: err,
                            type: "error"
                        });
                    });
            },
            // 加载用户
            loadUser: function() {
              this.$axios.get("/api/user/getOne?username="+this.username)
                  .then((res) => {
                    if(res.data.status == 200) {
                      this.user = res.data.data;
                      if(this.user.avatar==null){
                        this.user.avatar="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png";
                      }
                      // console.log(this.user);
                    } else {
                      this.$message({
                        showClose: true,
                        message: res.data.msg,
                        type: "warning"
                      });
                    }
                  })
                  .catch((err) => {
                    this.$message({
                      showClose: true,
                      message: err,
                      type: "error"
                    });
                  });
            },
            btnLogout: function() {
                this.$confirm('确定退出本系统吗？', '系统提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.$axios.post("/api/logout")
                        .then(res => {
                            if(res.data.status == 200) {
                                // window.localStorage.removeItem('token');
                                // window.localStorage.removeItem('username');
                                window.localStorage.clear();
                                this.$router.push({name: 'login'});
                            }
                        })
                        .catch(err => {
                            this.$message({
                                    showClose: true,
                                    message: err,
                                    type: "error"
                                });
                        });
                });
            },
          start(){
            this.timer = setInterval(this.valChange, 5000); // 注意: 第一个参数为方法名的时候不要加括号;
            setInterval(this.marquee, 300); // 注意: 第一个参数为方法名的时候不要加括号;
          },
          valChange() {
            this.value++;
          },
          marquee() {
            while(this.msg.length<82){
              this.msg =this.msg+"龘"
            }
            if(this.msg.length>42){
              this.msg =this.msg.substring(0,42);
            }
            this.msg = this.msg.substring(1)+""+this.msg.substring(0,1);
          },
          over(){
            clearInterval(this.timer);
          }

        },
        created: function() {
            this.username = window.localStorage.getItem('username');
            // 调用loadMenu函数初始化menuItem数据
            this.loadMenu();
            this.loadUser(this.username);
            this.start();
        },
        beforeDestroy() {
          clearInterval(this.timer);
        },
    }
</script>


<style scoped>
    #home-main {
        width: 100%;
        height: 100%;
    }

    .el-header {
        background-color: #515c64;
    }

    .el-container {
        height: 100%;
    }

    .el-aside {
        background-color: #515c64;
        height: 100%;
    }

    .el-col {
        height: 60px;
        color: white;
        text-align: center;
        line-height: 60px;
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
    .meg{
        padding-left: 14px;
    }
    .msg{
        text-align:left;
    }
    .gg{
      text-align:right;
    }
    .img{
      padding-top:15px;
      margin-left:-90px;
    }

</style>
