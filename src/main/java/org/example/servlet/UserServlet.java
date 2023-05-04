package org.example.servlet;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.daoImplement.UserDaoImpl;
import org.example.entity.City;
import org.example.entity.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private final UserService userService=new UserService(new UserDaoImpl());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/signup.jsp");
        requestDispatcher.forward(req, resp);
    }
    private List<String> getCity(){
        return List.of("Moscow", "Voronezh", "Kazan","Omsk","Samara","Perm");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String firstName=req.getParameter("firstName");
        String midName=req.getParameter("midName");
        String lastName=req.getParameter("lastName");
        Long cityId= Long.valueOf(req.getParameter("cityId"));
        User user=new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setMidName(midName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setCityId(cityId);
        Long created=userService.createUser(user);
        boolean save=false;
        if(created!=null){
            save=true;
        }
        req.setAttribute("userCreated", save);
       // RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/JSP/user/login.jsp");
       // requestDispatcher.forward(req, resp);
        //resp.sendRedirect("user/welcome");

    }
}