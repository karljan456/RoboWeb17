var xmlhttp=new XMLHttpRequest();

const slider = document.getElementById("speed");

const speedText = document.getElementById("currentSpeed");

speedText.innerHTML = "Current Speed: " + slider.value + " units";

slider.addEventListener("input", function() {

//	var jsonspeed = JSON.parse(slider.value);
	
    speedText.innerHTML = "Current Speed: " + slider.value + " units";
    
    xmlhttp.open("POST", "../rest/robot/writespeed", true);
    xmlhttp.send();	

});

for (let e of document.querySelectorAll('input[type="range"].slider-progress')) {
    e.style.setProperty('--value', e.value);
    e.style.setProperty('--min', e.min == '' ? '0' : e.min);
    e.style.setProperty('--max', e.max == '' ? '100' : e.max);
    e.addEventListener('input', () => e.style.setProperty('--value', e.value));
  }
