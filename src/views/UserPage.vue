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
      <p class="Zagalovok">Личный кабинет</p>
      <div class="circle"></div>
      <button class="edituser">Редактировать профиль</button>
      <p class="tel">Телефон: </p>
      <textarea v-model="telephon" class="tel1" placeholder="Введите новый телефон"></textarea>
      <p class="fam">Фамилия: </p>
      <textarea v-model="fam" class="fam1" placeholder="Введите новую фамилию"></textarea>
      <p class="im">Имя: </p>
      <textarea v-model="im" class="im1" placeholder="Введите новое имя"></textarea>
      <p class="ot">Отчество: </p>
      <textarea v-model="ot" class="ot1" placeholder="Введите новое отчество"></textarea>
      <p class="pocht">Почта: </p>
      <textarea v-model="pochta" class="pocht1" placeholder="Введите новый адрес эл.почты"></textarea>
       <p class="obiav">Мои объявления</p>
  <div class="obiayvenie"></div>
  <div class="obiayvenie1"></div>
  </div>
</template>
<style>
.obiayvenie{
position: absolute;
width: 1147px;
height: 161px;
left: 68px;
top: 580px;
background: #C4C4C4;
border-radius: 15px;
}
.obiayvenie1{
position: absolute;
width: 1147px;
height: 161px;
left: 68px;
top: 760px;
background: #C4C4C4;
border-radius: 15px;
}
.obiav{
position: absolute;
width: 500px;
height: 88px;
left: 68px;
top: 460px;
font-family: 'Inter';
font-style: normal;
font-weight: 400;
font-size: 50px;
line-height: 61px;
color: #000000;
}
.edituser{
position: absolute;
width: 205px;
height: 49px;
left: 210px;
top: 440px;
font-family: 'Inter';
font-style: normal;
font-weight: 400;
font-size: 18px;
line-height: 24px;
color: #000000;

}
.Zagalovok {
position: absolute;
width: 500px;
height: 88px;
left: 68px;
top: 56px;

font-family: 'Inter';
font-style: normal;
font-weight: 400;
font-size: 50px;
line-height: 61px;
color: #000000;

}
.circle{
position: absolute;
width: 250px;
height: 250px;
left: 190px;
top: 170px;
border-radius: 50%;
background: #C4C4C4;
}
.tel{
position: absolute;
width: 117px;
height: 26px;
left: 489px;
top: 157px;
font-family: 'Inter';
font-style: normal;
font-weight: 400;
font-size: 22px;
line-height: 27px;
text-align: right;
color: #000000;
}
.fam{
position: absolute;
width: 117px;
height: 26px;
left: 489px;
top: 208px;
font-family: 'Inter';
font-style: normal;
font-weight: 400;
font-size: 22px;
line-height: 27px;
text-align: right;
color: #000000;
}
.im{
position: absolute;
width: 117px;
height: 26px;
left: 489px;
top: 254px;
font-family: 'Inter';
font-style: normal;
font-weight: 400;
font-size: 22px;
line-height: 27px;
text-align: right;
color: #000000;
}
.ot{
position: absolute;
width: 122px;
height: 26px;
left: 489px;
top: 299px;
font-family: 'Inter';
font-style: normal;
font-weight: 400;
font-size: 22px;
line-height: 27px;
text-align: right;
color: #000000;
}
.pocht{
    position: absolute;
width: 122px;
height: 26px;
left: 489px;
top: 338px;
font-family: 'Inter';
font-style: normal;
font-weight: 400;
font-size: 22px;
line-height: 27px;
text-align: right;
color: #000000;
}
.tel1{
position: absolute;
width: 240px;
height: 26px;
left: 615px;
top: 179px;
background: #C4C4C4;
border-radius: 6px;
}
.fam1{
    position: absolute;
width: 240px;
height: 26px;
left: 615px;
top: 228px;
background: #C4C4C4;
border-radius: 6px;
}
.im1{
position: absolute;
width: 240px;
height: 26px;
left: 615px;
top: 274px;
background: #C4C4C4;
border-radius: 6px;
}
.ot1{
position: absolute;
width: 240px;
height: 26px;
left: 615px;
top: 321px;

background: #C4C4C4;
border-radius: 6px;
}
.pocht1{
position: absolute;
width: 240px;
height: 26px;
left: 615px;
top: 363px;
background: #C4C4C4;
border-radius: 6px;
}
</style>