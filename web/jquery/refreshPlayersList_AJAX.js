
/*
 * 
 * CONTENU : 
 * 
 */

var xho;

function listConnectes()
{   
    url = "http://localhost:8080/Chess/ConnectUser";//"getInvit.exe?action=invit";

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
        catch (e){
            alert(e);
        }
        
        xho.send(null);
    }
}

function processStateChange()
{
    if (xho.readyState == 4) //complété
        if (xho.status == 200)  //réponse OK
            document.getElementById("listeJoueurs").innerHTML = xho.responseText;
        else
            alert("Problème : " + xho.statusText);
}


        
