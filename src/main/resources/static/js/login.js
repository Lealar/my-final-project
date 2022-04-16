function activateSubmitButton() {
    const login = document.getElementById("login").value.trim();
    const password = document.getElementById("password").value.trim();
    document.getElementById('submit_button').disabled = !(login && password);
}

function isLengthLoginAndPass() {
    const login = document.getElementById("login").value.trim();
    const password = document.getElementById("password").value.trim();
    if (login.length < 3 || login.length > 10) {
        alert("Поле логин должно быть от 3 до 10 знаков")
        return false;
    } else if (password.length < 3 || password.length > 15) {
        alert("Поле password должно быть от 3 до 15 знаков")
        return false
    }
}