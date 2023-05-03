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

    var chart = new CanvasJS.Chart("chartContainer", {
        colorSet: "purpleShades",
        backgroundColor: "transparent",
        animationEnabled: true,
        animationDuration: 600,
        title: {
            text: "Minutes to complete the track per lap",
            fontColor: "white",
            fontFamily: '"Segoe UI", Arial, sans-serif',

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