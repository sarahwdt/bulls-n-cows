package org.sarahwdt.controller;

import org.sarahwdt.controller.game.BullsAndCowsGameModel;
import org.sarahwdt.controller.game.core.MoveData;
import org.sarahwdt.controller.game.core.creators.DecimalNumberGuessCreator;
import org.sarahwdt.controller.game.core.creators.DecimalNumberSecretCreator;
import org.sarahwdt.controller.game.misc.GameDataWrapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class GameServlet extends HttpServlet {
    private BullsAndCowsGameModel game;

    public GameServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.game = new BullsAndCowsGameModel(new DecimalNumberSecretCreator(4));

        req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String guess = req.getParameter("guess");

        game.move(new DecimalNumberGuessCreator(guess));

        List<MoveData> list = new LinkedList<>(game.getDataArray());
        Collections.reverse(list);

        req.setAttribute("data_array", new GameDataWrapper(list));

        //win
        if(game.getResult()) resp.sendRedirect("/?message=win!");
        else req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);

    }
}
