package webapp;

import appLayer.User;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
            String DB_url=System.getProperty("JDBC_CONNECTION_STRING");
            String DB_user=System.getProperty("JDBC_USER");
            String DB_password=System.getProperty("JDBC_PASSWORD");
            request.setAttribute("errorMsg","Invalid credentials");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }


    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("firstTime to init()");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("firstTime to serviceServerl()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("firstTime to serviceHttpServerl()");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("firstTime to destroy()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
