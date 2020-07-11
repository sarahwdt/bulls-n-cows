<%@page import="org.sarahwdt.model.entities.MoveData"%>
<%@page import="org.sarahwdt.controller.game.misc.GameDataWrapper" %>
<%@page import="org.sarahwdt.model.entities.User" %>
<%@page import="org.sarahwdt.model.entities.Game" %>
<html>
    <meta content="text/html; charset=UTF-8">
    <head>
        <title>Bulls and cows game</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <jsp:include page="/pages/elements/_header.jsp" />
        <div class="w3-container w3-card-4" style="width: 40%; margin-left: auto; min-height: 327px; margin-right:auto;">
                    <table class="w3-table w3-left-align w3-margin-bottom w3-bordered">
                    <h2 class="w3-center w3-grey"> <%
                        User user = (User)request.getSession().getAttribute("user");
                        out.print("Name " + user.getName() + " | Rating " + user.getRating());
                    %></h2>
                        <%
                            out.print("<tr>");
                            out.print("<th>Moves</th>");
                            out.print("<th class=\"w3-right-align\">Result</th>");
                            out.print("<tr>");
                            for(Game game:user.getGames()){
                                String col = game.isResult()?"green":"red";
                                out.print("<tr class=\"w3-hover-" + col + "\">");
                                out.print("<td>" + game.getMoveData().size() + "</td>");
                                String result = game.isResult()?"win":"lose";
                                out.print("<td class=\"w3-right-align\">" + result + "</td>");
                                out.print("</tr>");
                            }
                        %>
                    </table>
        </div>
        <jsp:include page="/pages/elements/_footer.jsp" />
    </body>
</html>