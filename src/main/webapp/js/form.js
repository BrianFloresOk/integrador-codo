window.addEventListener('load', () => {
    // Captura todos los formularios en la página
    let forms = document.querySelectorAll("form");

    forms.forEach((form) => {
        form.addEventListener("submit", (event) => {
            event.preventDefault();

            // Obtiene los campos dentro del formulario actual
            let inputs = form.querySelectorAll("input, textarea, select");

            // Verifica si alguno de los campos está vacío
            let isEmpty = Array.from(inputs).some((input) => {
                return input.value.trim() === "";
            });

            if (isEmpty) {
                alert("Hay campos vacíos, complete para continuar.");
            } else {
				form.submit()                
                // Opcional: Restablece los valores de los campos del formulario
                inputs.forEach((input) => {
                    input.value = "";
                });
            }
        });
    });
});
