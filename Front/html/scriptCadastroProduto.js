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

function postar() {
    let descricao = document.getElementById('descri').value;
    let quantidade = document.getElementById('quanti').value;
    let idade = document.getElementById('idade').value;
    let preCom = document.getElementById('preCom').value;
    let preVenFisi = document.getElementById('preVenFisi').value;
    let preVenJuri = document.getElementById('preVenJuri').value;

    axios.get('http://localhost:8080/api/usuario', {
        headers: {
            'usuario': document.getElementById('login').value,
            'senha': document.getElementById('senha').value
        }
    }).then(function (response) {
        console.log(response.data);
    }).catch(function (response) {
        console.log("Usuário ou senha incorretos");
        return;
    });


    axios.post('http://localhost:8080/api/produto',
        {
            'descricao': descricao,
            'quantidadeEstoque': quantidade,
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
        window.location = "menu.html?usuario="+usuario+"&senha="+senha;
    }).catch(function (response) {
        console.log("Campos preenchidos incorretamente");
    });
}