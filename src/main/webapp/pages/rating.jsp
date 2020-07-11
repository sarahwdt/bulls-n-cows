<%@page import="org.sarahwdt.model.entities.Game"%>
<%@page import="org.sarahwdt.model.entities.User"%>
<%@page import="org.sarahwdt.controller.misc.UsersDataWrapper" %>
<html>
    <meta content="text/html; charset=UTF-8">
    <head>
        <title>Bulls and cows game</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <jsp:include page="/pages/elements/_header.jsp" />
        <div class="w3-container w3-card-4" style="width: 40%; margin-left: auto; margin-right:auto">
                <h2 class="w3-center w3-gray"> Users rating</h2>
                <div class="w3-container" style="min-height: 263px; overflow: auto;">
                    <table class="w3-table w3-left-align w3-margin-bottom w3-bordered">
                        <%
                        if(request.getAttribute("users_array")!=null){
                            int i = 1;
                            UsersDataWrapper users = (UsersDataWrapper)request.getAttribute("users_array");
                            out.print("<tr>");
                            out.print("<th>Place</th>");
                            out.print("<th>Name</th>");
                            out.print("<th>Games</th>");
                            out.print("<th>Rating</th>");
                            out.print("<tr>");
                            for(User user:users.getCollection()){
                                int c = 0;
                                for(Game g:user.getGames()) c = g.isResult()?c+1:c;
                                out.print("<tr class=\"w3-hover-black\">");
                                out.print("<td>" + i + "</td>");
                                i++;
                                out.print("<td>" + user.getName() + "</td>");
                                out.print("<td>" + c + "</td>");
                                out.print("<td>" + user.getRating() + "</td>");
                                out.print("</tr>");
                            }
                        }
                        %>
                    </ul>
                </div>
        </div>
        <jsp:include page="/pages/elements/_footer.jsp" />
    </body>
</html>