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

function index() {
    window.location = "index.html?usuario="+usuario+"&senha="+senha;
}

function produto() {
    window.location = "produto.html?usuario="+usuario+"&senha="+senha;
}

function pessoa() {
    window.location = "pessoa.html?usuario="+usuario+"&senha="+senha;
}