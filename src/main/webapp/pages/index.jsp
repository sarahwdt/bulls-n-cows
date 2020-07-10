<html>
    <meta content="text/html; charset=UTF-8">
    <head>
        <title>Bulls and cows game</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <jsp:include page="/pages/elements/_header.jsp" />
        <div>
            <h1>Hello</h1>
            <%if(request.getAttribute("message") != null) out.print(request.getParameter("message"));%>
        </div>
        <jsp:include page="/pages/elements/_footer.jsp" />
    </body>
</html>