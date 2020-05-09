// 获取url地址中参数的值
export const getUrlString = key => {
  const reg = new RegExp("(\\?|&)" + key + "=([^&]*)(&|$)");
  const r = window.location.href.match(reg);
  return r ? window.decodeURI(r[2]).replace(/#.*$/, "") : "";
};

