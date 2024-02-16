// JS file to control functionality of the website and toggle css behaviors

document.querySelectorAll('.day-card').forEach(item => {
    item.addEventListener('click', event => {
        item.classList.toggle('active');
        item.querySelectorAll('.sub-card').forEach(subCard => {
            subCard.classList.toggle('hidden');
        });
    });
});
