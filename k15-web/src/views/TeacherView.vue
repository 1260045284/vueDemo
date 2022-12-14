<template>
    <div>
        <!-- 导航开始 -->
        <el-row>
            <el-col :span="24">
                <el-breadcrumb separator-class="el-icon-arrow-right">
                    <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                    <el-breadcrumb-item>讲师管理</el-breadcrumb-item>
                    <el-breadcrumb-item>讲师列表</el-breadcrumb-item>
                  </el-breadcrumb>
            </el-col>
        </el-row>
        <!-- 导航结束 -->

        <!-- 条件查询开始 -->
        <el-row>
            <el-col :span="24">
                <div style="margin-top:20px">
                    <el-form :inline="true" class="demo-form-inline">
                        <el-form-item label="讲师姓名：">
                            <el-input v-model="teacherName" placeholder="请输入讲师姓名">
                                <el-button slot="append" icon="el-icon-search" @click="queryTeacher">查询</el-button>
                            </el-input>
                        </el-form-item>

                        <el-button type="primary" icon="el-icon-user-solid" @click="showAddTeacher">添加讲师</el-button>
                    </el-form>
                </div>
            </el-col>
        </el-row>
        <!-- 条件查询结束 -->

        <!-- 数据列表开始 -->
        <el-row>
            <el-col :span="24">
                <el-table :data="teacherItem" border style="width: 100%" fit="fit" stripe="stripe">
                    <el-table-column align="center" label="ID" prop="id"></el-table-column>
                    <el-table-column align="center" prop="name" label="姓名"></el-table-column>
                    <el-table-column align="center" prop="education" label="教育背景"></el-table-column>
                    <el-table-column align="center" prop="career" label="教育描述"></el-table-column>
                    <el-table-column align="center" prop="isfamous" label="级别">
                        <template slot-scope="scope">
                            <span v-if="scope.row.isfamous=='y'">
                                <el-tag type="success" effect="dark">高级</el-tag>
                            </span>
                            <span v-if="scope.row.isfamous=='n'">
                                <el-tag type="warning" effect="dark">中级</el-tag>
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column align="center" prop="subjectname" label="所教科目"></el-table-column>
                    <el-table-column align="center" prop="status" label="状态">
                        <template slot-scope="scope">
                            <span v-if="scope.row.status=='y'">
                                <el-tag type="success" effect="dark">在职</el-tag>
                            </span>
                            <span v-if="scope.row.status=='n'">
                                <el-tag type="danger" effect="dark">离职</el-tag>
                            </span>
                        </template>
                    </el-table-column>
                    <el-table-column align="center" fixed="right" label="操作" width="150">
                        <template slot-scope="scope">
                            <el-button type="danger" icon="el-icon-delete" title="删除讲师" @click="deleteTeacher(scope)"></el-button>
                            <el-button type="warning" icon="el-icon-edit" @click="showUpdateTeacher(scope.row)" title="修改讲师"></el-button>
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
                    <el-pagination
                        background
                        :page-sizes="[5, 10, 15, 20, 25]"
                        layout="prev,pager,next,sizes,total"

                        :total="total"
                        :page-count="pages"
                        :current-page="pageNum"
                        :page-size="pageSize"

                        @size-change="chageSize"
                        @current-change="chageCurrent"
                        @prev-click="chageCurrent"
                        @next-click="chageCurrent"
                    >
                    </el-pagination>
                </div>
            </el-col>
        </el-row>
        <!-- 分页结束 -->

        
        <!--添加讲师组件-->
        <TeacherAdd ref="addTeacherCom"></TeacherAdd>

        <!--编辑讲师组件-->
        <TeacherUpdate ref="updateTeacherCom"></TeacherUpdate>
    </div>
</template>





<script>
    import TeacherAdd from '@/components/teacher/TeacherAdd.vue'
    import TeacherUpdate from '@/components/teacher/TeacherUpdate.vue'

    export default {
        name: 'TeacherView',
        data: function() {
            return {
                teacherItem: [],    // 要显示的数据
                teacherName: '',    // 查询条件

                total: 0,           // 总条数
                pages: 0,           // 总页数
                pageNum: 1,         //当前页码
                pageSize: 5,        // 每页条数
            }
        },
        methods: {
            // 查询讲师信息
            queryTeacher: function() {
                this.$axios.get('/api/teacher/list', {
                    params: {
                        teacherName: this.teacherName,
                        pageNum: this.pageNum,
                        pageSize: this.pageSize
                    }
                }).then(res => {
                        // console.log(res);
                        if(res.data.status == 200) {
                            this.teacherItem = res.data.data.list;

                            // 给分页组件的数据赋值
                            this.total = res.data.data.total;
                            this.pages = res.data.data.pages;
                            this.pageNum = res.data.data.pageNum,
                            this.pageSize = res.data.data.pageSize;
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.msg,
                                type: "warning",
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
            // 改变每页条数下拉框事件，通过形参获得当前选中的条数
            chageSize: function(pageSize) {
                this.pageNum = 1;                       // 修改当前页为第1页
                this.pageSize = pageSize;               // 修改每页条数

                this.queryTeacher();                    // 根据上面的修改查询讲师列表
            },
            // 点击 前一页、后一页、页码 事件
            chageCurrent: function(pageNum) {
                this.pageNum = pageNum;                 // 修改当前页码
                this.queryTeacher();                    // 根据上面的修改查询讲师列表
            },
            // 添加讲师弹框
            showAddTeacher: function() {
                this.$axios.get('/api/teacher/addShow')
                    .then((res) => {
                        if(res.data.status == 200) {    // 有权限
                            // 通过子组件的引用传递，获得子组件中的变量
                            this.$refs.addTeacherCom.dialogAdd = true;
                        } else {                        // 否则
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
            },
            // 编辑讲师弹框
            showUpdateTeacher: function(teacher) {
                this.$axios.get('/api/teacher/updateShow')
                    .then((res) => {
                        if(res.data.status == 200) {
                            // 通过子组件的引用传递，获得子组件的变量
                            this.$refs.updateTeacherCom.teacher = teacher;
                            this.$refs.updateTeacherCom.teacherStr = JSON.stringify(teacher);
                            this.$refs.updateTeacherCom.dialogEdit = true;
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
            },
            // 删除讲师
            deleteTeacher: function(scope) {
                debugger
                console.log(scope);
                this.$axios.get('/api/teacher/delete?id=' + scope.row.id)
                    .then((res) => {
                        if(res.data.status == 200) {
                            // 通过子组件的引用传递，获得子组件的变量
                            this.teacherItem.splice(scope.$index, 1);
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
            }
        },
        created: function() {
            this.queryTeacher();
        },
        components: {
            TeacherAdd,
            TeacherUpdate
        }
    }
</script>

<style scoped>

</style>