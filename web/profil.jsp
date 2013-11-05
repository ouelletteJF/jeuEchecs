<%-- 
    Document   : 
    Created on : 2013-01-05, 14:43:28
    Author     : s4d3k
--%>
    <%@page import="com.STI.entite.Utilisateur"%>
    <%
        if (request.getAttribute("leProfil") != null)
        {                       
            Utilisateur unUser = (Utilisateur)request.getAttribute("leProfil");
    %>
       
        <form id="Formulaire" action="changeProfil.exe" method="post">
            <h1 align="center" >Profil de <%out.println(unUser.getName().toString());%> </h1> 	
            
            <table> 
                <tr>
                    <td> Nom : </td>

                    <td>
                        <input type="text" name="nomProfil" id="nomProfil" value="<%out.println(unUser.getName().toString());%>" disabled/>
                        <span class="erreur"></span>
                        <img class="imgNom "src="./images/crochetValid.png" />
                    </td>
                </tr>

                <tr>
                    <td>Mot de passe :</td>

                    <td>
                        <input type="text" name="mdpProfil" id="mdpProfil" value="<%out.println(unUser.getMdp().toString());%>" disabled/>
                        <span class="erreur"></span>
                        <img class="imgMdp"src="./images/crochetValid.png" />
                    </td>
                </tr>

                <tr>
                    <td>Courriel :</td>

                    <td>
                        <input type="text" name="courrielProfil" id="courrielProfil" value="<%out.println(unUser.getCourriel().toString());%>" disabled/>
                        <span class="erreur"></span>
                        <img class="imgCourriel "src="./images/crochetValid.png" />
                    </td>
                </tr>

                <tr>	
                    <td>Parties jouées : </td>  

                    <td>
                        <a>0</a>
                    </td>
                </tr>

                <tr>	
                    <td>Victoires : </td>  

                    <td>
                        <a>0</a>
                    </td>
                </tr>

                <tr>	
                    <td>Défaites : </td> 

                    <td>
                        <a>0</a>
                    </td>
                </tr>

                <tr>	
                    <td>
                        <input type="button" value="  Modifier  " id="btModifier">
                    </td>

                    <td>
                        <input type="submit" value="Mettre à jour" id="btUpdate" disabled/>
                    </td>

                    <input type="hidden" name="action" value="changeProfil" />
                </tr>        
            </table>    
        </form> 
                        
    <%
        }               
    %> 
      
   

    
 

