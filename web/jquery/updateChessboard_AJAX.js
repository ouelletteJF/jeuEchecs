
/*
 *	Fichier:	updateChessboard_AJAX.java
 *	Contenu:	Fichier JS (AJAX) qui permet le rafraichissement des échiquiers des joueurs d'une partie.
 *
 *	Auteur:		Jean-François Ouellette
 *	Version:	1.0
 *
 *	Date de création:	12 novembre 2013
 *	Dernière modification:	-
 *	Raison mise à jour:	-
 *
 *	À faire:    
 *
*/

function updateChessboard()
{ 
    var jqxhr = $.ajax( "http://localhost:8080/Chess/updateGame" )
        .done(function( data ) {
            var reponse = eval("(" + data + ")");
            
            // Pour chaque case contenant une piece...
            for(var i = 0; i < reponse.length; i++ ) 
                $( reponse[i].id ).html( "<img src='" + reponse[i].image + "' class='piece' />"  ) ;
        })
        .fail(function() {
            alert( "Une erreur s'est produite lors du rafraichissement de la page." );
        })
}