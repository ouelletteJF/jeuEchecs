var xho;

function Refresh()
{       
    url = "http://localhost:8080/Chess/Refresh";//"getInvit.exe?action=invit";

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
            document.getElementById("invitations").innerHTML = "Invitation(s) : "+reponse.invitation;
            document.getElementById("connectes").innerHTML = "joueur(s) connect&eacute(s): "+reponse.ConnectUsers;
            document.getElementById("PartieEnCours").innerHTML = "Partie en cours : "+reponse.parties;

        }
        else
        {
            alert("Problème : " + xho.statusText);
        }
}


        

