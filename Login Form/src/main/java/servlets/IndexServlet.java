package servlets;

import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@WebServlet(name = "IndexServlet")
public class IndexServlet extends HttpServlet {
    ArrayList user = new ArrayList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File userlist = new File
                ("csv\\userlist.csv");
        Writer writer = new FileWriter(userlist, true);

        writer.write(request.getParameter("name") + ", ");
        writer.write(request.getParameter("last_name")+ ", ");
        writer.write(request.getParameter("username") + ", ");
        writer.write(request.getParameter("email") + ", ");
        writer.write(request.getParameter("password") + "\n");

        writer.close();

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/userlist.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
        dispatcher.forward(request, response);
    }

    public ArrayList getAllUsersInfo() {
        try {
            FileInputStream stream =
                    new FileInputStream(
                            "C:\\Users\\Bulat\\IdeaProjects\\Informatics-2\\src\\main\\java\\csv\\userlist.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;

            while ((line = reader.readLine()) != null) {

                for (int i = 0; i < 5; i++) {
                    user.add(line.split(", ")[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }
}
