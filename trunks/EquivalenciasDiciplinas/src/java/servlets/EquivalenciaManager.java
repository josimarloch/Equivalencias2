/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Daos.DisciplinaDao;
import beans.Disciplina;
import beans.ItemHistorico;
import beans.RequisicaoEquivalencia;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import controler.EmailControler;
import Daos.ItemHistoricoDao;
import Daos.RequisicaoEquivalenciaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josimar
 */
public class EquivalenciaManager extends HttpServlet {

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
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EquivalenciaManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EquivalenciaManager at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        response.sendRedirect("index.jsp?onload=login.jsp?mensagem_erro=Nao foi possivel obter dados de login, por favor faca o ligin novamente");
       return;
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
       String action = request.getParameter("ok");
        if ("persistir".equals(action)) {
            Disciplina d = new DisciplinaDao().obterPorId(Integer.parseInt(request.getParameter("disciplina_id")));
            EmailControler em = new EmailControler();
            RequisicaoEquivalencia requisicao = new RequisicaoEquivalencia();
            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("aluno");
            if (usuario != null) {
                String ementa = request.getParameter("ementa");
                requisicao.setAlunoRa(usuario.getLogin());
                requisicao.setObservacao(ementa);
                requisicao.setDiciplinaRequerida(d);
                new RequisicaoEquivalenciaDao().persistir(requisicao);
                new ItemHistoricoDao().persistir(new ItemHistorico(requisicao));
                response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("index.jsp?onload=login.jsp?mensagem_erro=Nao foi possivel obter dados de login, por favor faca o login novamente");
            }
        }
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
