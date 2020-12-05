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
    axios.delete('http://localhost:8080/api/pessoa'+index, {
        headers: {
            'usuario': usuario,
            'senha': senha
        }
    });
}

function carregarPessoas(){
    var nome1 = document.getElementById('nome').value;
    var apelido1 = document.getElementById('apelido').value;
    console.log(usuario, senha);
    axios.get('http://localhost:8080/api/pessoa', {
        headers: {
            'usuario': usuario,
            'senha': senha
        }
    }).then(function (response) {
        var div = document.createElement("div");
        div.id = "corpo";
        for (let i = 0; i < response.data.length; i++){
            var nom = false;
            var apelid = false;
            if (response.data[i].nome.toString().includes(nome1.toString()) || nome1 == ""){
                nom = true;}
            if (response.data[i].apelido.toString().includes(apelido1.toString()) || apelido1 == ""){
                apelid = true;}

            if (nom && apelid){
                var tabela = document.createElement("table");
                var tblinha = document.createElement("tr");
                var tbNome = document.createElement("td");
                var tbApelido = document.createElement("td");
                var tbTipo = document.createElement("td");
                var tbSitu = document.createElement("td");
                var tbBotao = document.createElement("td");

                var btn = document.createElement("button");

                var nome = document.createTextNode(response.data[i].nome);
                var descri = document.createTextNode(response.data[i].apelido);
                var tipo = document.createTextNode(response.data[i].tipo.toString());
                var situ = document.createTextNode(response.data[i].situacao.toString());
                var botaoNome = document.createTextNode("Deletar");

                btn.appendChild(botaoNome);

                btn.id = "btn"+i;
                //btn.onclick = deletarPessoa(i);

                tbBotao.appendChild(tbBotao);
                tbNome.appendChild(nome);
                tbApelido.appendChild(descri);
                tbTipo.appendChild(tipo);
                tbSitu.appendChild(situ);
                tblinha.appendChild(tbNome);
                tblinha.appendChild(tbApelido);
                tblinha.appendChild(tbTipo);
                tblinha.appendChild(tbSitu);
                tblinha.appendChild(tbBotao);
                tabela.appendChild(tblinha);

                tbNome.style = "border: 1px solid blue";
                tbApelido.style = "border: 1px solid blue";
                tbSitu.style = "border: 1px solid blue";
                tbTipo.style = "border: 1px solid blue";
                tabela.style = "border: 1px solid black";
                div.appendChild(tabela);
            }

            var corpo = document.getElementById('corpo');

            document.body.removeChild(corpo);
            document.body.appendChild(div);
        }
    }).catch(function (response) {
        console.log(response.data)
        console.log("Usuário não existe no banco de dados");
    });
}