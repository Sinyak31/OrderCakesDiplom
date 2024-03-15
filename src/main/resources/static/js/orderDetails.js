'use strict';


const street = document.getElementById("street");
const house = document.getElementById("house");
const flat = document.getElementById("flat");
const dost = document.getElementById("dost");
const weightInput = document.getElementById("weightCake");

const disable = () => {
    street.disabled = true;
    house.disabled = true;
    flat.disabled = true;
}
const enable = () => {
    street.disabled = false;
    house.disabled = false;
    flat.disabled = false;
}


const calculatePrice = () => {
    const costOneKG = document.getElementById("cost").value;
    const weight = weightInput.value;
    let price = weight * costOneKG;

    if (dost.checked) {
        price += 500;
    }
    document.querySelector('input[name="order.cost"]').value = price;

}
const switchDestinationInputsState = () => {
    if (dost.checked) {
        enable();
    } else {
        disable();
    }
}
const checkBoxClickHandler = () => {
    switchDestinationInputsState();
    calculatePrice();
}
dost.addEventListener("click", checkBoxClickHandler);
weightInput.addEventListener("input", calculatePrice);