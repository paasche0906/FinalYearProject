import ACCESS_ENUM from "@/access/accessEnum";

/**
 * Checking permissions (determining whether the currently logged user has certain permissions)
 * @param loginUser Currently logged user
 * @param needAccess Access required
 * @return boolean have or have not authority
 */
const checkAccess = (loginUser: any, needAccess = ACCESS_ENUM.NOT_LOGIN) => {
  // Get the permissions that the currently logged-in user has (if there is no loginUser, it means not logged in)
  const loginUserAccess = loginUser?.userRole ?? ACCESS_ENUM.NOT_LOGIN;
  if (needAccess === ACCESS_ENUM.NOT_LOGIN) {
    return true;
  }
  // If the user is logged in to access the
  if (needAccess === ACCESS_ENUM.USER) {
    // If the user is not logged in, then no privileges
    if (loginUserAccess === ACCESS_ENUM.NOT_LOGIN) {
      return false;
    }
  }
  // If administrator rights are required
  if (needAccess === ACCESS_ENUM.ADMIN) {
    // If not an administrator, it means no permission
    if (loginUserAccess !== ACCESS_ENUM.ADMIN) {
      return false;
    }
  }
  return true;
};

export default checkAccess;
