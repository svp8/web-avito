import { url } from "./url";

export const createPost = async (post) => {
    return fetch(url + "/post/create", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(post),
    });
}