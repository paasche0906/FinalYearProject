<template>
  <div id="userRegisterView">
    <h2 style="margin-bottom: 16px">User Register</h2>
    <a-form
      style="max-width: 480px; margin: 0 auto"
      label-align="left"
      auto-label-width
      :model="form"
      @submit="handleSubmit"
    >
      <a-form-item field="userAccount" label="account">
        <a-input
          v-model="form.userAccount"
          placeholder="Please enter your account number"
        />
      </a-form-item>
      <a-form-item
        field="userPassword"
        tooltip="Password not less than 8 digits"
        label="password"
      >
        <a-input-password
          v-model="form.userPassword"
          placeholder="Please enter your password"
        />
      </a-form-item>
      <a-form-item field="confirmPassword" label="Confirm Password">
        <a-input-password
          v-model="form.confirmPassword"
          placeholder="Please enter your password again"
        />
      </a-form-item>
      <a-form-item field="userName" label="user nickname">
        <a-input
          v-model="form.userName"
          placeholder="Please enter the user nickname "
        />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit" style="width: 120px">
          注册
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserRegisterRequest } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

/**
 * 表单信息
 */
const form = reactive({
  userAccount: "",
  userPassword: "",
  confirmPassword: "",
  userName: "",
} as UserRegisterRequest);

const router = useRouter();
const store = useStore();

/**
 * 提交表单
 */
const handleSubmit = async () => {
  if (form.userPassword !== form.confirmPassword) {
    message.error("The passwords entered twice do not match.");
    return;
  }

  const res = await UserControllerService.userRegisterUsingPost(form);
  // 注册成功，跳转到登录页面
  if (res.code === 0) {
    message.success("Registration successful, please log in");
    router.push({
      path: "/login",
      replace: true,
    });
  } else {
    message.error("Registration failed." + res.message);
  }
};
</script>
