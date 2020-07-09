<%@page import="org.sarahwdt.model.entities.User" %>
<div class="w3-bar w3-grey w3-large">
    <a href="/" class="w3-bar-item w3-button">Home<a>
    <%if(request.getSession().getAttribute("user") == null) {
            out.print("<a href=\"/signin\" class=\"w3-bar-item w3-button\">Sign In</a>");
            out.print("<a href=\"/signup\" class=\"w3-bar-item w3-button\">Sign Up</a>");
        } else
            out.print("<a href=\"/signout\" class=\"w3-bar-item w3-button\">Sign Out</a>");
    %>

        <div class="w3-bar-item w3-right"><%
            if(request.getSession().getAttribute("user") != null){
                User user = (User)request.getSession().getAttribute("user");
                out.print("You authorized as:" + user.getName());
            } else{
                out.print("You not authorized");
            }
        %></div>
</div>