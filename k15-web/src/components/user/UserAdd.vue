<template>
  <div>
    <el-dialog title="添加用户"
               :close-on-press-escape="true"
               :wrapperClosable="true"
               :visible.sync="dialogAdd"
               direction="rtl"
               :size="260"
               custom-class="demo-drawer">

      <div class="demo-drawer__content">
        <el-row type="flex" justify="center" align="middle">
          <el-col :span="20">

          </el-col>
        </el-row>

      </div>

    </el-dialog>


  </div>
</template>


<script>
export default {
  name: 'UserAdd',
  data: function() {
    return {
      dialogAdd: false,  // 控制弹窗是否显示

    }
  },
  methods: {},

}
</script>

<style scoped>
#perms {
  width: 100%;
  height: 100%;
}
</style>