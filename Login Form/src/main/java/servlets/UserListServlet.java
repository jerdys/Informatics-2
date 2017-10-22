package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@WebServlet(name = "UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("csv/userlist.csv");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("csv/userlist.csv");
        requestDispatcher.forward(request, response);
    }

    /*public ArrayList getAllUsersInfo() {
        ArrayList user = new ArrayList();
        String[] userInfo = new String[5];

        try {
            FileInputStream stream =
                    new FileInputStream(
                            "C:\\Users\\Bulat\\IdeaProjects\\Informatics-2\\src\\main\\java\\csv\\userlist.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;

            while ((line = reader.readLine()) != null) {
                for (String info : userInfo) {
                    user.add(info);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }*/
}
