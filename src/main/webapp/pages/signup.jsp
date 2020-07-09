<html>
    <meta content="text/html; charset=UTF-8">
    <head>
        <title>Bulls and cows game</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <jsp:include page="/pages/elements/_header.jsp" />
        <form method="post" class="w3-container w3-card-4" style="width: 40%; margin-left: auto; margin-right:auto">
            <h2 class="w3-center"> Sign Up </h2>
            <h3 class="w3-center w3-red"><%if(request.getAttribute("error") != null) out.print(request.getAttribute("error"));%></h3>
            <h3 class="w3-center"> Name </h3>
            <input type="text" name="name" class="w3-input w3-border w3-round-large" >
            <h3 class="w3-center"> Password </h3>
            <input type="password" name="pass" class="w3-input w3-border w3-round-large" >
            </br>
            <div class="w3-center">
                <button type="sumbit" class="w3-btn w3-gray w3-round-large w3-margin-bottom" style="width: 40%">Sign Up</button>
            </div>
        </form>
        <jsp:include page="/pages/elements/_footer.jsp" />
    </body>
</html>