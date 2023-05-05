const slider = document.getElementById("speed");
const speedText = document.getElementById("currentSpeed");
let obstacle = document.getElementById("obstacle");


speedText.innerHTML = "Current Speed: " + slider.value + " degrees/sec";

slider.addEventListener("input", function () {
    var xmlhttp = new XMLHttpRequest();
    var url = "../rest/robot/writespeed";
    var data = "speed=" + slider.value;

    speedText.innerHTML = "Current Speed: " + slider.value + " degrees/sec";

    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            console.log(xmlhttp.responseText);
        }
    };

    xmlhttp.send(data);
});

function sendParameters(command) {
    var xmlhttp = new XMLHttpRequest();
    var url = "../rest/robot/writecommand";
    var data = "command=" + command;

    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                console.log(xmlhttp.responseText);
            } else {
                console.log('Error: ' + xmlhttp.statusText);
            }
        }
    };

    xmlhttp.send(data);
}

for (let e of document.querySelectorAll('input[type="range"].slider-progress')) {
    e.style.setProperty('--value', e.value);
    e.style.setProperty('--min', e.min == '' ? '0' : e.min);
    e.style.setProperty('--max', e.max == '' ? '100' : e.max);
    e.addEventListener('input', () => e.style.setProperty('--value', e.value));
}


// Getting obstacle data
var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {

            var data = JSON.parse(this.responseText);

            const obstacleData = data[data.length - 1];

            console.log(obstacleData);

            obstacle.innerHTML = "Obstacle detected last time: " + obstacleData + " times";
            
        }
    };
    xhttp.open("GET", "../rest/robot/getobstacles", true);
    xhttp.send();
