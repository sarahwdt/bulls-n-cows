package org.sarahwdt.controller;

import org.sarahwdt.controller.game.BullsAndCowsGameData;
import org.sarahwdt.controller.game.BullsAndCowsGameModel;
import org.sarahwdt.controller.game.core.GameModel;
import org.sarahwdt.controller.game.core.MoveData;
import org.sarahwdt.controller.game.core.creators.DecimalNumberGuessCreator;
import org.sarahwdt.controller.game.core.creators.DecimalNumberSecretCreator;

import javax.servlet.ServletException;
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
        GameModel game = new BullsAndCowsGameModel(new DecimalNumberSecretCreator(4));
        req.getSession().setAttribute("game", game);
        req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*GameModel game = (BullsAndCowsGameModel)req.getSession().getAttribute("game");
        String s = (String)req.getAttribute("guess");
        if(s == null) throw new Error();
        BullsAndCowsGameData data = (BullsAndCowsGameData) game
                .move(new DecimalNumberGuessCreator(s));

        req.setAttribute("result", data.getResult());
        req.setAttribute("data",  "B" + data.getBulls() + "C" + data.getCows());*/

        req.setAttribute("error", req.getAttribute("error"));
        req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);
    }
}
