<%
    /*
     * 
     * MODULE DU MENU
     * 
     */
%>


<div id='cssmenu'>

    <% 
        if (session.getAttribute("connecte") == null)  //d�j� connect�
        {
    %>
            <ul>
                <li>
                    <a href="accueil.exe?action=accueil"><span>Accueil</span></a>
                </li>

                <li>
                    <a href="subscribe.exe?action=subscription"><span>Inscription</span></a>
                </li>

                <li>
                    <a href="index.jsp?action=regles"><span>R�gles</span></a>
                </li>
            </ul>    
    <%
        } 
        else {
    %>   
            <ul>
                <li>
                    <a href='acceuil.exe?action=accueil'><span>Accueil</span></a>
                </li>

                <% 
                    if ("yes".equals((String)session.getAttribute("play")))
                    {
                %>
                        <li>
                            <a href='play.exe?action=play&&activity=observer'><span>Mode �Observateur�</span></a>
                        </li>
                <%   
                    }
                    else {
                %>
                        <li>
                            <a href='play.exe?action=play&&activity=ready'><span>Mode �Joueur�</span></a>
                        </li>
                <%   
                    }
                %>
                    <li>
                        <a href='profile.exe?action=showProfile'><span>Mon profil</span></a>
                    </li>

                    <li>
                        <a href='regles.exe?action=regles'><span>R�gles</span></a>
                    </li>

                    <li>
                        <a href="logout.exe?action=logout"> <span>D�connexion - </span> <%=session.getAttribute("connecte")%> </a>
                    </li>
           </ul>

    <%
        } 
    %> 
</div>