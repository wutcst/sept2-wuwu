<!-- eslint-disable vue/multi-word-component-names -->

<template>
  <div
    style="width: 100%;height: 100vh; background: linear-gradient(90deg,#3cadeb,#9c88ff);display: flex;justify-content: center;align-items: center">
    <div
      style="width: 300px; height: 380px;box-shadow: 0 5px 15px rgba(0, 0, 0, .8); display: flex;justify-content: center;align-items: center;">
      <el-form :model="form" size="normal" style="height: 100% ;width: 220px;" ref="form" :rules="rules">
        <!-- Login字母logo -->
        <div style="width: 100%;height: 40px;margin-top:10px;line-height: 40px;text-align: center">
          <span style="color: white;font-weight: 900;font-size: 30px;">Login</span>
        </div>
        <!-- 用户名 -->
        <el-form-item style="margin-top: 50px" prop="username">
          <el-input v-model="form.username" prefix-icon="el-icon-user-solid" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input v-model="form.password" prefix-icon="el-icon-lock" placeholder="请输入密码" show-password></el-input>
        </el-form-item>
        <!-- 登录 -->
        <el-form-item>
          <el-button
            style="color: white; border-radius: 30px;width: 100%;height: 50px;background: linear-gradient(90deg,#3cadeb,#9c88ff);"
            @click="login">登录</el-button>
        </el-form-item>
        <!-- 注册 -->
        <el-form-item style="text-align: center; color: white;">
          <a @click="toRegister" style="font-size: 16px;font-weight: 500;opacity: 0.8;text-decoration: underline">注册</a>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  /* name: "login", */
  data() {
    return {
      form: {},
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
    };
  },
  /* created钩子会在Vue实例创建完成后立即调用 */
  /* 在组件创建完成后，立即从浏览器的sessionStorage中删除名为"user"的数据，确保用户在重新登录时不会出现错误。 */
  created() {
    sessionStorage.removeItem("user");
  },

  methods: {
    toRegister() {
      this.$router.push("/register"); //跳转到注册界面
    },
    login() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          /* login界面发送post请求更合适，传表单数据的username和password给后端 */
          /* 成功的测试用例 http://yapi.smart-xwork.cn/mock/264710/yapi/login1 */
          /* 失败的测试用例 http://yapi.smart-xwork.cn/mock/264710/yapi/login2 */
          axios.post('http://yapi.smart-xwork.cn/mock/264710/yapi/login1', { "username": this.form.username, 'password': this.form.password }).then((result) => {
            console.log(result);
            if (result.data.code === 1) {
              this.$message({
                type: "success",
                message: "登录成功",
              });
              this.$router.push("/main"); //登录成功后的页面跳转到主界面
            }
            else {
              this.$message({
                type: "error",
                message: "用户名或密码错误",
              });
            }
          }).catch((err) => {
            console.log(err)
          });
        } else {
          console.log("error submit!!");
          /* validate方法只会验证表单的规则，但不会阻止表单的默认提交行为。如果需要阻止表单的默认提交行为，可以在valid回调函数中返回false。 */
          return false;
        }
      });
    },
  },
};

</script>

<style scoped></style>

