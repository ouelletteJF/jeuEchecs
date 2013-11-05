<%-- 
    Document   : index
    Created on : 7 jan. 2013, 18:10:04
    Author     : ilyes ait hamouda
--%>

<%@page import="com.STI.entite.Roi"%>
<%@page import="com.STI.entite.Reine"%>
<%@page import="com.STI.entite.Fou"%>
<%@page import="com.STI.entite.Tour"%>
<%@page import="com.STI.entite.Cavalier"%>
<%@page import="com.STI.entite.Pion"%>
<%@page import="com.STI.entite.Echiquier"%>
<%@page import="com.STI.dao.dao"%>
<%@page import="com.STI.dao.Userdao"%>
<%@page import="com.STI.jdbc.Connexion"%>
<%@page import="com.STI.entite.Utilisateur"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
    <head>
        <link href="./style/menu.css" rel="stylesheet" type="text/css">
        <link href="./style/style.css" rel="stylesheet" type="text/css">
        
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="./jquery/js.js"></script>	
        <script src="./jquery/validForm.js" language="JavaScript"></script>
        <script src="./jquery/date.js" language="JavaScript"></script>
        <script src="./jquery/ajax.js" language="JavaScript"></script>
        <script src="./jquery/jGame.js" language="JavaScript" ></script>   
        <script src="./jquery/changeProfil.js" language="JavaScript" ></script>
        <script src="./jquery/partieEchecs.js" language="JavaScript" ></script>
        
        <script language="Javascript" type="text/javascript">
            function re()
            {
                Refresh();
            }
        </script>
        
        <title>It's all about chess!</title>
    </head>
  
    <body <% if ((session.getAttribute("connecte") != null)) { %> onLoad="setInterval('re()', 1000);" <% } %> > 
        <div id="all">             
            <div id="header"> 
                <%
                    // Si aucune session n'est ouverte...
                    if (session.getAttribute("connecte")==null)  
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
                        
                        <p> </p> 
                    </div>

                    <div id="listeJoueurs" >
                        <h3> Listes des joueurs connectés : </h3>
                        
                        <p> </p>
                    </div>
                </div> 

                <div id="centerPanel">
                    <%
                        if ("startGame".equals(request.getParameter("action")))
                        {   
                            String chaine= (String)this.getServletContext().getAttribute("Gamers");
                            String[] tab = chaine.split(",");
                            System.out.println(tab[0]+","+tab[1]);

                            if ((tab[0].equals((String)request.getSession().getAttribute("connecte")))||(tab[1].equals((String)request.getSession().getAttribute("connecte"))))
                            { 
                                Echiquier ech = (Echiquier)application.getAttribute("echec");
                                out.println("<table id='tableDeJeu' >");

                                for (int i=0; i<8;i++)
                                {
                                    out.println("<tr>");

                                    for (int j=0; j<8; j++)
                                    {
                                        out.println("<td  >");
                                        if ( ech.get(i, j) instanceof Pion )
                                        { 
                                            Pion p = (Pion)ech.get(i, j); 

                                            if (p.getCouleur().equals("blanc"))
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/6.gif'/>");
                                            else
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/12.gif'/>");
                                        }
                                        if ( ech.get(i, j) instanceof Cavalier )
                                        { 
                                            Cavalier c = (Cavalier)ech.get(i, j); 

                                            if (c.getCouleur().equals("blanc"))
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/2.gif'/>");
                                            else
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/8.gif'/>");
                                        }
                                        if ( ech.get(i, j) instanceof Tour )
                                        { 
                                            Tour t = (Tour)ech.get(i, j); 

                                            if (t.getCouleur().equals("blanc"))
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/1.gif'/>");
                                            else 
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/7.gif'/>");
                                        }
                                        if (ech.get(i, j) instanceof Fou )
                                        { 
                                            Fou f = (Fou)ech.get(i, j); 

                                            if (f.getCouleur().equals("blanc"))
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/3.gif'/>");
                                            else 
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/9.gif'/>");
                                        }
                                        if (ech.get(i, j) instanceof Reine )
                                        { 
                                            Reine re = (Reine)ech.get(i, j); 

                                            if (re.getCouleur().equals("blanc"))
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/4.gif'/>");
                                            else 
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/10.gif'/>");
                                        }
                                        if (ech.get(i, j) instanceof Roi )
                                        { 
                                            Roi r = (Roi)ech.get(i, j); 

                                            if (r.getCouleur().equals("blanc"))
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/5.gif'/>");
                                            else 
                                                out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/11.gif'/>");
                                        }

                                        if (ech.get(i, j) == null )
                                        {
                                            out.println("<img width='50' height='50' id='"+i+","+j+"' src='./images/vide.png'/>");
                                        }

                                        out.println("</td>");
                                    }

                                    out.println("<tr>");
                                }

                                out.println("</table>");
                            }

                        }
                        else {

                            if ("subscription".equals(request.getParameter("action")))
                            {
                            %>
                                <jsp:include page="subscription.jsp" />         
                            <%
                            }
                            else if (("play").equals(request.getParameter("action")))
                            {
                            %>
                                <p>
                                    Vous êtes maintenant inscrit dans la file d'attente des joueurs. 
                                </p>
                           <%
                            }
                            else if ("regles".equals(request.getParameter("action")))
                            {
                           %>
                                <jsp:include page="regles.jsp" />         
                            <%
                            } 
                            else if ("profil".equals(request.getParameter("action")))
                            {
                            %>
                                <jsp:include page="profil.jsp" />
                            <%
                            }
                            else {
                            %>
                                 <!-- <jsp:include page="acceuil.jsp" /> -->
                                <jsp:include page="partieEchecs.jsp" /> 
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
