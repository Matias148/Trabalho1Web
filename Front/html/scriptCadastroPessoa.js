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

function teste() {
    var tipo = document.getElementById('tipo').value;
    var cpf = document.getElementById('cpf');
    var rg = document.getElementById('rg');
    var cnpj = document.getElementById('cnpj');

    if (tipo == "FISICA"){
        cnpj.disabled = true;
        cpf.disabled = false;
        rg.disabled =false;
    }else{
        cnpj.disabled = false;
        cpf.disabled = true;
        rg.disabled = true;
    }
}

function postar() {
    var tipo = document.getElementById('tipo').value;
    var cpf = document.getElementById('cpf').value;
    var rg = document.getElementById('rg').value;
    var cnpj = document.getElementById('cnpj').value;
    var idRes = document.getElementById('idRespon').value;
    var situ = document.getElementById('situ').value;
    var ape = document.getElementById('apelido').value;
    var nome = document.getElementById('nome').value;
    var data = document.getElementById('data').value;

    if (idRes == ''){idRes=null;}

    var anos = data.toString().split("-")[0];
    if (parseInt(anos) > 2002 && idRes == null) {
        console.log("Menores de idade precisam ter um responsável");
    }else {
        axios.post('http://localhost:8080/api/pessoa', {
            'idResponsavel': idRes,
            'tipo': tipo,
            'situacao': situ,
            'nome': nome,
            'apelido': ape,
            'dataNascimento': data,
            'cpf': cpf,
            'rg': rg,
            'cnpj': cnpj
        }).then(function (response) {
            console.log(response.data);
            window.location = "menu.html?usuario="+login+"&senha="+senha;
        }).catch(function (response) {
            //console.log(response.data);
            console.log("Campos preenchidos incorretamente");
            //tirar
            //window.location = "menu.html?usuario="+login+"&senha="+senha;
        });
    }
}