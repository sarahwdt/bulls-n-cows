<html>
    <meta content="text/html; charset=UTF-8">
    <head>
        <title>Bulls and cows game</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <jsp:include page="/pages/elements/_header.jsp" />
        <div class="w3-container w3-card-4" style="width: 40%; margin-left: auto; margin-right:auto">
            <h2 class="w3-center w3-gray"> Bulls and cows</h2>
                <div class="w3-container w3-medium" style="min-height: 263px; overflow: auto;">
                    The numerical version of the game is usually played with 4 digits.</br>
                    Host make <span class="w3-text-blue">4-digit secret number. The digits must be all different.</span></br>
                    On your turn, he is trying to guess the secret number, and host gives the number of matches.</br>
                    If the matching digits are in their right positions, they are <span class="w3-text-red">"bulls"</span>, if in different positions, they are <span class="w3-text-green">"cows"</span>.</br>
                </div>
        </div>
        <jsp:include page="/pages/elements/_footer.jsp" />
    </body>
</html>