<%@page import="org.sarahwdt.model.entities.User" %>
<div class="w3-bar w3-grey w3-large">
    <%
        if(request.getSession().getAttribute("user") != null){
            User user = (User)request.getSession().getAttribute("user");
            out.print("<a href=\"/user\" class=\"w3-bar-item w3-button w3-left\"> Hello, " + user.getName() + "</a>");
        } else
            out.print("<a href=\"/signin\" class=\"w3-bar-item w3-button w3-left\"> You not authorized</a>");
    %>
    <%if(request.getSession().getAttribute("user") == null) {
        out.print("<a href=\"/signup\" class=\"w3-bar-item w3-button w3-right\">Sign Up</a>");
        out.print("<a href=\"/signin\" class=\"w3-bar-item w3-button w3-right\">Sign In</a>");
    } else{
        out.print("<a href=\"/signout\" class=\"w3-bar-item w3-button w3-right\">Sign Out</a>");
        out.print("<a href=\"/game\" class=\"w3-bar-item w3-button w3-right\">Game</a>");
    }
    %>
    <a href="/rating" class="w3-bar-item w3-button w3-right">Users rating</a>
    <a href="/" class="w3-bar-item w3-button w3-right">Home</a>


</div>