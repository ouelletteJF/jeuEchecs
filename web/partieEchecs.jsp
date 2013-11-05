
<%
    int i, j;
    String l, c;
    
%>
    <table id="echiquier" onClick="reinitEchiquier()" onDblClick="deplacer(1,1,3,1)" >
<%
    
    for (i = 1; i <= 8; i++) 
    {
        l = "l" + Integer.toString(i);
%>
        <tr>  
<%
        for (j = 1; j <= 8; j++) 
        {
            c = "c" + Integer.toString(j);
%>
            <td class="caseEchiquier" onClick="getCell(this)" id=<% out.print("\"" + l + c + "\"" ); %> > </td>
<%
        }
%>
        </tr>
<%
    }
    
%>
    
    </table>
