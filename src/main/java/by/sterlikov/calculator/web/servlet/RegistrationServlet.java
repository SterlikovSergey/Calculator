package by.sterlikov.calculator.web.servlet;

import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = new User(name, userName, password);
        Optional<User> exists = userService.getByUserName(userName);
        if (exists.isPresent()) {
            User existsUser = exists.get();
            if (existsUser.getUserName().equals(userName)) {
                req.getSession().setAttribute("existsUser", "Username is taken, please select another username");
                req.getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
            }
        } else {
            userService.create(user);
            req.getSession().setAttribute("currentUser", user);
            resp.sendRedirect("/");
        }

    }
}
