export function clearLocalStorage(key) {
    window.localStorage.removeItem(key);
}

export function setLocalStorage(key, obj) {
    if (typeof obj === 'string') {
        localStorage.setItem(key, obj);
    } else {
        localStorage.setItem(key, JSON.stringify(obj));
    }
}


export function setSessionStorage(key, obj) {
    if (typeof obj === 'string') {
        sessionStorage.setItem(key, obj);
    } else {
        sessionStorage.setItem(key, JSON.stringify(obj));
    }
}

export function getLocalStorage(key) {
    return localStorage.getItem(key);
}

export function getSessionStorage(key) {
    return sessionStorage.getItem(key);
}

export function clearSessionStorage(key) {
    window.sessionStorage.removeItem(key);
}