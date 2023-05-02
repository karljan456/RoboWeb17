window.onload = function () {

    var chart = new CanvasJS.Chart("chartContainer", {
        backgroundColor: "transparent",
        animationEnabled: true,
        animationDuration: 600,
        title: {
            text: "Minutes to complete the track per lap",
            fontColor: "white",
            fontFamily: "Arial, sans-serif",

        },
        data: [{
            type: "doughnut",
            startAngle: 60,
            dataPoints: [
                { y: 1, label: "3 minutes" },
                { y: 2, label: "5 minutes" },
                { y: 3, label: "6 minutes" },
                { y: 4, label: "7 minutes" },
                { y: 5, label: "2 minutes" },
                { y: 6, label: "2 minutes" }
            ],
            indexLabelFontColor: "white",
        }]

    });
    chart.render();
}