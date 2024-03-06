const month = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
const currentDate = new Date();
const monthName = month[currentDate.getMonth()];

// function to get the first day of the current month
function getFirstDayOfMonth(year, month) {
    return new Date(year, month, 1).getDay();
}

const firstDay = getFirstDayOfMonth(currentDate.getFullYear(), currentDate.getMonth());

// get number of days in the current month
const lastDay = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);
const daysInMonth = lastDay.getDate();

// display the month name
document.getElementById("month").innerHTML = monthName;

// get element where days will be appended
const daysList = document.getElementById('days-list');

// generate spacing cards
for (let i = 0; i < firstDay - 1; i++) {
    const spacingContainer = document.createElement('li');
    spacingContainer.classList.add('day-container');
    const spacingCard = document.createElement('div');
    spacingCard.classList.add('day-card');
    spacingContainer.appendChild(spacingCard);
    daysList.appendChild(spacingContainer);
}

// loop through days and create cards
for (let i = 1; i <= daysInMonth; i++) {
    const dayContainer = document.createElement('li');
    dayContainer.classList.add('day-container');
    const dayCard = document.createElement('div');
    dayCard.classList.add('day-card');
    dayCard.textContent = i;

    // add marking style if the card generate is the current day
    if (i === currentDate.getDate()) {
        dayCard.classList.add('current-day');
    }

    dayContainer.appendChild(dayCard);
    daysList.appendChild(dayContainer);
}

// calculate the last day of the month
let lastDayOfWeek = new Date(currentDate.getFullYear(), currentDate.getMonth(), daysInMonth).getDay();

// generate trailing empty spacing cards
for (let i = lastDayOfWeek; i < 7; i++) {
    const spacingContainer = document.createElement('li');
    spacingContainer.classList.add('day-container');
    const spacingCard = document.createElement('div');
    spacingCard.classList.add('day-card');
    spacingContainer.appendChild(spacingCard);
    daysList.appendChild(spacingContainer);
}

// fetch HTML modal 
var modal = document.getElementById("myModal");

// fetch the button that opens the modal
var btn = document.getElementById("days-list");

// fetch the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// when the user clicks on the button, open the modal
btn.onclick = function() {
  modal.style.display = "block";
}

// when the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
