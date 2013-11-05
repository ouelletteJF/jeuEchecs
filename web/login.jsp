  
<%
    /* 
     * 
     * MODULE DE CONNEXION
     * 
     * Modifier le texte du lien LogIn fait en sorte qu'il cesse de fonctionner...
     * 
     */  
%>
<div class="mdpErreur">
<%
    if (request.getAttribute("message") != null)
    {
        out.println("<span id=\"errorMessage\">" + request.getAttribute("message") + "</span>");
    }
    
    String  userN = request.getParameter("nom");

    if (userN == null) 
        userN = "";
    else 
        userN = userN.trim();
%>
</div>

<a href="#" id="seConnecter">Connexion</a>

<form id="loginForm" action="login.exe" method="post">
    <input type="hidden" name="action" value="login" />
    
    <table>
        <td>
            Utilisateur :<br/>
            <input type="text" name="nom" value="<%=userN%>" id="userLogIn" />
        </td>
        
        <td>
            Mot de passe :<br/> 
            <input type="password" name="mdp" id="pswdLogIn" />
        </td>
        
        <td>
            <input type="submit" value="Se connecter" id="btnLogin"/>
        </td>
    </table>
</form>    

