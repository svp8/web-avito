import { url } from "./url";

export const deletePost = async (postId) => {
    return fetch(url + `/post/delete/${postId}`, {
        method: 'DELETE',
    });
}