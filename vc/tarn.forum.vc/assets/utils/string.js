export function getString(val) {
  return val === 0 ? "0" : (val ? "" + val : "");
}
// 移除文本中的空白
export function trimSpaces(val) {
  return ("" + val).replace(/\s/g, "");
}

export function html2Escape(sHtml) {
  return sHtml.replace(/[<>&"]/g, function (c) {
    return {'<': '&lt;', '>': '&gt;', '&': '&amp;', '"': '&quot;', "'": '&acute;'}[c];
  });
}

export function delHtmlTag(str) {
  return str.replace(/<[^>]+>/g, "");// 去掉所有的html标记
}

export function html2Text(sHtml) {
  const ele = document.createElement("span");
  ele.innerHTML = sHtml;
  return ele.textContent;
}
