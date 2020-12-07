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

function teste() {
    let tipo = document.getElementById('tipo').value;
    let cpf = document.getElementById('cpf');
    let rg = document.getElementById('rg');
    let cnpj = document.getElementById('cnpj');

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

function editar() {
    let id = document.getElementById('id').value;
    let tipo = document.getElementById('tipo').value;
    let cpf = document.getElementById('cpf').value;
    let rg = document.getElementById('rg').value;
    let cnpj = document.getElementById('cnpj').value;
    let idRes = document.getElementById('idRespon').value;
    let situ = document.getElementById('situ').value;
    let ape = document.getElementById('apelido').value;
    let nome = document.getElementById('nome').value;
    let data = document.getElementById('data').value;

    axios.get('http://localhost:8080/api/usuario', {
        headers: {
            'usuario': usuario,
            'senha': senha
        }
    }).then(function (response) {
        console.log(response.data);
    }).catch(function (response) {
        console.log("Usuário ou senha incorretos");
        return;
    });

    if (idRes == ''){idRes=null;}

    let anos = data.toString().split("-")[0];
    if (parseInt(anos) > 2002 && idRes == null && tipo != "JURIDICA") {
        console.log("Menores de idade precisam ter um responsável");
    }else {
        axios.put('http://localhost:8080/api/pessoa', {
            'id': id,
            'idResponsavel': idRes,
            'tipo': tipo,
            'situacao': situ,
            'nome': nome,
            'apelido': ape,
            'dataNascimento': data,
            'cpf': cpf,
            'rg': rg,
            'cnpj': cnpj
            },
            {
                headers: {
                    'usuario': usuario,
                    'senha': senha
                }
        }).then(function (response) {
            console.log(response.data);
            window.location = "pessoa.html?usuario="+usuario+"&senha="+senha;
        }).catch(function (response) {
            console.log("Campos preenchidos incorretamente");
        });
    }
}

function postar() {
    let tipo = document.getElementById('tipo').value;
    let cpf = document.getElementById('cpf').value;
    let rg = document.getElementById('rg').value;
    let cnpj = document.getElementById('cnpj').value;
    let idRes = document.getElementById('idRespon').value;
    let situ = document.getElementById('situ').value;
    let ape = document.getElementById('apelido').value;
    let nome = document.getElementById('nome').value;
    let data = document.getElementById('data').value;

    if (idRes == ''){idRes=null;}

    let anos = data.toString().split("-")[0];
    if (parseInt(anos) > 2002 && idRes == null && tipo != "JURIDICA") {
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
            window.location = "menu.html?usuario="+usuario+"&senha="+senha;
        }).catch(function (response) {
            console.log("Campos preenchidos incorretamente");
        });
    }
}