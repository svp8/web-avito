import { url } from "./url";

export const getAllByPostId = async (postId) => {
    return fetch(url + `/message/post/${postId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
    });
}

export const getAllMessagesByUserId = async (userId) => {
    return fetch(url + `/message/user/${userId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
    });
}

export const createMessage = async (message) => {
    return fetch(url + "/message/create", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(message),
    });
}