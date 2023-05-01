const slider = document.getElementById("speed");
const speedText = document.getElementById("currentSpeed");

slider.addEventListener("input", function() {
    var xmlhttp = new XMLHttpRequest();
    var url = "../rest/robot/writespeed";
    var data = "speed=" + slider.value;

    speedText.innerHTML = "Current Speed: " + slider.value + " units";

    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            console.log(xmlhttp.responseText);
        }
    };

    xmlhttp.send(data);
});
