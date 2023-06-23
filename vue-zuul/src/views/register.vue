<!-- eslint-disable vue/multi-word-component-names -->

<template>
  <!-- 模板部分 -->
  <div
    style="width: 100%;height: 100vh; background: linear-gradient(90deg,#3cadeb,#9c88ff);display: flex;justify-content: center;align-items: center">
    <!-- 外层容器样式 -->
    <div
      style="width: 300px; height: 380px;box-shadow: 0 5px 15px rgba(0, 0, 0, .8); display: flex;justify-content: center;align-items: center;">
      <el-form :model="form" size="normal" style="height: 100% ;width: 220px;" ref="form" :rules="rules">
        <!-- 注册表单 -->
        <div style="width: 100%;height: 40px;margin-top:10px;line-height: 40px;text-align: center">
          <span style="color: white;font-weight: 900;font-size: 30px;">Register</span>
        </div>
        <el-form-item style="margin-top: 20px" prop="username">
          <!-- 用户名输入框 -->
          <el-input v-model="form.username" prefix-icon="el-icon-user-solid" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <!-- 密码输入框 -->
          <el-input v-model="form.password" prefix-icon="el-icon-lock" placeholder="请输入密码" show-password></el-input>
        </el-form-item>
        <el-form-item prop="confirm">
          <!-- 确认密码输入框 -->
          <el-input v-model="form.confirm" prefix-icon="el-icon-lock" placeholder="请输入密码" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <!-- 注册按钮 -->
          <el-button
            style="color: white; border-radius: 30px;width: 100%;height: 50px;background: linear-gradient(90deg,#3cadeb,#9c88ff);"
            @click="register">注册</el-button>
        </el-form-item>
        <el-form-item style="text-align: center; color: white;">
          <!-- 返回登录链接 -->
          <a @click="toLogin" style="font-size: 16px;font-weight: 500;opacity: 0.8;text-decoration: underline">返回登录</a>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>



<script>
import axios from 'axios';

export default {
  /* name: "register", */
  data() {
    return {
      form: {},
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        confirm: [
          { required: true, message: '请输入验证密码', trigger: 'blur' },
        ],
      }
    }
  },
  methods: {
    toLogin() {
      // 跳转到登录页面
      this.$router.push("/login")
    },
    register() {
      // 注册方法
      if (this.form.password !== this.form.confirm) {
        // 检查密码是否一致
        this.$message({
          type: "error",
          message: "两次密码输入不一致"
        })
        return;
      }

      this.$refs['form'].validate((valid) => {
        // 表单验证
        if (valid) {
          // 验证通过，向后端发送注册请求
          /* 这里注册也发post请求合适 */
          /* 成功的测试用例 http://yapi.smart-xwork.cn/mock/264710/yapi/register1 */
          /* 失败的测试用例 http://yapi.smart-xwork.cn/mock/264710/yapi/register2 */
          /* 测试workflow */
          axios.post('http://yapi.smart-xwork.cn/mock/264710/yapi/register1', {"username": this.form.username, "password": this.form.password, "confirm": this.form.confirm} ).then((result) => {
            console.log(result);
            /* code码为1是注册成功 */
            if (result.data.code === 1) {
              this.$message({
                type: "success",
                message: "注册成功"
              })
              this.$router.push("/login");
            }
            /* code码为0是注册失败 */
            else {
              this.$message({
                type: "error",
                message: "注册失败"
              })
            }
          }).catch((err) => {
            console.log(err)
          });
        } else {
          console.log('error submit!!');
          return false;
        }
      });


    }
  }
}

</script>




/* 在这里添加局部样式 */
<style scoped></style>