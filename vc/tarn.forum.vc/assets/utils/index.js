import * as array from "./array";
import * as file from "./file";
import * as common from "./common";
import * as route from "./route";
import * as storage from "./storage";
import * as string from "./string";
import * as regRule from "./regRule";

const utils = {
  array,
  file,
  common,
  route,
  storage,
  string,
  regRule
};
export default utils;
// 挂载到window对象上，页面里可以直接通过访问$utils调用相关方法
window.$utils = utils;
