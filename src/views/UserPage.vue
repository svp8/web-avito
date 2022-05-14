<template>
  <div>
    <Header />
    <div class="user_container">
      <p class="Zagalovok">Личный кабинет</p>
      <div class="circle"><img class="avatar" :src="require('@/assets/'+photo)"></div>
      <input class="edit--photo" type="file" @change="changePhoto" />
      <button class="edituser">Редактировать профиль</button>
      <p class="tel">Телефон:</p>
      <textarea
        v-model="phone"
        class="tel1"
        placeholder="Введите новый телефон"
      ></textarea>
      <p class="fam">ФИО:</p>
      <textarea class="fam1" v-model="name" placeholder="Введите новую фамилию"></textarea>
      <p class="pocht">Почта:</p>
      <textarea
        v-model="email"
        class="pocht1"
        placeholder="Введите новый адрес эл.почты"
      ></textarea>
    </div>
    <div>
      <p class="obiav">Мои объявления</p>
      <div class="cards">
        <div v-for="item in cards" :key="item.id" class="card">
          <img class="image" :src="require('@/assets/'+item.photo)" alt="img" />
          <div class="card__footer">
            <span class="card__footer__title">{{ item.title }}</span>
            <span class="card__footer__price">{{ item.price }} руб.</span>
            <span class="card__footer__date">{{ item.date }} </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Header from "../components/Header.vue";
import { getAllPostsById } from "@/api/getAllPosts";
import { changePhoto } from "@/api/photo";
export default {
  data() {
    return {
      email: "",
      phone: "",
      name: "",
      photo: "",
      userId: 0,
      cards: [],
    };
  },
  components: {
    Header,
  },
  methods: {
    async changePhoto(event) {
      let file = event.target.files[0];
      let formData = new FormData();
      formData.append("photo", file);
      try {

        let response=await changePhoto(formData,this.userId);
        setTimeout(()=>{this.photo=file.name;
        this.$store.commit('SET_PHOTO',file.name)
        },3000);
        console.log(this.photo);
        console.log(response);
      } catch (error) {
        
      }
      
    },
    async getCards() {
      let response = await getAllPostsById(this.userId);
      this.cards = await response.json();
      console.log(this.cards);
    },
  },
  async created() {
    let user = this.$store.getters.USER;
    this.email = user.email;
    this.phone = user.phone;
    this.name = user.name;
    this.photo = user.photo;
    this.userId = user.id;
    await this.getCards();
    // let response=await checkLogin('test','123');
    // this.cards=await response.json();
    // this.email=this.cards.email;
    // response=await getAllPostsById(this.cards.id);
    // this.cards=await response.json();
    // console.log(this.cards);
  },
};
</script>
<style>
.user_container {
  position: relative;
  height: 500px;
}
.obiayvenie {
  position: absolute;
  width: 1147px;
  height: 161px;
  left: 68px;
  top: 580px;
  background: #c4c4c4;
  border-radius: 15px;
}
.obiayvenie1 {
  position: absolute;
  width: 1147px;
  height: 161px;
  left: 68px;
  top: 760px;
  background: #c4c4c4;
  border-radius: 15px;
}
.obiav {
  font-family: "Inter";
  font-style: normal;
  font-weight: 400;
  font-size: 50px;
  line-height: 61px;
  margin: 0px;
  color: #000000;
}
.edituser {
  position: absolute;
  width: 205px;
  height: 49px;
  left: 370px;
  top: 440px;
  font-family: "Inter";
  font-style: normal;
  font-weight: 400;
  font-size: 18px;
  line-height: 24px;
  color: #000000;
}
.edit--photo{
  position: absolute;
  left: 190px;
  top: 440px;
}
.Zagalovok {
  position: absolute;
  width: 500px;
  height: 88px;
  left: 68px;
  top: 56px;

  font-family: "Inter";
  font-style: normal;
  font-weight: 400;
  font-size: 50px;
  line-height: 61px;
  color: #000000;
}
.circle {
  position: absolute;
  width: 250px;
  height: 250px;
  left: 190px;
  top: 170px;
  border-radius: 50%;
  background: #c4c4c4;
}
.avatar{
  object-fit: cover;
  width: 250px;
  height: 250px;
  border-radius: 50%;
}
.tel {
  position: absolute;
  width: 117px;
  height: 26px;
  left: 489px;
  top: 157px;
  font-family: "Inter";
  font-style: normal;
  font-weight: 400;
  font-size: 22px;
  line-height: 27px;
  text-align: right;
  color: #000000;
}
.fam {
  position: absolute;
  width: 117px;
  height: 26px;
  left: 489px;
  top: 208px;
  font-family: "Inter";
  font-style: normal;
  font-weight: 400;
  font-size: 22px;
  line-height: 27px;
  text-align: right;
  color: #000000;
}
.im {
  position: absolute;
  width: 117px;
  height: 26px;
  left: 489px;
  top: 254px;
  font-family: "Inter";
  font-style: normal;
  font-weight: 400;
  font-size: 22px;
  line-height: 27px;
  text-align: right;
  color: #000000;
}
.ot {
  position: absolute;
  width: 122px;
  height: 26px;
  left: 489px;
  top: 299px;
  font-family: "Inter";
  font-style: normal;
  font-weight: 400;
  font-size: 22px;
  line-height: 27px;
  text-align: right;
  color: #000000;
}
.pocht {
  position: absolute;
  width: 122px;
  height: 26px;
  left: 489px;
  top: 338px;
  font-family: "Inter";
  font-style: normal;
  font-weight: 400;
  font-size: 22px;
  line-height: 27px;
  text-align: right;
  color: #000000;
}
.tel1 {
  position: absolute;
  width: 240px;
  height: 26px;
  left: 615px;
  top: 179px;
  background: #c4c4c4;
  border-radius: 6px;
}
.fam1 {
  position: absolute;
  width: 240px;
  height: 26px;
  left: 615px;
  top: 228px;
  background: #c4c4c4;
  border-radius: 6px;
}
.im1 {
  position: absolute;
  width: 240px;
  height: 26px;
  left: 615px;
  top: 274px;
  background: #c4c4c4;
  border-radius: 6px;
}
.ot1 {
  position: absolute;
  width: 240px;
  height: 26px;
  left: 615px;
  top: 321px;

  background: #c4c4c4;
  border-radius: 6px;
}
.pocht1 {
  position: absolute;
  width: 240px;
  height: 26px;
  left: 615px;
  top: 363px;
  background: #c4c4c4;
  border-radius: 6px;
}
</style>