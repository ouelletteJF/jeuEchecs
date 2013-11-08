
/*
 * 
 * CONTENU : 
 * 
 */

var blok = false;
var chosenImage = "./images/vide.png";
var firstClick = true;


function bloqueClick()
{
    blok = true;
}

function debloqueClick()
{
    blok = false;
}

function isFull(x,y)
{
    source = document.getElementById(""+x+","+y+"").src;
    
    if ("./images/vide.png" == source)
    {
        return false;
    }
    else {
        return true;
    }
    
    return false;
}

function move(x,y)
{   if (isFull(x,y))
    {}
    else {
        document.getElementById(""+x+","+y+"").src = chosenImage;
        document.getElementById(idSwitchImage).src = "./images/vide.png";
    }
}

function clic(x,y)
{   
    if (firstClick) 
    {
        chosenImage = document.getElementById(""+x+","+y+"").src;
        idSwitchImage = ""+x+","+y+"";
        firstClick= false;
    }
    else 
    {
        move(x,y);
        firstClick= true;
    }


}
  