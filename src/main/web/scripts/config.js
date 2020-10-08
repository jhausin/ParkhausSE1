/*
 * Author: Jannik Hausin
 */

$('document').ready(() => {
    $('#form').submit((event) => {
        event.preventDefault();
        const data = $('#form').serializeArray();
        $.ajax({
            url: "http://localhost:8080/ConfigServlet",
            type: 'POST',
            data: data,
            error: (xhr, error, status) => {
                $('.alert').text("Konfiguration ungültig. Bitte Eingabe überprüfen.")
                    .removeClass("alert-success")
                    .addClass("alert-danger")
                    .show();
            },
            success: (xhr, error, status) => {
                $('.alert')
                    .text("Konfiguration erfolgreich gespeichert.")
                    .removeClass("alert-danger")
                    .addClass("alert-success")
                    .show();
            }
        })
    });
    $('form').on('keyup change paste', 'input', () => {
        $('.alert').hide();
    })
})