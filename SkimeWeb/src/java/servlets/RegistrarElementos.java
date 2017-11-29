/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.MetaColectiva;
import controllers.Usuario;
import controllers.Lista;
import controllers.Elemento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jade
 */
@WebServlet(name = "RegistrarElementos", urlPatterns = {"/RegistrarElementos"})
public class RegistrarElementos extends HttpServlet {

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
        
//        System.out.println(request.getParameter("selectTipoServicio"));
        
        HttpSession s;
        Usuario u;

        s = request.getSession(true);
        u = (Usuario) s.getAttribute("user");
        
        if (u == null) {
            response.sendRedirect("index.jsp");
        } else {
            
            Lista lista = new Lista();
            int idLista = lista.getIdLista();
            String nombreElemento;
            String fechaInit;
            String fechaEnd;
            double costoElemento;
            
            nombreElemento = request.getParameter("nombre_elemento");
            fechaInit = request.getParameter("fecha_init");
            fechaEnd = request.getParameter("fecha_end");
            costoElemento = Double.parseDouble(request.getParameter("costo_elemento"));
            
            Elemento elemento = new Elemento();
            elemento.registrarElemento(idLista, nombreElemento, fechaInit, fechaEnd, costoElemento);
            
            response.sendRedirect("registrarElemento.jsp");
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
