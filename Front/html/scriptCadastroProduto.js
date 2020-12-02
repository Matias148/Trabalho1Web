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

function postar() {
    var descricao = document.getElementById('descri').value;
    var quantidade = document.getElementById('quanti').value;
    var idade = document.getElementById('idade').value;
    var preCom = document.getElementById('preCom').value;
    var preVenFisi = document.getElementById('preVenFisi').value;
    var preVenJuri = document.getElementById('preVenJuri').value;


    axios.post('http://localhost:8080/api/produto',
        {
            'descricao': descricao,
            'quatidadeEstoque': quantidade,
            'idadePermitida': idade,
            'precoCompra': preCom,
            'precoVendaFisica': preVenFisi,
            'precoVendaJuridica': preVenJuri
        },
        {
            headers: {
                'usuario': usuario,
                'senha': senha
            }
        }
    ).then(function (response) {
        console.log(response.data);
        window.location = "menu.html?usuario="+login+"&senha="+senha;
    }).catch(function (response) {
        //console.log(response.data);
        console.log("Campos preenchidos incorretamente");
        //tirar
        //window.location = "menu.html?usuario="+login+"&senha="+senha;
    });
}