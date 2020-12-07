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

        let tabela = document.createElement("table");

        let tbTopo = document.createElement("tr");
        let nomeTop = document.createElement("td");
        let apelTop = document.createElement("td");
        let tipoTop = document.createElement("td");
        let situTop = document.createElement("td");

        nomeTop.appendChild(document.createTextNode("Nome"));
        apelTop.appendChild(document.createTextNode("Apelido"));
        tipoTop.appendChild(document.createTextNode("Tipo"));
        situTop.appendChild(document.createTextNode("Situação"));

        tbTopo.appendChild(nomeTop);
        tbTopo.appendChild(apelTop);
        tbTopo.appendChild(tipoTop);
        tbTopo.appendChild(situTop);

        nomeTop.style = "border: 1px solid black";
        apelTop.style = "border: 1px solid black";
        tipoTop.style = "border: 1px solid black";
        situTop.style = "border: 1px solid black";

        tabela.appendChild(tbTopo);

        for (let i = 0; i < response.data.length; i++){
            let nom = false;
            let apelid = false;
            if (response.data[i].nome.toString().includes(nome1.toString()) || nome1 == ""){
                nom = true;}
            if (response.data[i].apelido.toString().includes(apelido1.toString()) || apelido1 == ""){
                apelid = true;}

            if (nom && apelid){
                let tblinha = document.createElement("tr");
                let tbNome = document.createElement("td");
                let tbApelido = document.createElement("td");
                let tbTipo = document.createElement("td");
                let tbSitu = document.createElement("td");
                let tbBotao2 = document.createElement("td");
                let tbBotEdi = document.createElement("tb");

                let botao2 = document.createElement("input");
                let botEdi = document.createElement("input");

                botEdi.type = "button";
                botEdi.value = "Editar";
                botEdi.onclick = function(){
                    window.location = "editarPessoa.html?usuario="+usuario+"&senha="+senha;
                };

                botao2.type = "button";
                botao2.value = "Deletar";
                botao2.onclick = function () {
                    axios.delete('http://localhost:8080/api/pessoa/'+response.data[i].id,
                        {headers: {'usuario': usuario, 'senha': senha}})};

                let nome = document.createTextNode(response.data[i].nome);
                let descri = document.createTextNode(response.data[i].apelido);
                let tipo = document.createTextNode(response.data[i].tipo.toString());
                let situ = document.createTextNode(response.data[i].situacao.toString());

                tbBotEdi.appendChild(botEdi);
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
                tblinha.appendChild(tbBotEdi);
                tabela.appendChild(tblinha);

                tbNome.style = "border: 1px solid black";
                tbApelido.style = "border: 1px solid black";
                tbSitu.style = "border: 1px solid black";
                tbTipo.style = "border: 1px solid black";
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