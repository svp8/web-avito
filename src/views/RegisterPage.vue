 <template>
  <div class="content">
    <div class="window">
      <h1>Регистрация</h1>
      <input
        v-model="email"
        class="input inputTop"
        type="text"
        placeholder="Введите почту"
      />
      <input
        v-model="password"
        class="input"
        type="text"
        placeholder="Введите пароль"
      />
      <button class="button butReg" type="button" name="button" id="buttonSave" @click='SendRegister'>
        Зарегистрироваться
      </button>
    </div>
  </div>
</template>
 
 <script>
 import { register } from "@/api/register";
export default {
  data() {
    return {
      email: "",
      password: "",
      isLogged: false,
    };
  },
  methods: {
    async SendRegister() {
      let response = await register(this.email, this.password);
      if (response.ok) {
        let user = await response.json();
        console.log(user);
        this.$router.push({ name: "main" });
      }
    },
  },
};
</script>
 
 <style>
body {
  background-color: #ffffff;
}
.title {
  margin-top: 30px;
}
h1 {
  text-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5);
  font-family: "Sansita";
  font-style: normal;
  font-weight: 400;
  font-size: 35px;
  line-height: 40px;
}
.content {
  width: 460px;
  height: 410px;
  background-color: #9bbec7;
  margin: auto;
  margin-top: 10%;
  box-shadow: 15px 10px 25px rgba(0, 0, 0, 0.25);
  border-radius: 25px;
}
.window {
  padding: 20px;
  text-align: center;
}
.buttons {
  display: flex;
  justify-content: space-around;
  margin-bottom: 20px;
}
.input {
  width: 350px;
  height: 50px;
  background: #e5e5e5;
  box-shadow: 15px 12px 24px rgba(0, 0, 0, 0.25);
  border-radius: 17px;
  margin-bottom: 30px;
  font-size: 20px;
}
.button {
  width: 160px;
  height: 40px;
  background: #f10f2a;
  box-shadow: 14px 14px 30px rgba(0, 0, 0, 0.25);
  border-radius: 19px;
  font-size: 20px;
}
.inputTop {
  margin-top: 10px;
}
.butReg {
  width: 200px;
}
</style>