<%@page import="org.sarahwdt.model.entities.User" %>
<div class="w3-bar w3-grey w3-large">
    <div class="w3-bar-item w3-left"><%
        if(request.getSession().getAttribute("user") != null){
            User user = (User)request.getSession().getAttribute("user");
            out.print("Hello, " + user.getName());
        } else
            out.print("You not authorized");
    %></div>
    <a href="/" class="w3-bar-item w3-button w3-right">Home<a>
    <%if(request.getSession().getAttribute("user") == null) {
        out.print("<a href=\"/signin\" class=\"w3-bar-item w3-button w3-right\">Sign In</a>");
        out.print("<a href=\"/signup\" class=\"w3-bar-item w3-button w3-right\">Sign Up</a>");
    } else{
        out.print("<a href=\"/game\" class=\"w3-bar-item w3-button w3-right\">Lets game</a>");
        out.print("<a href=\"/signout\" class=\"w3-bar-item w3-button w3-right\">Sign Out</a>");
    }
    %>


</div>