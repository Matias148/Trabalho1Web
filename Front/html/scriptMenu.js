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

function index() {
    window.location = "index.html?usuario="+usuario+"&senha="+senha;
}

function produto() {
    window.location = "produto.html?usuario="+usuario+"&senha="+senha;
}

function pessoa() {
    window.location = "pessoa.html?usuario="+usuario+"&senha="+senha;
}