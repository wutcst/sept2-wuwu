<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div
    style="width: 100%;height: 100vh; background: linear-gradient(90deg,#3cadeb,#9c88ff);display: flex;justify-content: center;align-items: center">
    <div
      style="width: 300px; height: 380px;box-shadow: 0 5px 15px rgba(0, 0, 0, .8); display: flex;justify-content: center;align-items: center;">
      <!-- :model="form"：该属性用于将表单数据绑定到组件的form属性上，实现表单数据的双向绑定。 -->
      <!-- :rules="rules"：该属性用于将表单的验证规则绑定到组件的rules属性上 -->
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
        /* username字段的验证规则为一个数组，其中包含了一个对象。这个对象的属性包括：
          required：表示该字段为必填字段。
          message：表示当该字段未填写时，提示的错误信息为"请输入用户名"。
          trigger：表示触发验证的方式为"blur"，即在输入框失去焦点时进行验证。 */
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        /* password字段的验证规则也为一个数组，其中包含了一个对象。这个对象的属性包括：
           required：表示该字段为必填字段。
           message：表示当该字段未填写时，提示的错误信息为"请输入密码"。
           trigger：表示触发验证的方式为"blur"，即在输入框失去焦点时进行验证。 */
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
          axios.post('http://localhost:8080/login', { "username": this.form.username, 'password': this.form.password }).then((result) => {
            console.log(result);
            if (result.data.code === 1) {
              this.$message({
                type: "success",
                message: "登录成功",
              });
              this.$router.push("/main"); //登录成功后的页面跳转到主界面
            }
            else {
              /* this.$router.push("/main"); */
              /* alert("用户名或密码错误。") */
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

