const month = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
const currentDate = new Date();
const monthName = month[currentDate.getMonth()];

// Function to get the first day of the current month
function getFirstDayOfMonth(year, month) {
    return new Date(year, month, 1).getDay();
}

const firstDay = getFirstDayOfMonth(currentDate.getFullYear(), currentDate.getMonth());

// get number of days in the current month
const lastDay = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);
const daysInMonth = lastDay.getDate();

// Display the month name
document.getElementById("month").innerHTML = monthName;

// Get the element where the days will be appended
const daysList = document.getElementById('days-list');

// Generate empty spacing cards
for (let i = 0; i < firstDay - 1; i++) {
    const spacingContainer = document.createElement('li');
    spacingContainer.classList.add('day-container');
    const spacingCard = document.createElement('div');
    spacingCard.classList.add('day-card');
    spacingContainer.appendChild(spacingCard);
    daysList.appendChild(spacingContainer);
}

// Loop through days to create cards
for (let i = 1; i <= daysInMonth; i++) {
    const dayContainer = document.createElement('li');
    dayContainer.classList.add('day-container');
    const dayCard = document.createElement('div');
    dayCard.classList.add('day-card');
    dayCard.textContent = i;

    // If the card we are generating matches the current day, add special style to it
    if (i === currentDate.getDate()) {
        dayCard.classList.add('current-day');
    }

    dayContainer.appendChild(dayCard);
    daysList.appendChild(dayContainer);
}

// Calculate the last day of the month
let lastDayOfWeek = new Date(currentDate.getFullYear(), currentDate.getMonth(), daysInMonth).getDay();

// Generate trailing empty spacing cards
for (let i = lastDayOfWeek; i < 7; i++) {
    const spacingContainer = document.createElement('li');
    spacingContainer.classList.add('day-container');
    const spacingCard = document.createElement('div');
    spacingCard.classList.add('day-card');
    spacingContainer.appendChild(spacingCard);
    daysList.appendChild(spacingContainer);
}
