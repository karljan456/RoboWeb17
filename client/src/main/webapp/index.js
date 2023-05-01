const slider = document.getElementById("speed");

const speedText = document.getElementById("currentSpeed");

slider.addEventListener("input", function() {

    speedText.innerHTML = "Current Speed: " + slider.value + " units";
    console.log(slider.value)

});
