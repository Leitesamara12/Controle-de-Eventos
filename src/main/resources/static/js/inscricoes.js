// ==========================================
// INSCRIÇÕES
// ==========================================

// Mostra uma confirmação antes de realizar a inscrição.
document.addEventListener("DOMContentLoaded", function () {

    const formulario = document.querySelector("form");

    if (formulario) {

        formulario.addEventListener("submit", function (event) {

            const confirmar = confirm(
                "Deseja realmente realizar esta inscrição?"
            );

            if (!confirmar) {
                event.preventDefault();
            }
        });
    }
});