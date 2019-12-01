/*
 *Chelsea Piccirilli
 *Lab 5
 *Fall 2019
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import business.*;
/**
 *
 * @author Chelsea
 */
@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("idtb");
            String pw = request.getParameter("passtb");
            
            customer c1 = new customer();
            c1.selectDB(id);
            // System.out.println("ID ="+c1.getCustId());
            //System.out.println("Pass = "+c1.getCustPassword());
            String userName = c1.getCustId();
            String password = c1.getCustPassword();
            
            if (userName == null){
                c1.setCustId(id);
                System.out.println("Reset username");
            }
            
            HttpSession ses2 = request.getSession();    //creates a new session.
            ses2.setAttribute("customer", c1);  //Stores customer object to session
            System.out.println("Customer added to session.");
            
            if (userName != null && userName.equals(id)){
                if (password.equals(pw)){
                    
                    System.out.println("Password and Username correct.");
                    c1.display();
                    RequestDispatcher rd = request.getRequestDispatcher("/accountlookup.html"); //Forwards to accountlookup.html
                    rd.forward(request, response);
                }
                else{
                    System.out.println("Password* and username do not match. Please try again.");
                    
                    RequestDispatcher err = request.getRequestDispatcher("/Error.jsp"); //Forwards to Error.jsp
                    err.forward(request, response);
                    
                }
            }
            
            else{
                System.out.println("Password and username* do not match. Please try again.");
                
                RequestDispatcher err = request.getRequestDispatcher("/Error.jsp");
                err.forward(request, response);
                
            }
            
            //System.out.println("Hello World");
            
            
           
            
            
            
        }
        catch(Exception e){
            System.out.println(e);
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
        processRequest(request, response);
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
