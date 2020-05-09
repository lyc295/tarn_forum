// 判断是否有值：全部都是空格或其他诸如tab的话，也作为无值看待
export function hasValue(val) {
  if (typeof val === "object") {
    return val !== null && val !== {} && JSON.stringify(val).length > 2;
    // return Object.prototype.toString.call(val) === "[object Array]" ? val.some(e => e !== undefined && e != null && e !== "") : false;
  } else {
    return val !== "" && val !== undefined && !/^\s+$/.test(val);
  }
}
