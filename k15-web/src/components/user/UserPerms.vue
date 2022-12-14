<template>
    <div>
        <el-drawer title="权限列表" 
            :close-on-press-escape="true" 
            :wrapperClosable="true" 
            :visible.sync="dialogPerms"
            direction="rtl" 
            :size="500" 
            custom-class="demo-drawer">

            <div class="demo-drawer__content">
                <el-row type="flex" justify="center" align="middle">
                    <el-col :span="20">
                        <el-tree :data="permsitem" 
                                :default-checked-keys="userpermsitems"
                                node-key="id" 
                                show-checkbox 
                                default-expand-all 
                                ref="tree"
                                highlight-current 
                                :props="defaultProps" >
                        </el-tree>
                    </el-col>
                </el-row>
                <div class="demo-drawer__footer" style="margin-top: 25px">
                    <el-row type="flex" justify="center" align="middle">
                        <el-col :span="20">
                            <el-button @click="btnClose">取 消</el-button>
                            <el-button type="primary" @click="btnperms">授权</el-button>
                        </el-col>
                    </el-row>
                </div>
            </div>

        </el-drawer>
    </div>
</template>


<script>
    export default {
        name: 'UserPerms',
        data: function() {
            return {
                dialogPerms: false,  // 控制弹窗是否显示
                permsitem: [],      // 显示树控件内容的数组 - 后台需要把资源里面的所有数据按层级关系组装列表
                userpermsitems: [], // 用户拥有的权限
                defaultProps: {
                    children: 'childerList',       // 子节点集合的名称
                    label: 'name',                 //  节点集合中，节点的名称
                },
                userid: ''
            }
        },
        methods: {
            loadTree: function(userid) {
                this.userid = userid;

                // 查询 permsitem 和 userpermsitems
                this.$axios.get('/api/user/perms', {
                    params: {
                        userid: userid
                    }
                }).then(res => {
                        console.log(res);
                        if(res.data.status == 200) {
                            this.permsitem = res.data.data.permsTree;
                            this.userpermsitems = res.data.data.userPermsItems;
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.msg,
                                type: "error",
                            });
                        }
                })
                .catch(err => {
                    this.$message({
                        showClose: true,
                        message: err,
                        type: "error",
                    });
                });
            },
            btnClose: function() {
                this.permsitem = [];
                this.userpermsitems = [];
                this.dialogPerms = false;
            },

            // 点击授权按钮提交
            btnperms: function() {
                debugger
                // 获取所有状态为全选的节点值
                let key1 = this.$refs.tree.getCheckedKeys();
                // 获取所有半选状态的节点值
                let key2 = this.$refs.tree.getHalfCheckedKeys();

                // 拼接字符串
                let key = key1.concat(key2).join(",");

                this.$axios.get('/api/user/addperms', {
                    params: {
                        userid: this.userid,
                        permsids: key
                    }
                }).then(res => {
                    if(res.data.status == 200) {
                        this.$message({
                                showClose: true,
                                message: "用户授权成功",
                                type: "success",
                        });
                        this.btnClose();
                    } else {
                        this.$message({
                            showClose: true,
                            message: res.data.msg,
                            type: "success",
                        });
                    }
                }).catch(err => {
                    this.$message({
                            showClose: true,
                            message: err,
                            type: "success",
                        });
                });
            }
        }
    }
</script>

<style scoped>
    #perms {
        width: 100%;
        height: 100%;
    }
</style>