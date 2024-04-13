'use strict';

var password = document.getElementById("password");
var password2 = document.getElementById("password2");
var reg = document.getElementById("reg");


function passwordСomprasion(){
    if(password.value !== password2.value){
        alert("Пароли не совпадают")
        reg.disabled = true;
    }
    else{
        reg.disabled = false;
    }
}


