
Chart.defaults.color = '#f5f5f5';

const chart = document.getElementById('robot');
var xValues = ["2min", "2.5min", "3min", "5min", "2min"];
var yValues = [2, 2.5, 3, 5, 2];
var barColors = [
    "#f8f8f8",
    "#babaf8",
    "#7c7cf8",
    "#3e3ef8",
    "#0000f8"
];

const robot = new Chart(chart, {
    type: "doughnut",
    data: {
        labels: xValues,
        datasets: [{
            backgroundColor: barColors,
            data: yValues,
        }]
    },
    options: {
        plugins: {
            title: {
                display: true,
                text: "Times to complete the track",
                font:{
                    size: 30,
                    family: 'Raleway'
                }
            },
        }

    }
});