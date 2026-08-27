// ==========================================
// FILTRAR PARTICIPANTES
// ==========================================

// Essa função é chamada quando digitamos no campo de busca.
function filtrarParticipantes() {

    // Pega o texto digitado no campo de busca.
    const filtro = document
        .getElementById("filtro")
        .value
        .toLowerCase();

    // Pega todas as linhas da tabela.
    const linhas = document.querySelectorAll(
        "#listaParticipantes tr"
    );

    // Percorre cada participante da tabela.
    linhas.forEach(function(linha) {

        // Pega o texto da linha inteira.
        const texto = linha.textContent.toLowerCase();

        // Verifica se o texto digitado aparece na linha.
        if (texto.includes(filtro)) {

            // Mostra a linha.
            linha.style.display = "";

        } else {

            // Esconde a linha.
            linha.style.display = "none";
        }
    });
}


// ==========================================
// CONFIRMAR EXCLUSÃO
// ==========================================

// Essa função pergunta ao usuário antes de excluir.
function confirmarExclusao() {

    // Mostra uma mensagem de confirmação.
    return confirm(
        "Tem certeza que deseja excluir este participante?"
    );
}