
$(document).ready(function(){
    var resultat = true;

    $('#Formulaire').submit(function() { 

        if($('#courriel').val() == "")
        {
            $('#courriel').css('border-color', 'red');
            $('#courriel').css({"background-color": "red"});
            $('#courriel').css({"color": "yellow"});
            $('#courriel').focus();
            resultat = false;
        }

        if($('#mdp2').val() == "")
        {
            $('#mdp2').css('border-color', 'red');
            $('#mdp2').css({"background-color": "red"});
            $('#mdp2').css({"color": "yellow"});
            $('#mdp2').focus();
            resultat = false;
        }

        if($('#mdpForm').val() == "")
        {
            $('#mdpForm').css('border-color', 'red');
            $('#mdpForm').css({"background-color": "red"});
            $('#mdpForm').css({"color": "yellow"});
            $('#mdpForm').focus();
            resultat = false;
        }

        if($('#nomForm').val() == "")
        {
            $('#nomForm').css('border-color', 'red');
            $('#nomForm').css({"background-color": "red"});
            $('#nomForm').css({"color": "yellow"});
            $('#nomForm').focus();
            resultat = false;
        }  
        //alert(resultat);
        return resultat;
    });

    $('#nomForm').keyup(function(){
        if($('#nomForm').val().length<3)
        {
            $('#nomForm').css('border-color', 'red');
            $('.imgNom').fadeOut();
            return false;
        }
        else
        {
            $('#nomForm').css('border-color', 'yellow'); 
            $('#nomForm').css({"background-color": "#52D017"});
            $('#nomForm').css({"color": "black"});
            $('#nomForm').after($('.imgNom').delay(300).fadeIn());
        }
        
        return resultat; 
    });

    $('#mdpForm').keyup(function(){
        if($('#mdpForm').val().length<6)
        {
            $('#mdpForm').css('border-color', 'red');
            $('.imgMdp').fadeOut();
            return false;
        }
        else
        {
            $('#mdpForm').css('border-color', 'yellow'); 
            $('#mdpForm').css({"background-color": "#52D017"});
            $('#mdpForm').css({"color": "black"});
            $('#mdpForm').after($('.imgMdp').delay(300).fadeIn());
        }
        
        return resultat; 
    });

    $('#mdp2').keyup(function(){
        if($('#mdp2').val().length<6)
        {
            $('#mdp2').css('border-color', 'red');
            $('.imgMdp2').fadeOut();
            return false;
        }
        else if ($('#mdp2').val() == ($('#mdpForm').val())) //S'assurez que les deux mots de passes sont identiques.
        {
            $('#mdp2').css('border-color', 'yellow'); 
            $('#mdp2').css({"background-color": "#52D017"});
            $('#mdp2').css({"color": "black"});
            $('#mdp2').after($('.imgMdp2').delay(300).fadeIn());
        }
        else
        {
            $('#mdp2').css('border-color', 'red');
            $('.imgMdp2').fadeOut();
            return false;
        }

        return resultat; 
    });

    $('#courriel').keyup(function() {
        var validCourriel = $('#courriel').val();
        
        if( isValidEmailAddress( validCourriel ) ) 
        {  
            $('#courriel').css('border-color', 'yellow'); 
            $('#courriel').css({"background-color": "#52D017"});
            $('#courriel').css({"color": "black"});
            $('#courriel').after($('.imgCourriel').delay(300).fadeIn());
        }
        else
        {
            $('#courriel').css('border-color', 'red');
            $('.imgCourriel').fadeOut();
            return false;
        }
        
        return resultat; 
    });
});


//Validation de formulaire
function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
    return pattern.test(emailAddress);
}

