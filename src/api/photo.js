import { url } from "./url";

export const changePhoto = async (photo,id) => {
    return fetch(url + "/photo/user/"+id, {
        method: 'POST',
        // headers: {
        //     'Content-Type': 'application/json;charset=utf-8'
        // },
        body: photo,
    });
}