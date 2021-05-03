function saluda() {
    alert("HOLA")
}

//eventos de temporización ej js 
function iniciaTemporizador() {
    referencia = setTimeout(saluda, 2000);
}

function cancelaTemporizador() {
    clearTimeout(referencia);
}