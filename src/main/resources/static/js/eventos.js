// ==============================
// EDIÇÃO DE EVENTO
// ==============================

function editarEvento(id) {

    // Procura o evento pelo ID através da API
    fetch("/api/eventos/" + id)
        .then(response => {

            if (!response.ok) {
                throw new Error("Erro ao buscar evento.");
            }

            return response.json();
        })
        .then(evento => {

            // Preenche o formulário com os dados do evento
            document.getElementById("id").value = evento.id;
            document.getElementById("nome").value = evento.nome;
            document.getElementById("local").value = evento.local;
            document.getElementById("data").value = evento.data;
            document.getElementById("capacidadeMaxima").value = evento.capacidadeMaxima;

            // Altera o título do formulário
            document.getElementById("tituloFormulario").textContent = "Editar Evento";

            // Mostra o botão cancelar
            document.getElementById("btnCancelar").style.display = "inline-block";

            // Leva o usuário até o formulário
            document.querySelector(".formulario").scrollIntoView({
                behavior: "smooth"
            });
        })
        .catch(error => {
            console.error(error);
            alert("Não foi possível carregar o evento.");
        });
}


// ==============================
// CANCELAR EDIÇÃO
// ==============================

function cancelarEdicao() {

    // Limpa todos os campos do formulário
    document.getElementById("eventoForm").reset();

    // Limpa o ID escondido
    document.getElementById("id").value = "";

    // Volta o título para cadastro
    document.getElementById("tituloFormulario").textContent = "Cadastrar Evento";

    // Esconde o botão cancelar
    document.getElementById("btnCancelar").style.display = "none";
}


// ==============================
// FILTRO DE EVENTOS
// ==============================

function filtrarEventos() {

    // Pega o texto digitado no campo de busca
    const filtro = document
        .getElementById("filtro")
        .value
        .toLowerCase();

    // Pega todas as linhas da tabela
    const linhas = document.querySelectorAll("#listaEventos tr");

    linhas.forEach(linha => {

        // Pega o nome do evento
        const nomeEvento = linha
            .querySelector("td")
            ?.textContent
            .toLowerCase();

        // Mostra ou esconde a linha
        if (nomeEvento && nomeEvento.includes(filtro)) {
            linha.style.display = "";
        } else {
            linha.style.display = "none";
        }
    });
}


// ==============================
// CONFIRMAÇÃO DE EXCLUSÃO
// ==============================

function confirmarExclusao() {

    // Pergunta ao usuário antes de excluir
    return confirm("Tem certeza que deseja excluir este evento?");
}


// ==============================
// CONFIGURAÇÃO INICIAL
// ==============================

document.addEventListener("DOMContentLoaded", function () {

    // O botão cancelar começa escondido
    document.getElementById("btnCancelar").style.display = "none";
});