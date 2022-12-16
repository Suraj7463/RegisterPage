/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RegisterServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author suraj dudhabhate
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String name=request.getParameter("user_name");
            String password=request.getParameter("user_password");
            String email=request.getParameter("user_email");
            String gender=request.getParameter("user_gender");
            String course=request.getParameter("user_course");
            
            
            
           // out.println(name);
           // out.println(password);
           // out.println(email);
           // out.println(gender);
           // out.println(course);
            
            // co
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbi_account","root","");
                //query
                
                String q="insert into reg_school(name,password,email,gender,course) values(?,?,?,?,?)";
                
               PreparedStatement pstmt=con.prepareStatement(q);
               pstmt.setString(1,name);
               pstmt.setString(2,password);
               pstmt.setString(3,email);
               pstmt.setString(4,gender);
               pstmt.setString(5,course);
               
               pstmt.executeUpdate();
               
               out.println("<h1>done.........</h1>");
               
            }catch(Exception e){
                e.printStackTrace();
                out.println("<h2>Error</h2>");
            }
                
            out.println("</body>");
            out.println("</html>");
        
        }
    }
}

    
