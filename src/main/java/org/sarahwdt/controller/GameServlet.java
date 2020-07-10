package org.sarahwdt.controller;

import org.sarahwdt.controller.checker.Checker;
import org.sarahwdt.controller.checker.DecimalGuessChecker;
import org.sarahwdt.controller.checker.checks.game.DecimalNumberCheck;
import org.sarahwdt.controller.checker.checks.game.LengthCheck;
import org.sarahwdt.controller.game.BullsAndCowsGameModel;
import org.sarahwdt.controller.game.core.Move;
import org.sarahwdt.controller.game.core.creators.DecimalNumberGuessCreator;
import org.sarahwdt.controller.game.core.creators.DecimalNumberSecretCreator;
import org.sarahwdt.controller.game.misc.GameDataWrapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


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
        Checker<String> checker = new DecimalGuessChecker(guess, Arrays.asList(
                new LengthCheck(4),
                new DecimalNumberCheck(guess)
        ));
        if(Objects.isNull(checker.check())) {
            game.move(new DecimalNumberGuessCreator(guess));

            List<Move> list = new LinkedList<>(game.getDataArray());
            Collections.reverse(list);

            req.setAttribute("data_array", new GameDataWrapper(list));

            //win
            if (game.getResult()) resp.sendRedirect("/?message=win!");
            else req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);
        }else {
            List<Move> list = new LinkedList<>(game.getDataArray());
            Collections.reverse(list);

            req.setAttribute("data_array", new GameDataWrapper(list));

            req.setAttribute("error", checker.check());
            req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);
        }

    }
}
