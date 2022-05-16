<template>
  <div class="header_inner">
    <div class="header_logo" @click="goToMainPage">
      <img class="img_Logo" src="../assets/mainLogo.png" alt="" />
      <p class="text_Logo">Воронка</p>
    </div>
    <nav class="header_nav">
      <button @click="goToAboutPage" class="buttonAdd about text_Buttons about" type="button">
        О нас
      </button>
      <button class="buttonAdd create text_Buttons" type="button">
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
  methods: {
    exit() {
      this.$router.push({ name: "login" });
    },
    goToUserPage() {
      this.$router.push({ name: "user" });
    },
    goToMainPage() {
      this.$router.push({ name: "main" });
    },
     goToAboutPage() {
      this.$router.push({ name: "about" });
    },
  },
};
</script>

<style>
.about {
  background-color: #e2d406;
}
.create {
  background-color: rgb(8, 239, 8);
}
</style>