<template>
  <div class="header_inner">
    <div class="header_logo" @click="goToMainPage">
      <img class="img_Logo" src="../assets/mainLogo.png" alt="" />
      <p class="text_Logo">Воронка</p>
    </div>
    <nav class="header_nav">
      <button class="buttonAdd text_Buttons" type="button">
        Разместить объявление
      </button>
      <button class="buttonLK" type="button" @click="goToUserPage"></button>
      <button class="buttonOut text_Buttons" type="button" @click="exit">
        Выйти
      </button>
    </nav>
  </div>
</template>

<script>
export default {
    methods:{
        exit() {
    this.$router.push({ name: "login" });
  },
  goToUserPage() {
    this.$router.push({ name: "profile" });
  },
  goToMainPage() {
    this.$router.push({ name: "main" });
  },
    }
  
};
</script>

<style>
</style>