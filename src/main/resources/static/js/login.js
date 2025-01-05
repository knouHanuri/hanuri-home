const profileImage = document.getElementById('profileImage');
const profileMenu = document.getElementById('profile-menu');

if (profileImage !== null) {
    profileImage.addEventListener('click', () => {
        profileMenu.style.display = profileMenu.style.display === 'block' ? 'none' : 'block';
    });

    document.addEventListener('click', (event) => {
        if (!event.target.closest('.profile-control')) {
            profileMenu.style.display = 'none';
        }
    });
}

const hamMenuImage = document.getElementById('hamManuImage');
const hamMenu = document.getElementById('ham-menu');

if (hamMenuImage != null) {
    hamMenuImage.addEventListener('click', () => {
        hamMenu.style.display = hamMenu.style.display === 'none' ? 'block' : 'none';
    });

    document.addEventListener('click', (event) => {
        if (!event.target.closest('.ham-menu-control')) {
            hamMenu.style.display = 'none';
        }
    });

}
