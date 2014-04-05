/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author fotakkihe
 */
public class NewServlet extends HttpServlet {
    @Resource(name = "maailma")
    private DataSource maailma;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            
            String maa = request.getParameter("arvo");

            Class.forName("com.mysql.jdbc.Driver");

            
            
            Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs = null;
            try {
                rs = stmt.executeQuery("SELECT * FROM country WHERE Name ='"+maa+"'");
            } catch (SQLException ex) {
                Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                out.println("<table border='1'>");
                while (rs.next())
                    {
                        int x = rs.getInt("Population");
                        String s = rs.getString("Name");
                        //System.out.println("Population= "+x+": Name= "+s);
                        
                        out.println("<tr><td> Name= "+s+"<td/> <td> Population= "+x+"<td/><tr/>");
                        //out.println("Population= "+x+": Name= "+s);
                        //out.println("<br>");
                     }
                out.println("<table/>");
            } catch (SQLException ex) {
                //Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
            
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
