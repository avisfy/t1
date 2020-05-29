package Servlets;

import DbWork.DbWork;
import User.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataLoader extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        DbWork dbWork = new DbWork();
        switch (action) {
            case "from_db":
                ArrayList<User> users = dbWork.select();
                if(!users.isEmpty()) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter pw = resp.getWriter();
                    Gson gson = new Gson();
                    for(User user: users) {
                        user.printUser();
                    }
                    String jsonUser = gson.toJson(users);
                    pw.print(jsonUser);
                    pw.close();
                }
                break;
            case "add_user":
                String[] user = req.getParameterValues("user");
                dbWork.addUser(user);
                break;
        }

    }
}
