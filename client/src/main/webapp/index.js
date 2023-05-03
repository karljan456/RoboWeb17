const slider = document.getElementById("speed");
const speedText = document.getElementById("currentSpeed");

speedText.innerHTML = "Current Speed: " + slider.value + " degrees/sec";

slider.addEventListener("input", function() {
    var xmlhttp = new XMLHttpRequest();
    var url = "../rest/robot/writespeed";
    var data = "speed=" + slider.value;

    speedText.innerHTML = "Current Speed: " + slider.value + " degrees/sec";

    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            console.log(xmlhttp.responseText);
        }
    };

    xmlhttp.send(data);
});

const stopButton = document.getElementsById("stopButton").onclick = function() {
    var xmlhttp = new XMLHttpRequest();
    var url = "../rest/robot/getstop";
    var data = "stop=0";

    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            console.log(xmlhttp.responseText);
        }
    };

    xmlhttp.send(data);
}
const playButton = document.getElementsById("play-button");
const lightsButton = document.getElementsById("light-button");

stopButton.addEventListener("mousedown", function() {

});

for (let e of document.querySelectorAll('input[type="range"].slider-progress')) {
    e.style.setProperty('--value', e.value);
    e.style.setProperty('--min', e.min == '' ? '0' : e.min);
    e.style.setProperty('--max', e.max == '' ? '100' : e.max);
    e.addEventListener('input', () => e.style.setProperty('--value', e.value));
  }

 
