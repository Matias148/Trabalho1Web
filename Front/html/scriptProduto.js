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
console.log(usuario,senha);

function carregar() {
    var todosProdutos;
    var url;
    if (document.getElementById('pm').value == ""){
        url = 'http://localhost:8080/api/produto';
    }else{
        url = 'http://localhost:8080/api/produto?precoMaximo='+document.getElementById('pm').value;
    }

    axios.get(url, {
        headers: {
            'usuario': usuario,
            'senha': senha
        }
    }).then(function (response) {
        console.log(response.data);
        window.location = "menu.html?usuario="+usuario+"&senha="+senha;
    }).catch(function (response) {
        console.log(response.data);
        window.location = "menu.html?usuario="+document.getElementById('login').value+"&senha="+
            document.getElementById('senha').value;
        //tirar ^
    });
}