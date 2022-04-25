import { url } from "./url";

export const getAllPosts = async () => {
    return fetch(url + "/post/all", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
    });
}
export const getAllPostsById = async (userId) => {
    return fetch(url + `/post/all/${userId}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
    });
}