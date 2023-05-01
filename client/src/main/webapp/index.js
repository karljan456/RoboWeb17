var xmlhttp=new XMLHttpRequest();

const slider = document.getElementById("speed");

const speedText = document.getElementById("currentSpeed");

slider.addEventListener("input", function() {

//	var jsonspeed = JSON.parse(slider.value);
	
    speedText.innerHTML = "Current Speed: " + slider.value + " units";
    
    xmlhttp.open("POST", "../rest/robot/writespeed", true);
    xmlhttp.send();	

});
