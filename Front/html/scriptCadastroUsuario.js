let usuario;
let senha;

let url = window.location.search;
let vetLogSenha = url.split("&");
if (url != "" && (url.includes("usuario"))) {
    let vetLog = vetLogSenha[0].split("=");
    let vetSenha = vetLogSenha[1].split("=");

    usuario = vetLog[1];
    senha = vetSenha[1];
}
//console.log(usuario,senha);

function inserirUsuario() {
    let login = document.getElementById('login').value;
    let senha = document.getElementById('senha').value;
    let adm = document.getElementById('adm');
    let pessoa = document.getElementById('pessoa').value;

    if (login == "" || senha == "" || pessoa == ""){
        console.warn("Nenhum campo de texto pode ficar em branco");
        return;
    }

    axios.post('http://localhost:8080/api/usuario', {
        "isAdministrador": adm.checked,
        "login": login,
        "senha": senha,
        "pessoa": {'id': pessoa}
    }).then(function (response) {
        console.log(response.data);
        window.location = "menu.html?usuario="+login+"&senha="+senha;
    }).catch(function (response) {
        console.log("Campos preenchidos incorretamente");
    });
}