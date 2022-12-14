<template>
    <div id="home-main">
        <el-container>
            <el-header>
                <el-row type="flex" class="row-bg" justify="center" align="middle">
                    <el-col :span="3">
                        <img src="@/assets/image/logo.png" height="60" />
                    </el-col>
                    <el-col :span="18">
                        <h2>≧◔◡◔≦ 管理系统后台</h2>
                    </el-col>
                    <el-col :span="2">
                        <h4>欢迎您：{{username}}</h4>
                    </el-col>
                    <el-col :span="2">
                        <el-button size="mini" type="danger" @click="btnLogout">退出</el-button>
                    </el-col>
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
                menuItem:[], //接收用户的菜单数据
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
            }
        },
        created: function() {
            this.username = window.localStorage.getItem('username');
            // 调用loadMenu函数初始化menuItem数据
            this.loadMenu();
        }
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


</style>
