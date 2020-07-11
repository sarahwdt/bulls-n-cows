package org.sarahwdt.controller;

import org.sarahwdt.controller.checker.Checker;
import org.sarahwdt.controller.checker.DecimalGuessChecker;
import org.sarahwdt.controller.checker.checks.game.DecimalNumberCheck;
import org.sarahwdt.controller.checker.checks.game.LengthCheck;
import org.sarahwdt.controller.game.BullsAndCowsGameController;
import org.sarahwdt.controller.game.core.creators.DecimalNumberGuessCreator;
import org.sarahwdt.controller.game.core.creators.DecimalNumberSecretCreator;
import org.sarahwdt.controller.game.misc.GameDataWrapper;
import org.sarahwdt.model.entities.MoveData;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class GameServlet extends HttpServlet {
    private BullsAndCowsGameController gameModel;

    public GameServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.gameModel = new BullsAndCowsGameController(new DecimalNumberSecretCreator(4));
        User user = (User)req.getSession().getAttribute("user");
        user.addGame(gameModel.getGame());

        UserServices model = new UserServices();
        model.updateUser(user);
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
            gameModel.move(new DecimalNumberGuessCreator(guess));
            User user = (User)req.getSession().getAttribute("user");
            UserServices model = new UserServices();
            model.updateUser(user);

            List<MoveData> list = new LinkedList<>(gameModel.getDataArray());
            Collections.reverse(list);

            req.setAttribute("data_array", new GameDataWrapper(list));

            //win
            if (gameModel.getResult()){
                resp.sendRedirect("/?message=win!");
            }
            else req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);

        }else {
            List<MoveData> list = new LinkedList<>(gameModel.getDataArray());
            Collections.reverse(list);

            req.setAttribute("data_array", new GameDataWrapper(list));

            req.setAttribute("error", checker.check());
            req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);
        }

    }
}
