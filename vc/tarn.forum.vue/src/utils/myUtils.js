function hasValue(val) {
  if (typeof val === "object") {
    return val !== null && val !== {} && JSON.stringify(val).length > 2;
  } else {
    return val !== "" && val !== undefined && !/^\s+$/.test(val);
  }
}

function clearLocalStorage(key) {
  window.localStorage.removeItem(key);
}

function setLocalStorage(key, obj) {
  if (typeof obj === 'string') {
    localStorage.setItem(key, obj);
  } else {
    localStorage.setItem(key, JSON.stringify(obj));
  }
}

function setSessionStorage(key, obj) {
  if (typeof obj === 'string') {
    sessionStorage.setItem(key, obj);
  } else {
    sessionStorage.setItem(key, JSON.stringify(obj));
  }
}

function getLocalStorage(key) {
  return localStorage.getItem(key);
}

function getSessionStorage(key) {
  return sessionStorage.getItem(key);
}

function clearSessionStorage(key) {
  window.sessionStorage.removeItem(key);
}

export default {
  hasValue,
  setLocalStorage,
  setSessionStorage,
  getLocalStorage,
  getSessionStorage,
  clearSessionStorage,
  clearLocalStorage,
}




