package by.sterlikov.calculator.web.servlet;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.factory.OperationFactory;
import by.sterlikov.calculator.service.OperationService;
import by.sterlikov.calculator.storage.JdbcOperationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(value = "/calculator", name = "OperationServlet")
public class OperationServlet extends HttpServlet {
    private final OperationService operationService = OperationService.getInstance();
    private final OperationFactory operationFactory = OperationFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentUser", req.getSession().getAttribute("currentUser"));
        String values = req.getParameter("values"); // 2,3 sum
        String[] split = values.split(",");
        String type = req.getParameter("type").toUpperCase();// sum
        User user = (User) req.getSession().getAttribute("currentUser");
        Operation operation = operationFactory.getOperation(split, Operation.Type.valueOf(type),user);
        Operation calculate = operationService.calculate(operation);
        double result = calculate.result();

        req.setAttribute("result", result);
        req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);
    }
}
