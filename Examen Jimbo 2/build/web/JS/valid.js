try {
    var moment = require('moment');
} catch (error) {
    var date = 1;
}

//Funciones JQuery

$(document).ready(function () {
    var hoy = moment();
    hoy = moment(hoy).format("YYYY-MM-DD");
    var next = moment(hoy).add(1,"y");
    next = moment(next).format("YYYY-MM-DD");
    $("body").attr({
        "ondrag": "return false",
        "ondrop": "return false",
        "onpaste": "return false"
    });
    $(".val-num").attr("maxlength", "7");
    $(".val-texto").attr("onkeydown", "return validarLT(event)");
    $(".val-num").attr("onkeydown", "return validarNT(event)");
    $(".val-fecha").attr({
        "min": hoy,
        "max": next
    })
});
$(".val-subida").click(function () {
    if($('.texto')[0]){
        var str = $(".texto").val();
        validarL(str);
    }
});

$(".val-num").keyup(function () {
    var str = $(this).val();
    if (validarN(str)) {
        $(this).val(str);
    } else {
        str = str.substring(0, str.length - 1);
        $(this).val(str);
    }
});
function validarFecha(){
    var date = $(".val-fecha").val();
    date = moment(date);
    if(moment().isValid(date)){
        return true;
    }
    else{
        return false;
    }
}
//funciones JS
function validarLT(e) {
    if (e.which == 48 || e.which == 49 || e.which == 50 || e.which == 52
        || e.which == 53 || e.which == 54 || e.which == 55 || e.which == 56
        || e.which == 57 || e.which == 190 || e.which == 51) {
        return false;
    }
    else {

    }
}
function validarNT(e) {
    if (e.which == 48 || e.which == 49 || e.which == 50 || e.which == 52
        || e.which == 53 || e.which == 54 || e.which == 55 || e.which == 56
        || e.which == 57 || e.which == 190 || e.which == 51 || e.which == 8) {

    }
    else {
        return false;
    }
}

function validarN(value) {
    var str = value;
    if (isNaN(str)) {
        return false;
    } else {
        return true;
    }
}

function validarL(val) {
    // body...
    if (val.length <= 2) {
        alert("Escribe mas de dos caracteres.");
        return (false);
    }

    var checkOK = "qwertyuiopasdfghjklñzxcvbnmáéíóú QWERTYUIOPASDFGHJKLÑZXCVBNM";
    var checkStr = val;
    var allValido = true;
    for (var i = 0; i < checkStr.length; i++) {
        var ch = checkStr.charAt(i);
        for (var j = 0; j < checkOK.length; j++)
            if (ch == checkOK.charAt(j)) break;
        if (j == checkOK.length) {
            allValido = false;
            break;
        }

    }
    if (!allValido) {
        return (false);
    }
    else {
        return (true);
    }
}