<template>
    <div>
        <el-drawer
            title="添加讲师"
            :close-on-press-escape="true"
            :wrapperClosable="true"
            :visible.sync="dialogAdd"
            direction="rtl"
            :size="500"
            custom-class="demo-drawer"
            @close="btnClose">

            <div class="demo-drawer__content">
                <el-row type="flex" justify="center" align="middle">
                    <el-col :span="20">
                        <el-form :inline="true">
                            <el-form-item label="讲师姓名:">
                                <el-input placeholder="请输入讲师姓名" type="text" v-model="teacher.name"></el-input>
                            </el-form-item>
                            <el-form-item label="所教科目:">
                                <el-select v-model="teacher.subjectid" placeholder="请选择科目" value="">
                                    <el-option v-for="subject in subjectList" :key="subject.id" :label="subject.name" :value="subject.id"></el-option>
                                </el-select>
                            </el-form-item>
                            <el-form-item label="教育背景:">
                                <el-input placeholder="请输入教育背景" type="text" v-model="teacher.education"></el-input>
                            </el-form-item>
                            <el-form-item label="教育描述:">
                                <el-input type="textarea" rows="3" cols="34" v-model="teacher.career"></el-input>
                            </el-form-item>
                            <el-form-item label="是否名师:" style="width:300px">
                                <el-switch
                                    v-model="teacher.isfamous"
                                    active-color="#13ce66"
                                    inactive-color="#ff4949"
                                    active-text="高级"
                                    active-value="y"
                                    inactive-text="中级"
                                    inactive-value="n"
                                    >
                                </el-switch>
                            </el-form-item>
                            <el-form-item label="是否在职:" >
                                <el-switch
                                    v-model="teacher.status"
                                    active-color="#13ce66"
                                    inactive-color="#ff4949"
                                    active-text="在职"
                                    active-value="y"
                                    inactive-text="离职"
                                    inactive-value="n"
                                    >
                                </el-switch>
                            </el-form-item>
                        </el-form>
                    </el-col>
                </el-row>
                <div class="demo-drawer__footer">
                    <el-row type="flex" justify="center" align="middle">
                        <el-col :span="20">
                            <el-button @click="btnClose">取消</el-button>
                            <el-button type="primary" @click="btnAdd">添加</el-button>
                        </el-col>
                    </el-row>
                </div>
            </div>

        </el-drawer>
    </div>
</template>


<script>
    export default {
        name: 'TeacherAdd',
        data: function() {
            return {
                dialogAdd: false,   // 控制内容是否显示，false表示隐藏
                teacher: {          // 添加的数据对象
                    isfamous: 'y',
                    status: 'y'
                },        
                subjectList: [],    // 课程信息
            }
        },
        methods: {
            loadSubject: function() { // 加载课程消息
                this.$axios.get('/api/subject/list')
                    .then((res) => {
                        if(res.data.status == 200) {
                            this.subjectList = res.data.data;
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.msg,
                                type: 'error'
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
            },
            btnClose: function() { // 取消添加事件
                this.teacher = {isfamous: 'y', status: 'y'};
                this.dialogAdd = false;
            },
            btnAdd: function() {    // 添加按钮
                this.$axios.post('/api/teacher/add', this.teacher)
                    .then((res) => {
                        if(res.data.status == 200) {    // 添加讲师成功
                            this.$message({
                                showClose: true,
                                message: res.data.msg,
                                type: 'success'
                            });

                            // 隐藏自己
                            this.btnClose();
                            //刷新讲师列表
                            this.$parent.queryTeacher();
                        } else {    // 添加讲师失败
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
            }
        },
        created: function() {
            this.loadSubject();
        }
    }
</script>


<style scoped>
    .el-input,.el-select{
      width:300px;
    }
</style>