window.onload = function () {
    CanvasJS.addColorSet("purpleShades",
        [//colorSet Array
            "#6756B3",
            "#3361BD",
            "#5582B8",
            "#63A8BF",
            "#4245B3",
            "#534882"
        ]);

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var data = JSON.parse(this.responseText);
            var dataPoints = [];
            for (var i = 0; i < data.length; i++) {
                dataPoints.push({ x: data[i].x, y: data[i].y, label: data[i].y + " minutes"});
            }
            var chart = new CanvasJS.Chart("chartContainer", {
                colorSet: "purpleShades",
                backgroundColor: "transparent",
                animationEnabled: true,
                animationDuration: 600,
                title: {
                    text: "Minutes to complete the track per lap",
                    fontColor: "#b3b3f7",
                    fontFamily: '"Segoe UI", Arial, sans-serif',

                }, toolTip:{
                    content:" {x}: {y} minutes" ,
                  },
                data: [{
                    type: "doughnut",
                    startAngle: 60,
                    dataPoints: dataPoints,
                    indexLabelFontColor: "white",
                }]



            });
            chart.render();
        }
    };
    xhttp.open("GET", "../rest/robot/getchartdata", true);
    xhttp.send();

}