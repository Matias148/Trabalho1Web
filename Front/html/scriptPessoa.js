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

function cadastroPessoa() {
    window.location = "CadastroPessoa.html?usuario="+usuario+"&senha="+senha;
}

function deletarPessoa(index) {
    axios.delete('http://localhost:8080/api/pessoa/'+index, {
        headers: {
            'usuario': usuario,
            'senha': senha
        }
    });
}

function carregarPessoas(){
    let nome1 = document.getElementById('nome').value;
    let apelido1 = document.getElementById('apelido').value;
    console.log(usuario, senha);
    axios.get('http://localhost:8080/api/pessoa', {
        headers: {
            'usuario': usuario,
            'senha': senha
        }
    }).then(function (response) {
        let div = document.createElement("div");
        div.id = "corpo";
        for (let i = 0; i < response.data.length; i++){
            let nom = false;
            let apelid = false;
            if (response.data[i].nome.toString().includes(nome1.toString()) || nome1 == ""){
                nom = true;}
            if (response.data[i].apelido.toString().includes(apelido1.toString()) || apelido1 == ""){
                apelid = true;}

            if (nom && apelid){
                let tabela = document.createElement("table");
                let tblinha = document.createElement("tr");
                let tbNome = document.createElement("td");
                let tbApelido = document.createElement("td");
                let tbTipo = document.createElement("td");
                let tbSitu = document.createElement("td");
                let tbBotao2 = document.createElement("td");

                let botao2 = document.createElement("input");

                botao2.type = "button";
                botao2.value = "Deletar?";
                botao2.onclick = function () {
                    axios.delete('http://localhost:8080/api/pessoa/'+response.data[i].id,
                        {headers:
                                {
                                    'usuario': usuario,
                                    'senha': senha
                                }
                        }
                )};

                let nome = document.createTextNode(response.data[i].nome);
                let descri = document.createTextNode(response.data[i].apelido);
                let tipo = document.createTextNode(response.data[i].tipo.toString());
                let situ = document.createTextNode(response.data[i].situacao.toString());

                tbBotao2.appendChild(botao2);
                tbNome.appendChild(nome);
                tbApelido.appendChild(descri);
                tbTipo.appendChild(tipo);
                tbSitu.appendChild(situ);
                tblinha.appendChild(tbNome);
                tblinha.appendChild(tbApelido);
                tblinha.appendChild(tbTipo);
                tblinha.appendChild(tbSitu);
                tblinha.appendChild(tbBotao2);
                tabela.appendChild(tblinha);

                tbNome.style = "border: 1px solid blue";
                tbApelido.style = "border: 1px solid blue";
                tbSitu.style = "border: 1px solid blue";
                tbTipo.style = "border: 1px solid blue";
                tabela.style = "border: 1px solid black";
                div.appendChild(tabela);
            }
        }
        let corpo = document.getElementById('corpo');

        document.body.removeChild(corpo);
        document.body.appendChild(div);
    }).catch(function (response) {
        console.log(response.data);
        console.log("Usuário não existe no banco de dados");
    });
}