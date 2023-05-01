window.onload = function () {

    var chart = new CanvasJS.Chart("chartContainer", {
        backgroundColor: "transparent",
        animationEnabled: true,
        animationDuration: 600,
        title: {
            text: "Minutes to complete  the track per lap",
            fontColor: "white",
            fontFamily: "Arial, sans-serif",

        },
        data: [{
            type: "doughnut",
            startAngle: 60,
            dataPoints: [
                { y: 3, label: "1 lap" },
                { y: 5, label: "2 lap" },
                { y: 6, label: "3 lap" },
                { y: 7, label: "4 lap" },
                { y: 2, label: "5 lap" },
                { y: 1, label: "6 lap" }
            ],
            indexLabelFontColor: "white",
        }]

    });
    chart.render();
}