import router from "@/router";
import store from "@/store";
import ACCESS_ENUM from "@/access/accessEnum";
import checkAccess from "@/access/checkAccess";

router.beforeEach(async (to, from, next) => {
  console.log("Login user information", store.state.user.loginUser);
  let loginUser = store.state.user.loginUser;
  // Auto-login if not logged in before
  if (!loginUser || !loginUser.userRole) {
    // The purpose of await is to wait until the user has logged in successfully before executing the subsequent code.
    await store.dispatch("user/getLoginUser");
    loginUser = store.state.user.loginUser;
  }
  const needAccess = (to.meta?.access as string) ?? ACCESS_ENUM.NOT_LOGIN;
  // The page you want to jump to must be logged in
  if (needAccess !== ACCESS_ENUM.NOT_LOGIN) {
    // If you are not logged in, you will be redirected to the login page
    if (
      !loginUser ||
      !loginUser.userRole ||
      loginUser.userRole === ACCESS_ENUM.NOT_LOGIN
    ) {
      next(`/user/login?redirect=${to.fullPath}`);
      return;
    }
    // If you are logged in, but do not have enough permissions, you will be redirected to the No Permissions page.
    if (!checkAccess(loginUser, needAccess)) {
      next("/noAuth");
      return;
    }
  }
  next();
});
