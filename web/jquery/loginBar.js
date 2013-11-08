
/*
 * 
 * CONTENU : Fonction qui fait apparaître ou disparaitre le menu de connexion
 * 
 */

$(document).ready(function(){
    
    $('#seConnecter').click(function(){
        if ($('#seConnecter').html() ==  "Connexion")
        {           
            $('#loginForm').fadeIn("slow");
            $('#seConnecter').html("Annuler");
            $('.mdpErreur').fadeOut();
            $('#userLogIn').focus();
        }
        else if ($('#seConnecter').html() == "Annuler")
        {
            $('#loginForm').fadeOut("slow");
            $('#seConnecter').html("Connexion");
            $('.mdpErreur').fadeOut();
        }   
    }); 


    $('#loginForm').submit(function(){ 
        if(($('#userLogIn').val() == "") && ($('#pswdLogInLogIn').val()==""))
        {
            alert('Vous devez enter un nom d\'utilisateur');
            $('#userLogIn').focus();
            return false;
        }
        if(($('#pswdLogIn').val() == "") && ($('#userLogIn').val()!=""))
        {
            alert('Vous devez entrer un mot de passe');
            $('#pswdLogIn').focus();
            return false;
        }
        if (($('#pswdLogIn').val() == "") && ($('#userLogIn').val()==""))
        {
            alert('Veuillez remplir les champs');
            $('#userLogIn').focus();
            return false;
        }   
        return true;    
    });
});

