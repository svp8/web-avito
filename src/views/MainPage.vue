<template>
  <div>
    <header>
      <div class="conteiner">
        <div class="header_inner">
          <div class="header_logo">
            <img class="img_Logo" src="../assets/mainLogo.png" alt="" />
            <p class="text_Logo">Воронка</p>
          </div>

          <nav class="header_nav">
            <button class="buttonAdd text_Buttons" type="button" name="button">
              Разместить объявление
            </button>
            <button class="buttonLK" type="button" name="button"></button>
            <button class="buttonOut text_Buttons" type="button" name="button">
              Выйти
            </button>
          </nav>
        </div>
      </div>
    </header>

    <!-- Тут будет поисковик и фильтры !-->
    <div class="found">
      <div class="conteiner">
        <div class="found_inner">
          <div class="search">
            <p>Поиск</p>
            <input class="searchAdd" type="text" placeholder="Поиск" />
          </div>

          <div class="categories">
            <p>Категория</p>
            <select
              class="selectCase"
              name="sel"
              placeholder="Выберите категорию"
            >
              <option value="0">Все категории</option>
              <option value="1">Вещи для дома</option>
              <option value="2">Автомобили</option>
              <option value="3">Детские игрушки</option>
            </select>
          </div>

          <div class="filter">
            <p>Фильтр по цене</p>
            <div class="filter_inner">
              <div class="countStart">
                <p>от</p>
                <input
                  class="countStart_End"
                  type="text"
                  placeholder="Минимальная цена"
                />
              </div>

              <div class="countEnd">
                <p>до</p>
                <input
                  class="countStart_End"
                  type="text"
                  placeholder="Максимальная цена"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Тут будут объявления !-->
    
        <div class="cards">
          <div v-for="item in cards" :key="item.id" class="card">
            <img class="image" src="../assets/vaz2109.jpg" alt="img"/>
            <div class="card__footer">
              <span class="card__footer__title">{{ item.title }}</span>
            <span class="card__footer__price">{{ item.price }} руб.</span>
            <span class="card__footer__date">{{ item.date }} </span>
            </div>
            
          </div>
        </div>
      
  </div>
</template>

<script>
import { getAllPosts } from '@/api/getAllPosts';
export default {
  data() {
    return {
      cards: [
        {
          id: 1,
          title: "test1",
          user_id: 5,
          category: "test",
          description: "test",
          price: 123,
          photo: "../assets/vaz2109.jpg",
          date: "12/12/12",
        },
        {
          id: 1,
          title: "test1",
          user_id: 5,
          category: "test",
          description: "test",
          price: 123,
          photo: "test",
          date: "12/12/12",
        },
        {
          id: 1,
          title: "Машина для дущи",
          user_id: 5,
          category: "test",
          description: "test",
          price: 123000,
          photo: "test",
          date: "12/12/12",
        },
      ],
    };
  },
  methods:{
    async loadCards(){
      let response= await getAllPosts();
      response=await response.json()
      console.log(response);
      this.cards=response;
    }
  },
  created(){
    this.loadCards();
  }
};
</script>

<style>
body {
  margin: 0 0;
}
.conteiner {
  width: 100%;
  margin: 0 auto;
}
.header_inner {
  display: flex;
  justify-content: space-between;
  background-color: #251605;
  color: #ffffff;
  align-items: center;
  border-bottom: 1px solid #515369;
  height: 45px;
}
.img_Logo {
  width: 61px;
  height: 44px;
  left: 0px;
  top: 0px;
}
.header_logo {
  display: flex;
  justify-content: space-between;
  height: 45px;
}
.text_Logo {
  font-size: 25px;
  margin: auto;
}
.header_nav {
  display: flex;
  justify-content: space-around;
  width: 30%;
  height: 100%;
  align-items: center;
}
.buttonAdd {
  width: 250px;
  height: 38px;
  background: #f6e27f;
  border-radius: 10px;
}
.buttonLK {
  width: 35px;
  height: 35px;
  border-radius: 35px;
  background-image: url("../assets/lk_image.png");
  background-size: 35px 35px;
  background-position: center;
}
.buttonOut {
  width: 82px;
  height: 38px;
  background: #f6e27f;
  border-radius: 10px;
}
.text_Buttons {
  font-family: "Inter";
  font-style: normal;
  font-weight: 700;
  font-size: 19px;
  line-height: 23px;
  align-items: center;
  text-align: center;
  color: #ffffff;
}
.found {
  margin-top: 22px;
  text-align: center;
}
.found_inner {
  display: flex;
  justify-content: space-around;
  height: 120px;
  width: 86%;

  margin: auto;
  background: #9bbec7;
  border-radius: 15px;
}
.search {
  display: block;
  align-items: center;
  text-align: center;
  width: 40%;
}
.searchAdd {
  margin-left: 10%;
  width: 405px;
  height: 52px;
  background: #ffffff;
  border: 2px solid #000000;
  box-sizing: border-box;
  box-shadow: 5px 5px 20px rgba(0, 0, 0, 0.25);
  border-radius: 17px;
}
.categories {
  display: block;
  align-items: center;
  width: 20%;
}
.selectCase {
  width: 200px;
  height: 52px;

  background: #ffffff;
  border: 2px solid #000000;
  box-sizing: border-box;
  box-shadow: 5px 5px 20px rgba(0, 0, 0, 0.25);
  border-radius: 17px;
}
.filter {
  width: 40%;
  text-align: center;
}
.filter_inner {
  display: flex;
  justify-content: space-around;
}
.countStart {
  display: flex;
  justify-content: center;
}
.countEnd {
  display: flex;
  justify-content: center;
}
.countStart_End {
  background: #ffffff;
  border: 2px solid #000000;
  box-sizing: border-box;
  box-shadow: 5px 5px 20px rgba(0, 0, 0, 0.25);
  border-radius: 17px;
  text-align: center;
  margin-left: 5px;
}
.content_all {
  margin: auto;
  background-color: #c4c4c4;
}
.cards {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  flex-wrap: wrap;
}
.card {
  padding: 4px;
  margin: 10px;
  width: 20%;
  
  background-color: white;
 
  color: black;
  text-align: center;
  
}
.image{
width: 100%;
object-fit:cover;
height: 150px;

}
.card__footer{
  text-align: start;
  display: flex;
  flex-direction: column;
}
.card__footer__title{
color:orange;
}
.card__footer__price{
  font-weight: 600;
}
.card__footer__date{
  opacity: 0.5;
}
</style>