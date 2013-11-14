/*
 * Bibliothèque de fonctions JavaScript nécessaires au 
 * bon fonctionnement d'une partie d'échecs.
 * 
 * 
 */


// Fonction qui remet toutes les pièces à leur position initiale
function reinitEchiquier()
{
    var i, j;

    // Reinitialisation des images
    for (i = 0; i < 8; i++ )
        for (j = 0; j < 8; j++ ) 
            document.getElementById('echiquier').rows[i].cells[j].innerHTML = ""; 
    
    // Tours (1,1 | 1,8 | 8,1 | 8,8)
    document.getElementById('echiquier').rows[0].cells[0].innerHTML = "<img src='./images/nTour.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[0].cells[7].innerHTML = "<img src='./images/nTour.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[7].cells[0].innerHTML = "<img src='./images/bTour.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[7].cells[7].innerHTML = "<img src='./images/bTour.gif' class='piece' />"; 
    
    // Cavaliers (1,2 | 1,7 | 8,2 | 8,7)
    document.getElementById('echiquier').rows[0].cells[1].innerHTML = "<img src='./images/nCavalier.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[0].cells[6].innerHTML = "<img src='./images/nCavalier.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[7].cells[1].innerHTML = "<img src='./images/bCavalier.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[7].cells[6].innerHTML = "<img src='./images/bCavalier.gif' class='piece' />";
    
    // Fous (1,3 | 1,6 | 8,3 | 8,6)
    document.getElementById('echiquier').rows[0].cells[2].innerHTML = "<img src='./images/nFou.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[0].cells[5].innerHTML = "<img src='./images/nFou.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[7].cells[2].innerHTML = "<img src='./images/bFou.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[7].cells[5].innerHTML = "<img src='./images/bFou.gif' class='piece' />";
    
    // Reines (1,4 | 8,4)
    document.getElementById('echiquier').rows[0].cells[3].innerHTML = "<img src='./images/reineNoire.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[7].cells[3].innerHTML = "<img src='./images/bReine.gif' class='piece' />";
    
    // Rois (1,5 | 8,5)
    document.getElementById('echiquier').rows[0].cells[4].innerHTML = "<img src='./images/nRoi.gif' class='piece' />"; 
    document.getElementById('echiquier').rows[7].cells[4].innerHTML = "<img src='./images/bRoi.gif' class='piece' />";
    
    // Pions noirs
    for (i = 0; i < 8; i++ )
        document.getElementById('echiquier').rows[1].cells[i].innerHTML = "<img src='./images/nPion.gif' class='piece' />";
        //document.getElementById('echiquier').rows[1].cells[i].innerHTML = "<img src='./images/bPion.gif' class='piece' />";
    
    // Pions blancs
    for (i = 0; i < 8; i++ )
        document.getElementById('echiquier').rows[6].cells[i].innerHTML = "<img src='./images/bPion.gif' class='piece' />";
}


// Fonction qui déplace une pièce sur l'échiquier
function deplacer(prevL, prevC, newL, newC)
{
    document.getElementById('echiquier').rows[newL].cells[newC].innerHTML = document.getElementById('echiquier').rows[prevL].cells[prevC].innerHTML;
    document.getElementById('echiquier').rows[prevL].cells[prevC].innerHTML = ""; 
}


// FONCTION TEST --> la logique peut simplement être utilisée dans la fonction appropriée, pas nécessairement dans cette fonction
// Fonction qui récupère la case cliquée 
function getCell(cell)
{
    var row = parseInt(cell.id.substring(1,2));
    var col = parseInt(cell.id.substring(3,4));
    
    alert("Ligne " + row + ", colonne " + col);
}
