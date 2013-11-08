<%-- 
    Document   : index
    Created on : 7 jan. 2013, 18:10:04
    Author     : ilyes ait hamouda
--%>

<%@page import="com.STI.entite.*"%>
<%@page import="com.STI.dao.*"%>
<%@page import="com.STI.jdbc.*"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
    <head>
        <link href="./style/menu.css" rel="stylesheet" type="text/css">
        <link href="./style/style.css" rel="stylesheet" type="text/css">
        
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="./jquery/js.js"></script>	
        
        <script src="./jquery/date.js" language="JavaScript"></script>
        <script src="./jquery/loginBar.js" language="JavaScript"></script>
        <script src="./jquery/partieEchecs.js" language="JavaScript" ></script>
        <script src="./jquery/partieEchecs_ancien.js" language="JavaScript" ></script> 
        <!-- <script src="./jquery/refreshInvitationsList_AJAX.js" language="JavaScript"></script> -->
        <script src="./jquery/refreshLists_AJAX.js" language="JavaScript"></script>
        <!-- <script src="./jquery/refreshPlayersList_AJAX.js" language="JavaScript"></script> -->
        <script src="./jquery/subscription_FormValidation.js" language="JavaScript"></script>        
        <script src="./jquery/updateProfile_FormValidation.js" language="JavaScript" ></script>
        
        <script language="Javascript" type="text/javascript">
            function re()
            {
                Refresh();
            }
        </script>
        
        <title>It's all about chess!</title>
    </head>
  
    <body <% if ((session.getAttribute("connecte") != null)) { %> onLoad="setInterval('re()', 1000);" <% } %> > 
        <%
           String actionStr = request.getParameter("action");
        %>
        
        <div id="all">             
            <div id="header"> 
                <%
                    // Si aucune session n'est ouverte...
                    if (session.getAttribute("connecte") == null)  
                    {
                %>
                        <jsp:include page="login.jsp" />     
                <%
                    }    
                %>
                
                <jsp:include page="menu.jsp"/> 
            </div>

            <div id="content"> 
                <div id="leftPanel"> 
                    <div id="invitations">
                        <h3> Invitations : </h3>
                        
                        <div id="listeInvitations"> </div> 
                    </div>

                    <div id="joueurs" >
                        <h3> Listes des joueurs connectés : </h3>
                        
                        <div id="listeJoueurs"> </div>
                    </div>
                </div> 

                <div id="centerPanel">
                    <%
                        if ("startGame".equals(actionStr))
                        {   
                            

                        }
                        else {

                            if ("subscription".equals(actionStr))
                            {
                            %>
                                <jsp:include page="subscription.jsp" />         
                            <%
                            }
                            else if (("play").equals(actionStr))
                            {
                            %>
                                <p>
                                    Vous êtes maintenant inscrit dans la file d'attente des joueurs. 
                                </p>
                           <%
                            }
                            else if ("regles".equals(actionStr))
                            {
                           %>
                                <jsp:include page="regles.jsp" />         
                            <%
                            } 
                            else if ("showProfile".equals(actionStr))
                            {
                            %>
                                <jsp:include page="profil.jsp" />
                            <%
                            }
                            else {
                            %>
                                 <jsp:include page="acceuil.jsp" /> 
                                <!-- <jsp:include page="partieEchecs.jsp" /> -->
                            <%
                            }
                        }
                    %>
                </div>

                <div id="rightPanel"> 
                    <h3>Parties en cours :</h3>

                    <div id="listeParties"> </div>
                </div>
            </div>

            <div id="footer">        
                <p id="copyrights"> Copyright © 2013 Chess ITS! Tous droits réservés. </p>
            </div>
        </div>
    </body>
</html>
