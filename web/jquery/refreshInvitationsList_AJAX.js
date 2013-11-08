
/*
 * 
 * CONTENU : 
 * 
 */

var xho;

function invit()
{   
    url = "http://localhost:8080/Chess/Invit";//"getInvit.exe?action=invit";

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
        catch (e) 
        {
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
            document.getElementById("invitations").innerHTML = "Invitations : <br />"+xho.responseText;
        }
        else
        {
            alert("Problème : " + xho.statusText);
        }

}


        
