// Now generate the days
for (let i = 1; i <= daysInMonth; i++) {
    const dayContainer = document.createElement('li');
    dayContainer.classList.add('day-container');
    const dayCard = document.createElement('div');
    dayCard.classList.add('day-card');
    dayCard.textContent = i;

    // Add an event listener to the card
    dayCard.addEventListener('click', function() {
        // Display the modal when the card is clicked
        document.getElementById('myModal').style.display = "block";
    });

    // Check if the current day matches the loop day, add a class to style it
    if (i === d.getDate()) {
        dayCard.classList.add('current-day');
    }

    dayContainer.appendChild(dayCard);
    daysList.appendChild(dayContainer);
}
