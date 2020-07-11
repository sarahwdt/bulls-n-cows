<%@page import="org.sarahwdt.model.entities.MoveData"%>
<%@page import="org.sarahwdt.controller.game.misc.GameDataWrapper" %>
<html>
    <meta content="text/html; charset=UTF-8">
    <head>
        <title>Bulls and cows game</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <jsp:include page="/pages/elements/_header.jsp" />
        <form method="post" action="/game" class="w3-container w3-card-4" style="width: 40%; margin-left: auto; margin-right:auto">
                <h2 class="w3-center"> Guess... </h2>
                <h3 class="w3-center w3-red"><%if(request.getAttribute("error") != null) out.print(request.getAttribute("error"));%></h3>
                <div class="w3-container" style="height: 205px; overflow: auto;">
                    <ul class="w3-ul">
                        <%
                        if(request.getAttribute("data_array")!=null){
                            GameDataWrapper dataArray = (GameDataWrapper)request.getAttribute("data_array");
                            for(MoveData data:dataArray.getCollection()){
                                out.print("<li>" + data.toString() + "</li>");
                            }
                        }
                        %>
                    </ul>
                </div>
                <div class="w3-row">
                    <div class="w3-col s9">
                        <input type="text" name="guess" class="w3-input w3-margin-bottom" >
                    </div>
                    <div class="w3-col s3">
                        <button type="sumbit" class="w3-btn w3-gray w3-margin-bottom">Make guess</button>
                    </div>
                </div>
        </form>
        <jsp:include page="/pages/elements/_footer.jsp" />
    </body>
</html>