import myUtils from './myUtils'
//首先备份下jquery的ajax方法
var _ajax = $.ajax;
//重写jquery的ajax方法
$.ajax = function (opt) {
  //备份opt中error和success方法
  var fn = {
    beforeSend: function () {
    },
    error: function (XMLHttpRequest, textStatus, errorThrown) {
    },
    success: function (data, textStatus) {
    },
    complete: function () {
    }
  }
  if (opt.error) {
    fn.error = opt.error;
  }
  if (opt.success) {
    fn.success = opt.success;
  }
  if (opt.complete) {
    fn.complete = opt.complete;
  }
  if (opt.beforeSend) {
    fn.beforeSend = opt.beforeSend;
  }
  //扩展增强处理
  var _opt = $.extend(opt, {
    error: function (XMLHttpRequest, textStatus, errorThrown) {
      //错误方法增强处理
      fn.error(XMLHttpRequest, textStatus, errorThrown);
    },
    success: function (data, textStatus) {
      //成功回调方法增强处理
      fn.success(data, textStatus);
    },
    beforeSend: function (XHR) {
      fn.beforeSend();
    },
    complete: function () {
      fn.complete();
    },
    headers: {
      token: myUtils.getSessionStorage("token")
    }
  });
  return _ajax(_opt);
};



