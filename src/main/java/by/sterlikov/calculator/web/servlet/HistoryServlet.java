package by.sterlikov.calculator.web.servlet;

import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (value = "/history", name = "historyServlet")
public class HistoryServlet extends HttpServlet {
    private final OperationService operationService = OperationService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("history", operationService.getAllOperationByUserName(user));
        req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
