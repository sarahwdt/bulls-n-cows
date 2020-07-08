package org.sarahwdt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GameServlet extends HttpServlet {

    public GameServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("done", "done");
        req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);

//        String number = (String) req.getAttribute("number");
//
//        if(number!=null){
//            int num = Integer.parseInt(number);
//            req.setAttribute("resp", "done");
//        }
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/org/sarahwdt/pages/game.jsp");
//        dispatcher.forward(req, resp);



    }
}
