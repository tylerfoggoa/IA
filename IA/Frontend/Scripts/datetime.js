const month = ["January","February","March","April","May","June","July","August","September","October","November","December"];

const d = new Date();
let monthName = month[d.getMonth()];
document.getElementById("month").innerHTML = monthName;


setInterval(function() {
    // Get current date and time
    var now = new Date();
    var datetime = now.toLocaleString();

    // Insert date and time into HTML
    document.getElementById("datetime").innerHTML = datetime;
}, 1000);