var usuario;
var senha;

var url = window.location.search;
var vetLogSenha = url.split("&");
if (url != ""){
    var vetLog = vetLogSenha[0].split("=");
    var vetSenha = vetLogSenha[1].split("=");

    usuario = vetLog[1];
    senha = vetSenha[1];
}
// console.log(usuario,senha);

function entrar(){
    axios.get('http://localhost:8080/api/usuario', {
        headers: {
            'usuario': document.getElementById('login').value,
            'senha': document.getElementById('senha').value
        }
    }).then(function (response) {
        console.log(response.data);
        window.location = "menu.html?usuario="+document.getElementById('login').value+"&senha="+
            document.getElementById('senha').value;
    }).catch(function (response) {
        console.log(response.data);
        window.location = "menu.html?usuario="+document.getElementById('login').value+"&senha="+
            document.getElementById('senha').value;
        //tirar ^
    });
}

function cadastrar() {
    window.location = "cadastroUsuario.html";
}