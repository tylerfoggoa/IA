const month = ["January","February","March","April","May","June","July","August","September","October","November","December"];

const d = new Date();
let monthName = month[d.getMonth()];
document.getElementById("month").innerHTML = monthName;

// Get the ul element where the days will be appended
const daysList = document.getElementById('days-list');

// Get the number of days in the current month
const daysInMonth = new Date(d.getFullYear(), d.getMonth() + 1, 0).getDate();

// Loop through days and create li elements
for (let i = 1; i <= daysInMonth; i++) {
    const dayElement = document.createElement('li');
    dayElement.textContent = i;

    // Check if the current day matches the loop day, add a class to style it
    if (i === d.getDate()) {
        dayElement.classList.add('current-day');
    }

    daysList.appendChild(dayElement);
}

setInterval(function() {
    // Get current date and time
    var now = new Date();
    var datetime = now.toLocaleString();

    // Insert date and time into HTML
    document.getElementById("datetime").innerHTML = datetime;
}, 1000);
