function alerta(bold, texto, tipo) {
    $('#msj').empty();
    $('#msj').html('<div class="alert alert-' + tipo + '"><button type = "button" class = "close" data-dismiss = "alert" > x </button><strong > ' + bold + '! </strong> ' + texto + '</div>');
}
function dataTable(id) {
    $("#" + id).dataTable({
        bJQueryUI: !1,
        bAutoWidth: !1,
        oLanguage: {
            "sLengthMenu": "Ver _MENU_ registros",
            "sZeroRecords": "No se produjo ningún resultado",
            "sEmptyTable": "No existen registros para mostrar",
            "sInfo": "Resultado _START_ - _END_ de _TOTAL_ registros",
            "sInfoEmpty": "Registros 0 - 0 de 0 Entradas",
            "sInfoFiltered": "(Filtrado de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "oPaginate": {
                "sFirst": "Primero",
                "sPrevious": "Anterior",
                "sNext": "Siguiente",
                "sLast": "Ultimo"
            },
            "fnInfoCallback": null
        },
        sPaginationType: "full_numbers",
        sDom: '<"table-header"fl>t<"table-footer"ip>'
    });
}
function notificacion(titulo, texto, tipo) {

    switch (tipo)
    {
        case 'info':
            Growl.info(
                    {title: titulo, text: texto}
            )
            break;
        case 'success':
            Growl.success(
                    {title: titulo, text: texto}
            )
            break;
        case 'warning':
            Growl.warning(
                    {title: titulo, text: texto}
            )
            break;
        case 'error':
            Growl.error(
                    {title: titulo, text: texto}
            )
            break;
    }



}
function trim(myString)
{
    return myString.replace(/^\s+/g, '').replace(/\s+$/g, '')
}
function fechaBD(fecha)
{
    var dia = fecha.substring(0,2);
    var mes = fecha.substring(3, 5);
    var year = fecha.substring(6, 10);

    return year + '-' + mes + '-' + dia;
}