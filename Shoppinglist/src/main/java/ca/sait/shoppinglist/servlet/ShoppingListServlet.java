/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.shoppinglist.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author neild
 */
public class ShoppingListServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
          
         String name = (String) session.getAttribute("name");
           
         if (name == null){
              getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
         }
        
         else{
              getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
         }
                
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
           
       
        if(action != null && action.equals("add")){
            
            String item = request.getParameter("item");
            
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            
            items.add(item);
            session.setAttribute("items", items);
        }
        else if(action != null && action.equals("delete")){
            String item = request.getParameter("item");
            
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            
            items.remove(item);
        }
        
        else{
            String name = request.getParameter("name");
  
            ArrayList<String> items = new ArrayList<>();
            session.setAttribute("name", name);
            session.setAttribute("items", items);
       
        }
           getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        
       
    }

}
