/*
 *  
 *  CONTENU: Fonction qui valide le formulaire de modification du profil à
 *           l'aide de jQuery
 * 
 */

$(document).ready(function(){
    var resultat = true;

    $('#Formulaire').submit(function(){ 

        if($('#courrielProfil').val()=="")
        {
            $('#courrielProfil').css('border-color', 'red');
            $('#courrielProfil').css({"background-color": "red"});
            $('#courrielProfil').css({"color": "yellow"});
            $('#courrielProfil').focus();
            resultat = false;
        }


        if($('#mdpProfil').val()=="")
        {
            $('#mdpProfil').css('border-color', 'red');
            $('#mdpProfil').css({"background-color": "red"});
            $('#mdpProfil').css({"color": "yellow"});
            $('#mdpProfil').focus();
            resultat = false;
        }

        if($('#nomProfil').val()=="")
        {
            $('#nomProfil').css('border-color', 'red');
            $('#nomProfil').css({"background-color": "red"});
            $('#nomProfil').css({"color": "yellow"});
            $('#nomProfil').focus();
            resultat = false;
        }        
        return resultat;
    });


    $('#nomProfil').keyup(function(){
        if($('#nomProfil').val().length<3)
        {
                $('#nomProfil').css('border-color', 'red');
                $('.imgNom').fadeOut();
                return false;
        }
        else
        {
                $('#nomProfil').css('border-color', 'yellow'); 
                $('#nomProfil').css({"background-color": "#52D017"});
                $('#nomProfil').css({"color": "black"});
                $('#nomProfil').after($('.imgNom').delay(300).fadeIn());
        }
        return resultat; 
    });


    $('#mdpProfil').keyup(function(){

        if($('#mdpProfil').val().length<6)
        {
                $('#mdpProfil').css('border-color', 'red');
                $('.imgMdp').fadeOut();
                return false;
        }
        else
        {
                $('#mdpProfil').css('border-color', 'yellow'); 
                $('#mdpProfil').css({"background-color": "#52D017"});
                $('#mdpProfil').css({"color": "black"});
                $('#mdpProfil').after($('.imgMdp').delay(300).fadeIn());
        }

        return resultat; 
    });



    $('#courrielProfil').keyup(function(){

        var validCourriel = $('#courrielProfil').val();

        if( isValidEmailAddress( validCourriel ) ) 
        {  
           $('#courrielProfil').css('border-color', 'yellow'); 
           $('#courrielProfil').css({"background-color": "#52D017"});
           $('#courrielProfil').css({"color": "black"});
           $('#courrielProfil').after($('.imgCourriel').delay(300).fadeIn());
        }
        else
        {
           $('#courrielProfil').css('border-color', 'red');
           $('.imgCourriel').fadeOut();
           return false;
        }

        return resultat; 
    });



    $('#btModifier').click(function(){

        if ($('#mdpProfil').prop("disabled"))
        {
            $('#courrielProfil').prop("disabled", false);
            $('#mdpProfil').prop("disabled", false);
            $('#btModifier').val("Annuler");
            $('#btUpdate').prop("disabled", false);
        }
        else 
        {
            $('#courrielProfil').prop("disabled", true);
            $('#mdpProfil').prop("disabled", true);
            $('#btModifier').val("Modifier");
            $('#btUpdate').prop("disabled", true);
        }
    });

});


//Validation de formulaire
function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
    return pattern.test(emailAddress);
}

