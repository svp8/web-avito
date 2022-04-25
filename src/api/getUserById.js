import { url } from "./url";
export const getUserById = async (userId) => {
    return fetch(url + `/user/${userId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
    });
}