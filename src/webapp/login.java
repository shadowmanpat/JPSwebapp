package webapp;

import appLayer.User;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    System.out.println("hi");
       String name=request.getParameter("loginname");
       String password=request.getParameter("password");
      //  PrintWriter out= response.getWriter();
      //  out.print(name+": "+password);
        request.setAttribute("username",name);
        request.setAttribute("password",password);
        User userObject = new User();
        if(userObject.isValidUser(name,password)){

            request.getRequestDispatcher("/welcome.jsp").forward(request,response);
        }else{
            request.setAttribute("errorMsg","Invalid credentials");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
