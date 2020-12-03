var usuario;
var senha;

var url = window.location.search;
var vetLogSenha = url.split("&");
if (url != "" && (url.includes("usuario"))) {
    var vetLog = vetLogSenha[0].split("=");
    var vetSenha = vetLogSenha[1].split("=");

    usuario = vetLog[1];
    senha = vetSenha[1];
}
//console.log(usuario,senha);

function inserirUsuario() {
    var login = document.getElementById('login').value;
    var senha = document.getElementById('senha').value;
    var adm = document.getElementById('adm');
    var pessoa = document.getElementById('pessoa').value;

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
        window.location = "menu.html?usuario="+usuario+"&senha="+senha;
    }).catch(function (response) {
        console.log("Campos preenchidos incorretamente");
    });
}