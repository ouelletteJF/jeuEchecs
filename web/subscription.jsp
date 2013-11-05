<%-- 
    Document   : inscription
    Created on : 2013-01-10, 22:10:43
    Author     : s4d3k
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    
    <form id="Formulaire" action="Inscription.exe" method="post">
		
        <table>        
            <h1 align="center" >Fiche d'inscription </h1>

            <tr>
                <td>Utilisateur :</td>

                <td>
                    <input type="text" name="nomForm" id="nomForm" />
                    <span class="erreur"></span>
                    <img class="imgNom "src="./images/crochetValid.png" />
                </td>
            </tr>

            <tr>
                <td>Mot de passe :</td>

                <td>
                    <input type="password" name="mdpForm" id="mdpForm" />
                    <span class="erreur"></span>
                    <img class="imgMdp"src="./images/crochetValid.png" />
                </td>
            </tr>

            <tr>
                <td>Répéter mot de passe :</td>

                <td>
                    <input type="password" name="mdp2" id="mdp2"/>
                    <span class="erreur"></span>
                    <img class="imgMdp2 "src="./images/crochetValid.png" />
                </td>
            </tr>

            <tr>
                <td>Courriel :</td>

                <td>
                    <input type="text" name="courriel" id="courriel"/>
                    <span class="erreur"></span>
                    <img class="imgCourriel "src="./images/crochetValid.png" />
                </td>
            </tr>	

            <tr>	
                <td>
                    <p id="terme" >
                        En continuant, j’accepte <a href="#" id="termeForm" >les Conditions Générales</a> de Chess STI, 
                        Données personnelles et les Conditions d’utilisation des communications. 
                    </p>
                </td> 

                <td>
                    <input type="submit" value="Créer mon compte" />
                </td>

                <input type="hidden" name="action" value="Inscription" />
            </tr>
        </table>
    </form>