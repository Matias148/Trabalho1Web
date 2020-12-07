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

function cadastroProduto() {
    window.location = "cadastroProduto.html?usuario="+usuario+"&senha="+senha;
}

function carregar() {
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
        let div = document.createElement("div");
        div.id = "corpo";

        let tabela = document.createElement("table");
        let tbTopo = document.createElement("tr");
        let descriTop = document.createElement("td");
        let quantiTop = document.createElement("td");
        let vendaTop = document.createElement("td");

        descriTop.appendChild(document.createTextNode("Descrição"));
        quantiTop.appendChild(document.createTextNode("Quantidade Em Estoque"));
        vendaTop.appendChild(document.createTextNode("Preço"));

        tbTopo.appendChild(descriTop);
        tbTopo.appendChild(quantiTop);
        tbTopo.appendChild(vendaTop);

        tabela.appendChild(tbTopo);

        descriTop.style = "border: 1px solid black";
        quantiTop.style = "border: 1px solid black";
        vendaTop.style = "border: 1px solid black";

        let nome = document.getElementById('nome').value;
        console.log(nome);
        for (let i = 0; i < response.data.length; i++) {
            if (response.data[i].descricao.includes(nome) || nome == '') {
                let tblinha = document.createElement("tr");
                let tbDescri = document.createElement("td");
                let tbQuanti = document.createElement("td");
                let tbVenFis = document.createElement("td");
                let tbBotao2 = document.createElement("td");
                let tbBotEdi = document.createElement("td");

                let botao2 = document.createElement("input");
                let botEdi = document.createElement("input");

                botao2.type = "button";
                botao2.value = "Deletar";
                botao2.onclick = function () {
                    axios.delete('http://localhost:8080/api/produto/' + response.data[i].id,
                        {
                            headers: {
                                'usuario': usuario,
                                'senha': senha
                            }
                        })
                };

                botEdi.type = "button";
                botEdi.value = "Editar";
                botEdi.onclick = function(){
                    window.location = "editarProduto.html?usuario="+usuario+"&senha="+senha;
                };

                let descri = document.createTextNode(response.data[i].descricao);
                let quanti = document.createTextNode(response.data[i].quantidadeEstoque.toString());
                let venFis = "erro";

                venFis = document.createTextNode(response.data[i].precoVenda.toString());

                tbBotEdi.appendChild(botEdi);
                tbBotao2.appendChild(botao2);
                tbDescri.appendChild(descri);
                tbQuanti.appendChild(quanti);
                tbVenFis.appendChild(venFis);
                tblinha.appendChild(tbDescri);
                tblinha.appendChild(tbQuanti);
                tblinha.appendChild(tbVenFis);
                tblinha.appendChild(tbBotao2);
                tblinha.appendChild(tbBotEdi);
                tabela.appendChild(tblinha);

                tbDescri.style = "border: 1px solid black";
                tbQuanti.style = "border: 1px solid black";
                tbVenFis.style = "border: 1px solid black";
                tabela.style = "border: 1px solid black";
                div.appendChild(tabela);
            }

        }
        let corpo = document.getElementById('corpo');

        document.body.removeChild(corpo);
        document.body.appendChild(div);
    }).catch(function (response) {
        console.log("erro fora")
        console.log(response.data);
    });
}