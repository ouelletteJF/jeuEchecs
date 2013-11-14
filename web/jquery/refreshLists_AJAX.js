
/*
 * 
 *  CONTENU : Fonction qui rafraichit la liste des invitations, des joueurs et des parties à l'aide d'AJAX
 * 
 */


var xho;

function Refresh()
{       
    url = "http://localhost:8080/Chess/Refresh";

    if (window.ActiveXObject) //si Internet Explorer
    { 
        xho = new ActiveXObject("Microsoft.XMLHTTP");
        
        if (xho)
        {
            xho.onreadystatechange = processStateChange;
            xho.open("POST",url,true);
            xho.send();
        }
    }
    else //si autre navigateur
    {  
        xho = new XMLHttpRequest();
        xho.onreadystatechange = processStateChange;
        
        try
        {
            xho.open("POST",url,true);
        }
        catch (e) {
            alert(e);
        }
        
        xho.send(null);
    }
}


function processStateChange()
{
    if (xho.readyState == 4) //complété
        if (xho.status == 200)  //réponse OK
        {
            rep = xho.responseText;
              
            reponse = eval("("+rep+")");
            document.getElementById("listeInvitations").innerHTML = reponse.invitations;
            document.getElementById("listeJoueurs").innerHTML = reponse.utilisateursConnectes;
            document.getElementById("listeParties").innerHTML = reponse.parties;
            
            if(reponse.startGame === "yes")
                window.location = "index.jsp?action=startGame";
        }
        else
        {
            alert("Problème : " + xho.statusText);
        }
}


        

