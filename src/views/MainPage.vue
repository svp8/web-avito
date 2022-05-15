<template>
  <div>
    <Header/>

    <!-- Тут будет поисковик и фильтры !-->
    <div class="found">
      <div class="conteiner">
        <div class="found_inner">
          <div class="search">
            <p>Поиск</p>
            <input
              class="searchAdd"
              v-model.lazy="keywords"
              type="text"
              placeholder="Поиск"
              autofocus
            />
          </div>
          <div class="categories">
            <p>Категория</p>
            <select
              class="selectCase"
              v-model="category"
              name="sel"
              placeholder="Выберите категорию"
            >
              <option value="">Все категории</option>
              <option value="home">Вещи для дома</option>
              <option value="car">Автомобили</option>
              <option value="toy">Детские игрушки</option>
            </select>
          </div>

          <div class="filter">
            <p>Фильтр по цене</p>
            <div class="filter_inner">
              <div class="countStart">
                <p>от</p>
                <input
                  v-model="minPrice"
                  class="countStart_End"
                  type="text"
                  placeholder="Минимальная цена"
                />
              </div>

              <div class="countEnd">
                <p>до</p>
                <input
                  v-model="maxPrice"
                  class="countStart_End"
                  type="text"
                  placeholder="Максимальная цена"
                />
              </div>
              <form>
                <input
                  class="searchbut"
                  type="button"
                  value="Поиск"
                  @click="fetch"
                />
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Тут будут объявления !-->

    <div class="cards">
      <div v-for="item in cardsSearch" :key="item.id" class="card" @click="goToPost(item.id)">
        <img class="image" :src="require('@/assets/' + item.photo)" alt="img" />
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
import { getAllPosts } from "@/api/getAllPosts";
import Header from "../components/Header.vue";
export default {
  data() {
    return {
      cards: [],
      cardsSearch: [],
      keywords: null,
      results: [],
      category: "",
      minPrice:0,
      maxPrice:10000,
    };
  },
  components: {
    Header,
  },
  methods: {
    goToPost(postId){
      this.$router.push({ path: `/post/${postId}` })
    },
    async loadCards() {
      let response = await getAllPosts();
      response = await response.json();
      console.log(response);
      this.cards = response;
      this.cardsSearch = response;
    },
    fetch() {
      if (this.keywords == null) {
        this.cardsSearch = this.cards;
      } else  {
        this.cardsSearch = this.cards.filter((item) =>
          item.title.toLowerCase().includes(this.keywords.toLowerCase())
        );
      }
      switch (this.category) {
        case "home":
          this.cardsSearch = this.cardsSearch.filter(
            (item) => item.category == "home"
          );
          break;
        case "car":
          this.cardsSearch = this.cardsSearch.filter(
            (item) => item.category == "car"
          );
          break;
        case "toy":
          this.cardsSearch = this.cardsSearch.filter(
            (item) => item.category == "toy"
          );
          break;
        default:
          break;
      }
      this.cardsSearch = this.cardsSearch.filter(
            (item) => item.price >=this.minPrice&&item.price <=this.maxPrice
          );
    },
  },
  created() {
    this.loadCards();
  },
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
  cursor:pointer;
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
.searchbut {
  width: 50px;
  height: 30px;
  justify-content: center;
  align-items: center;
  border-radius: 10px;
  margin: 8px;
  border: 2px solid #000000;
}
.buttonAdd {
  width: 250px;
  height: 38px;
  background: #f6e27f;
  border-radius: 10px;
  cursor:pointer;
}
.buttonLK {
cursor:pointer;
  width: 35px;
  height: 35px;
  border-radius: 35px;
  background-image: url("../assets/lk_image.png");
  background-size: 35px 35px;
  background-position: center;
}
.buttonOut {
  cursor:pointer;
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
  width: 370px;
  height: 52px;
  background: #ffffff;
  border: 0.5px solid #000000;
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
  border: 0.5px solid #000000;
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
  border: 0.5px solid #000000;
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
  /* justify-content: space-around; */
  flex-wrap: wrap;
}
.card {
  padding: 4px;
  margin: 10px;
  width: 250px;

  background-color: white;

  color: black;
  text-align: center;
}
.image {
  width: 100%;
  object-fit: cover;
  height: 150px;
}
.card__footer {
  text-align: start;
  display: flex;
  flex-direction: column;
}
.card__footer__title {
  color: orange;
}
.card__footer__price {
  font-weight: 600;
}
.card__footer__date {
  opacity: 0.5;
}
</style>