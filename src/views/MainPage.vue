<template>
<div>
  <header>
      <div class="conteiner">
        <div class="header_inner">
          <div class="header_logo">
            <img class="img_Logo" src="../assets/mainLogo.png" alt="">
            <p class="text_Logo">Воронка</p>
          </div>

          <nav class="header_nav">
            <button id="postAds" class="buttonAdd text_Buttons" type="button" name="button">Разместить объявление</button>
            <button id="personalRoom" class="buttonLK" type="button" name="button"></button>
            <button id="output" class="buttonOut text_Buttons" type="button" name="button">Выйти</button>
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
         <input id="searchAd" class="searchAdd" type="text" placeholder="Поиск">
       </div>

       <div class="categories">
         <p>Категория</p>
         <select id="selectCat" class="selectCase" name="sel" placeholder="Выберите категорию">
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
              <input id="countS" class="countStart_End" type="text" placeholder="Минимальная цена">
           </div>

           <div class="countEnd">
             <p>до</p>
             <input id="countE" class="countStart_End" type="text" placeholder="Максимальная цена">
           </div>

         </div>


       </div>

    </div>
  </div>
</div>

  <!-- Тут будут объявления !-->
<div class="conteiner">
  <div class="content_all">
    <div class="card">
      
    </div>

  </div>

</div>
</div>
</template>

<script>
export default {

}
</script>

<style>
body{
  margin: 0 0;
}
.conteiner{
  width: 100%;
	margin: 0 auto;
}
.header_inner{
	display: flex;
	justify-content: space-between;
  background-color: #251605;
  color: #FFFFFF;
	align-items: center;
	border-bottom: 1px solid #515369;
  height: 45px;
}
.img_Logo{
  width: 61px;
height: 44px;
left: 0px;
top: 0px;
}
.header_logo{
  display: flex;
  justify-content: space-between;
  height: 45px;
}
.text_Logo{
  font-size: 25px;
  margin: auto;
}
.header_nav{
  display: flex;
  justify-content: space-around;
  width: 30%;
  height: 100%;
  align-items: center;
}
.buttonAdd{
  width: 250px;
  height: 38px;
  background: #F6E27F;
  border-radius: 10px;

}
.buttonLK{
  width: 35px;
  height: 35px;
  border-radius: 35px;
  background-image: url('../assets/lk_image.png');
  background-size: 35px 35px;
  background-position: center;
}
.buttonOut{
  width: 82px;
height: 38px;
background: #F6E27F;
border-radius: 10px;
}
.text_Buttons{
  font-family: 'Inter';
font-style: normal;
font-weight: 700;
font-size: 19px;
line-height: 23px;
align-items: center;
text-align: center;
color: #FFFFFF;
}
.found{
  margin-top: 22px;
  text-align: center;
}
.found_inner{
  display:flex;
  justify-content: space-around;
  height: 120px;
  width: 86%;

  margin: auto;
  background: #9BBEC7;
  border-radius: 15px;
}
.search{
  display: block;
  align-items: center;
  text-align: center;
  width: 40%;
}
.searchAdd{
  margin-left: 10%;
  width: 405px;
  height: 52px;
  background: #FFFFFF;
  border: 2px solid #000000;
  box-sizing: border-box;
  box-shadow: 5px 5px 20px rgba(0, 0, 0, 0.25);
  border-radius: 17px;
}
.categories{
  display: block;
  align-items: center;
  width: 20%;
}
.selectCase{
  width: 200px;
height: 52px;


background: #FFFFFF;
border: 2px solid #000000;
box-sizing: border-box;
box-shadow: 5px 5px 20px rgba(0, 0, 0, 0.25);
border-radius: 17px;
}
.filter{
  width: 40%;
  text-align: center;
}
.filter_inner{
  display: flex;
  justify-content:space-around;
}
.countStart{
  display: flex;
  justify-content: center;
}
.countEnd{
  display:flex;
  justify-content: center;
}
.countStart_End{
  background: #FFFFFF;
border: 2px solid #000000;
box-sizing: border-box;
box-shadow: 5px 5px 20px rgba(0, 0, 0, 0.25);
border-radius: 17px;
text-align: center;
margin-left: 5px;
}
.content_all{
  margin: auto;
  background-color: #C4C4C4;
}
.card{
  display: flex;
  justify-content: space-around;
}

</style>