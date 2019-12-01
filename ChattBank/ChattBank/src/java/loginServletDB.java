/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Chelsea
 */
@WebServlet(urlPatterns = {"/loginServletDB"})
public class loginServletDB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        String dbPW;
        String dbID;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Getting stuff accomplished.... be back soon!");
        
        String id = request.getParameter("idtb");
        String pw = request.getParameter("passtb");
        String dbPath = "C:/Users/Chelsea/Documents/CTC/db/ChattBankMDB.mdb";
        System.out.println("Starting DB Connection");

        
        try (Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Chelsea/Documents/CTC/db/ChattBankMDB.mdb")) 
        {
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM Customers WHERE CustID='" +id+"'";

            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                dbID = rs.getString(1);
                dbPW = rs.getString(2);
                System.out.println(dbID);
                System.out.println(dbPW);


            }
          
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (pw.equals(dbPW)){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet loginServletDB</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>SUCCESSFUL LOGIN!</h1>");
                //out.println("<h1>Servlet loginServletDB at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet loginServletDB</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>UNSUCCESSFUL LOGIN!</h1>");
                out.println("Password: " + dbPW);
                //out.println("<h1>Servlet loginServletDB at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
