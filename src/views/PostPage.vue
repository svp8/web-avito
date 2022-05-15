<template>
  <div>
    <Header />
    <div class="post__container">
      <div class="post__left">
        <img class="post__image" :src="require('@/assets/' + card.photo)" />
        <h2>{{ card.title }}</h2>
      </div>
      <div class="post__right">
        <div class="post__container_names">
          <h3>Описание:</h3>
          <textarea
            class="post__description"
            type="text"
            :value="card.description"
            disabled
          />
        </div>
        <div class="post__container_names">
          <h3>Цена:</h3>
          <input class="post__input" type="text" :value="card.price" disabled />
        </div>
        <div class="post__container_names">
          <h3>Дата создания:</h3>
          <input class="post__input" type="text" :value="card.price" disabled />
        </div>
      </div>
    </div>
    <div class="post__container">
      <div class="post__user">
        <h2>Информация о продавце</h2>
        <div>
          <h3>ФИО:</h3>
          <input :value="user.name" disabled />
        </div>
        <div>
          <h3>Телефон:</h3>
          <input :value="user.phone" disabled />
        </div>
        <div>
          <h3>Почта:</h3>
          <input :value="user.email" disabled />
        </div>
      </div>
      <div class="post__answer">
        <h2>Отправить сообщение продавцу</h2>
        <div class="flex-down">
          <textarea v-model="message" class="post__message"> </textarea>
          <button class="post__button" @click="sendMessage">
            Отправить сообщение
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import { getAllPosts } from "@/api/getAllPosts";
import { getUserById } from "@/api/getUserById";
import { createMessage } from "@/api/message";
export default {
  data() {
    return {
      email: "",
      phone: "",
      name: "",
      photo: "",
      user: {},
      card: {},
      message: "",
    };
  },
  components: {
    Header,
  },
  computed: {
    currentUser() {
      return this.$store.getters.USER;
    },
  },
  methods: {
    async loadCards() {
      let response = await getAllPosts();
      response = await response.json();
      this.card = response.filter(
        (item) => item.id == this.$route.params.id
      )[0];
    },
    async getUser() {
      let response1 = await getUserById(this.card.user_id);
      response1 = await response1.json();
      this.user = response1;
    },
    async sendMessage() {
      if (this.message !== "") {
        const date = new Date().toLocaleString();
        const user=this.currentUser;
        try {
          let response = await createMessage({
            'postId': this.card.id,
            'userIdFrom': user.id,
            'userIdTo': this.card.user_id,
            'message': this.message,
            'userName':user.name,
            'date': date,
          });
          response = await response.json();
          console.log(response);
          alert("Сообщение отправлено");
        } catch (error) {
          console.log(error)
        }
      }
    },
  },
  
  async created() {
    await this.loadCards();
    await this.getUser();
  },
};
</script>

<style>
.flex-down {
  display: flex;
  flex-direction: column;
}
.post__container {
  display: flex;
  padding: 7px;
  flex-direction: row;
  justify-content: space-evenly;
}
.post__container_names {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 6px;
}
.post__input {
  width: 200px;
  margin-left: 7px;
}
.post__description {
  height: 100px;
  width: 200px;
  margin-left: 7px;
}
.post__message {
  height: 300px;
  margin-bottom: 7px;
}
.post__button {
  color: white;
  background-color: green;
  margin-bottom: 15px;
  border: 0;
  padding: 7px;
}
.post__image {
  margin-top: 20px;
  width: 100%;
  object-fit: cover;
  height: 200px;
}
</style>