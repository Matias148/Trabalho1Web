window.onload=teste();

function teste(){
    axios.get('http://localhost:8080/api/pedido')
        .then(function (response) {
            console.log(response.data);
        }).catch(function (response) {
            console.log(response.data)
    });
}