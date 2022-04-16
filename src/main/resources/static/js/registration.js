function passwordValidation() {
    const password = document.getElementById('password').value;
    const rePassword = document.getElementById('repeat-password').value;
    if (password !== rePassword) {
        alert("Пароли должны совпадать")
    }
}

function regexpPassword() {
    const password = document.getElementById('password').value;
    if (password.match(/[?#<>%@ ]/) !== null) {
        alert("Введен недопустимый символ. Недопустимые символы: (?#<>%@ )")
    }
}


function validation() {
    const listEl = [
        document.getElementById('login'),
        document.getElementById('firstname'),
        document.getElementById('lastname'),
        document.getElementById('region'),
        document.getElementById('password'),
        document.getElementById('repeat-password')
    ]

    for (let i = 0; i < listEl.length; i++) {
        const element = listEl[i]
        if (element.value.length === 0) {
            alert("Поле " + element.name + " не может быть пустым")
            return false
        }
    }
    passwordValidation()
}
