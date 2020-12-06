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

function cadastroProduto() {
    window.location = "cadastroProduto.html?usuario="+usuario+"&senha="+senha;
}

function carregar() {
    // var todosProdutos;
    // var url;
    // if (document.getElementById('pm').value == ""){
    //     url = 'http://localhost:8080/api/produto';
    // }else{
    //     url = 'http://localhost:8080/api/produto?precoMaximo='+document.getElementById('pm').value;
    // }

    axios.get('http://localhost:8080/api/produto', {
        headers: {
            'usuario': usuario,
            'senha': senha
        }
    }).then(function (response) {
        console.log(response.data);

        let div = document.createElement("div");
        div.id = "corpo";
        for (let i = 0; i < response.data.length; i++) {
            let tabela = document.createElement("table");
            let tblinha = document.createElement("tr");
            let tbDescri = document.createElement("td");
            let tbQuanti = document.createElement("td");
            let tbVenFis = document.createElement("td");
            let tbVenJur = document.createElement("td");
            var btn = document.createElement("button");


            let descri = document.createTextNode(response.data[i].descricao);
            let quanti = document.createTextNode(response.data[i].quantidadeEstoque.toString());
            let venFis = document.createTextNode(response.data[i].precoVendaFisica.toString());
            let venJur = document.createTextNode(response.data[i].precoVendaJuridica.toString());

            tbDescri.appendChild(descri);
            tbQuanti.appendChild(quanti);
            tbVenFis.appendChild(venFis);
            tbVenJur.appendChild(venJur);
            tblinha.appendChild(tbDescri);
            tblinha.appendChild(tbQuanti);
            tblinha.appendChild(tbVenFis);
            tblinha.appendChild(tbVenJur);
            tabela.appendChild(tblinha);

            tbDescri.style = "border: 1px solid blue";
            tbQuanti.style = "border: 1px solid blue";
            tbVenFis.style = "border: 1px solid blue";
            tbVenJur.style = "border: 1px solid blue";
            tabela.style = "border: 1px solid black";
            div.appendChild(tabela);

        }
        let corpo = document.getElementById('corpo');

        document.body.removeChild(corpo);
        document.body.appendChild(div);
    }).catch(function (response) {
        console.log(response.data);
    });
}