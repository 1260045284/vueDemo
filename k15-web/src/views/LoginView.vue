<template>
    <div id="login-main">
        <el-row type="flex" class="row-bg" justify="center" align="middle">
            <el-col :span="6">
                <el-form :model="userForm" status-icon :rules="rules" ref="userForm">
                    <el-form-item label="账户" prop="username">
                        <el-input type="text" v-model="userForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model="userForm.password"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="btnlogin('userForm')">提交</el-button>
                        <el-button @click="resetForm('userForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    name: 'LoginView',
    data: function() {
        return {
            userForm: {
                username: '',
                password: ''
            },
            rules: { // 编写表单验证规则
                username: [
                    { required: true, message: '请输入帐号', trigger: 'blur' },
                    { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        // 提交登录
        btnlogin: function(formName) {
            //调用表单验证结果
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    let formData = new URLSearchParams({
                        "username": this.userForm.username,
                        "password": this.userForm.password
                    });
                    // 提交表单
                    this.$axios.post('/api/login', formData.toString())
                        .then((res) => {
                            if(res.data.status == 200) {
                                // 保存服务器返回的token
                                let token = res.data.data;
                                window.localStorage.setItem('token', token);
                                window.localStorage.setItem('username', this.userForm.username);
                                // 跳到首页
                                this.$router.push('/home');
                            } else {
                                this.$message({
                                    showClose: true,
                                    message: res.data.msg,
                                    type: 'warning'
                                });
                            }
                        })
                        .catch((err) => {
                            this.$message({
                                showClose: true,
                                message: err,
                                type: 'error'
                            });
                        });
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        // 重置表单
        resetForm: function(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>

<!-- scoped 让定义的样式，仅仅在当前组件有戏 -->
<style scoped>
    #login-main {
        width: 100%;
        height: 100%;
        background-color: #2d434c;
    }

    .el-row {
        height: 100%;
        height: 100%;
    }

    .el-col {
        background-color: white;
        border-radius: 15px;
        padding: 30px;
    }
</style>