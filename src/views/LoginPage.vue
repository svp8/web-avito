<template>
  <div>
    <input type="text" />
    <input type="text" />
    <button @click="login">войти</button>
  </div>
</template>

<script>
import { checkLogin } from "@/api/login";
import { getAllPostsById } from "@/api/getAllPosts";
export default {
  methods: {
    async login() {
let response=await getAllPostsById('5');
console.log(await response.json());
      // let response = await checkLogin("test", "123");
      // if (response.ok) {
      //   let user=await response.json();
      //   console.log(user);
      //   // this.$router.push({name:"main"})
      // }
      
    },
  },
};
</script>

<style>
</style>