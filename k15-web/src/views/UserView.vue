<!-- 用户列表 -->
<template>
    <div id="user">
        <!-- 导航开始 -->
        <el-row>
            <el-col :span="24">
                <el-breadcrumb separator-class="el-icon-arrow-right">
                    <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item>用户管理</el-breadcrumb-item>
                    <el-breadcrumb-item>用户列表</el-breadcrumb-item>
                </el-breadcrumb>
            </el-col>
        </el-row>
        <!-- 导航结束 -->

        <!-- 条件查询开始 -->
        <el-row>
            <el-col :span="24">
                <el-form :inline="true" class="demo-form-inline">
                    <div style="margin-top: 15px">
                        <el-form-item size="mini" label="用户名：">
                            <el-input size="mini" v-model="username" placeholder="请输入用户名" class="input-with-select">
                                <el-button slot="append" icon="el-icon-search" @click="queryuser">查找</el-button>
                            </el-input>
                        </el-form-item>
                        <el-button type="primary" size="mini" icon="el-icon-user-solid">添加用户</el-button>
                    </div>
                </el-form>
            </el-col>
        </el-row>
        <!-- 条件查询结束 -->

        <!-- 数据列表开始 -->
        <el-row>
            <el-col :span="24">
                <el-table :data="userItem" size="mini"  border style="width: 100%" fit="fit" stripe="stripe">
                    <el-table-column align="center" label="ID" prop="id" width="80px"></el-table-column>
                    <el-table-column align="center" prop="username" label="用户名" width="300px"></el-table-column>
                    <el-table-column align="center" prop="email" label="邮箱"></el-table-column>
                    <el-table-column align="center" prop="status" label="状态" width="80px">
                        <template slot-scope="scope">
                            <span v-if="scope.row.status == 'y'">
                                <el-tag  size="mini" type="success" effect="dark">正常</el-tag>
                            </span>
                            <span v-if="scope.row.status == 'n'">
                                <el-tag size="mini" type="danger" effect="dark">锁定</el-tag>
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column align="center" fixed="right" label="操作" width="250px">
                        <template slot-scope="scope">
                            <el-button type="primary" size="mini" icon="el-icon-key" title="用户授权" @click="btnperms(scope.row.id)">
                            </el-button>
                            <el-button type="danger" size="mini" icon="el-icon-delete" title="删除用户"></el-button>
                            <el-button type="warning" size="mini" icon="el-icon-edit" title="修改用户"></el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-col>
        </el-row>
        <!-- 数据列表结束 -->

        <!-- 分页开始 -->
        <el-row>
            <el-col :span="24">
                <div style="margin-top: 15px; text-align: center">
                    <el-pagination background :page-sizes="[5, 10, 15, 20, 25]" 
                        layout="prev,pager,next,sizes,total"
                        :total="total" 
                        :page-count="pages" 
                        :current-page="pageNum" 
                        :page-size="pageSize"
                        @size-change="chageSize" 
                        @current-change="chageCurrent" 
                        @prev-click="chageCurrent"
                        @next-click="chageCurrent">
                    </el-pagination>
                </div>
            </el-col>
        </el-row>
        <!-- 分页结束 -->

        <!-- 调用用户权限弹窗 -->
        <user-perms ref="userperms"></user-perms>
    </div>
</template>

<script>
    import UserPerms from '@/components/user/UserPerms.vue';

    export default {
        name: "",
        data() {
            return {
                userItem: [],   //用户数据
                username: "",   //查询条件

                total: 0,       //分页控件总条数
                pages: 0,       //分页控件总页数
                pageNum: 1,     //分页控件当前页码
                pageSize: 5,    //分页控件每页条数
            };
        },
        methods: {
            //根据用户名查询
            queryuser: function() {
                this.$nextTick(() => {
                    this.$axios.get("/api/user/list", {
                            params: {
                                username: this.username,
                                pageNum: this.pageNum,
                                pageSize: this.pageSize,
                            },
                        })
                        .then((res) => {
                            if (res.data.status === 200) {
                                this.userItem = res.data.data.list;

                                //设置分页数据
                                this.total = res.data.data.total;
                                this.pages = res.data.data.pages;
                                this.pageNum = res.data.data.pageNum;
                                this.pageSize = res.data.data.pageSize;
                            } else {
                                this.$message({
                                    showClose: true,
                                    message: res.data.msg,
                                    type: "warning",
                                });
                            }
                        })
                        .catch((err) => {
                            this.$message({
                                showClose: true,
                                message: err,
                                type: "error",
                            });
                        });
                });
            },
            chageSize: function(pageSize) {
                //改变每页条数下拉框事件，通过形参获得当前选中的条数
                this.pageNum = 1; //当前页码改为1
                this.pageSize = pageSize;
                //调用查询方法
                this.queryuser();
            },
            chageCurrent: function(pageNum) {
                //改变页码时事件，接收一个被改变后的页码
                this.pageNum = pageNum; //当前页码改为1
                //调用查询方法
                this.queryuser();
            },
            btnperms(userid) { //显示授权控件(授权子组件中)
                this.$refs.userperms.loadTree(userid); //调用加载树控件数据方法
                this.$refs.userperms.dialogPerms = true; //显示树控件
            }
        },
        components: {
           UserPerms
        },
        created() {
            this.queryuser();
        },
    };
</script>

<style scoped>
    #user {
        height: 100%;
        width: 100%;
    }

</style>