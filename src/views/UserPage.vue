<template>
  <div>
    <Header />
    <div class="user_container">
      <p class="Zagalovok">Личный кабинет</p>
      <div class="circle"><img class="avatar" :src="require('@/assets/'+photo)"></div>
      <input class="edit--photo" type="file" @change="changePhoto" />
      <button @click="editUser" class="edituser">Редактировать профиль</button>
      <p class="tel">Телефон:</p>
      <textarea
        v-model="phone"
        class="tel1"
        placeholder="Введите новый телефон"
        :disabled="!isEditing"
      ></textarea>
      <p class="fam">Имя:</p>
      <textarea class="fam1" v-model="name" placeholder="Введите новое имя" :disabled="!isEditing"></textarea>
      <p class="pocht">Почта:</p>
      <textarea
        v-model="email"
        class="pocht1"
        placeholder="Введите новый адрес эл.почты"
        :disabled="!isEditing"
      ></textarea>
    </div>
    <div class="posts_and_messages">
    <div class="posts">
      <p class="obiav">Мои объявления</p>
      <div class="cards box">
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
    <div class="messages">
      <p class="obiav">Отклики на объявления</p>
      <div class="messages__box">
        <div class="message" v-for="item in messages" :key="item.id">
          <div class="message__header">
            <h3 class="message__post">Объявление: {{getPost(item.postId).title}}</h3>
            <h5 class="message__sender">От: {{item.userName}}</h5>
          </div>
          <div class="message__body">
            <p>{{item.message}}</p>
            <p class="message__body__date">Отправлено: {{item.date}}</p>
          </div>
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
import { getAllMessagesByUserId } from "@/api/message";
import { updateUser } from "@/api/register";
export default {
  data() {
    return {
      email: "",
      phone: "",
      name: "",
      photo: "",
      userId: 0,
      cards: [],
      messages:[],
      isEditing:false,
    };
  },
  components: {
    Header,
  },
  computed:{
    
  },
  methods: {
    getPost(id){
      return this.cards.filter((item)=>item.id==id)[0];
    },
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
    async editUser() {
      if(this.isEditing===true){
        try {
        let response=await updateUser({
          email:this.email,
          name:this.name,
          id:this.userId,
          phone:this.phone,
        });
        response=await response.json();
        this.$store.dispatch('GET_USER',response);
        this.isEditing=false;
      } catch (error) {
        console.log(error)
      }
      }
      else{
        this.isEditing=true;
      }
      
      
    },
    async getCards() {
      let response = await getAllPostsById(this.userId);
      this.cards = await response.json();
    },
    async getMessages() {
      let response = await getAllMessagesByUserId(this.userId);
      this.messages = await response.json();
      console.log(this.messages);
    },
  },
  async created() {
    let user = this.$store.getters.USER;
    this.email = user.email;
    this.phone = user.phone;
    this.name = user.name;
    this.photo = user.photo;
    this.userId = user.id;
    try {
      await this.getCards();
      await this.getMessages();
    } catch (error) {
      console.log(error)
    }
  },
};
</script>
<style scoped>
.posts_and_messages{
  padding:7px;
  display: flex;
  flex-direction: row;
}
.posts,messages{
  flex:1;
}
h3,h5{
  margin:0;
}
.box{
  border:1px solid grey;
  border-radius: 5px;
  margin-right: 10px;
}
.messages__box{
  /* border:1px solid green; */
  display:flex;
  flex-direction: column;
}
.message{
  text-align: left;
  /* border:0.5px solid grey; */
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  margin-bottom: 7px;
}
.message__header{
  padding:7px;
  border-bottom: 0.5px solid rgb(200, 196, 196);
  color:rgb(71, 210, 148);
}
.message__body{
  padding:7px;
}
.message__body__date{
  opacity: 0.5;
  font-size: 8px;
}
.message__sender{
  opacity: 0.5;
}
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
  text-align: left;
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