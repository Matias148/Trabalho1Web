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

function entrar(){
    axios.get('http://localhost:8080/api/usuario', {
        headers: {
            'usuario': document.getElementById('login').value,
            'senha': document.getElementById('senha').value
        }
    }).then(function (response) {
        window.location = "menu.html?usuario="+document.getElementById('login').value+"&senha="+
            document.getElementById('senha').value;
    }).catch(function (response) {
        console.warn("Usuário ou senha incorretos")
    });
}

function cadastrar() {
    window.location = "cadastroUsuario.html";
}