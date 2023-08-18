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


@WebServlet(value = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Optional<User> existsUser = userService.getByUserName(userName);
        if (existsUser.isPresent()) {
            User user = existsUser.get();
            System.out.println(user.getName());
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect("/");
                return;
            } else {
                req.setAttribute("message", "Incorrect password");
            }
        } else {
            req.setAttribute("message", "User not found");
        }
        req.getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }
}
