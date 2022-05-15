import { url } from "./url";

export const register = async (email, password) => {
    let user={
        "email": email,
        "password": password
    }
    return fetch(url + "/user/register", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user),
    });
}
export const updateUser = async (user) => {
    return fetch(url + "/user/update", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user),
    });
}