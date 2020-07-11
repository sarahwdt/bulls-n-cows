package org.sarahwdt.controller;

import org.sarahwdt.controller.game.core.GameController;
import org.sarahwdt.controller.game.core.builder.EasyDecimalNumberGameControllerBuilder;
import org.sarahwdt.controller.game.core.builder.GameControllerBuilder;
import org.sarahwdt.controller.game.core.builder.GameDirector;
import org.sarahwdt.controller.misc.GameDataWrapper;
import org.sarahwdt.model.entities.MoveData;
import org.sarahwdt.model.entities.User;
import org.sarahwdt.model.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class GameServlet extends HttpServlet {
    private GameController gameController;

    public GameServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        GameControllerBuilder builder = new EasyDecimalNumberGameControllerBuilder();
        GameDirector director = new GameDirector(builder, user, new UserServices());
        director.makeController();

        gameController = builder.getController();

        req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String guess = req.getParameter("guess");
        String result = gameController.move(guess);
        List<MoveData> list = new LinkedList<>(gameController.getGame().getMoveData());
        Collections.reverse(list);

        req.setAttribute("data_array", new GameDataWrapper(list));
        if (Objects.nonNull(result))
            req.setAttribute("error", result);

        req.getRequestDispatcher("/pages/game.jsp").forward(req, resp);
    }
}
