<template>
  <div>
      <Header/>
      <div class="content_box">
          <div class="creators">
          <h1>Создатели:</h1>
          <p>Папенькин Владислав</p>
          <p>Курбатов Никита</p>
          <p>Ширяев Артем</p>
          <h1>Связаться с нами:</h1>
           <p>Почта: vlad-pvs@mail.ru</p>
      </div>
      <div class="creators">
          <img class="logo_image" src="@/assets/mainLogo.png"/>
          <h1 class="title">Воронка</h1>
      </div>
      </div>
      
  </div>
</template>

<script>
import Header from "../components/Header.vue";
export default {
components: {
    Header,
  },
}
</script>

<style>
h1 {
    text-shadow: none;
}
.title{
    color:#e2d406;
    font-size: 50px;
}
.content_box{
    display: flex;
    justify-content: center;
}
.creators{
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-left: 50px;
    position:relative;
}
.logo_image{
    height:300px;
    margin-left:80px;
    margin-top:40px;
}
</style>