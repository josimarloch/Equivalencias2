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
import beans.StatusSolicitacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
        String action = request.getParameter("ok");
        if ("deferir".equals(action)) {
            RequisicaoEquivalencia re = new RequisicaoEquivalenciaDao().obterPorId(Integer.parseInt(request.getParameter("pedido_id")));
            re.setStatus(StatusSolicitacao.ACEITO);
            re.setDataFinal(Calendar.getInstance());
            new RequisicaoEquivalenciaDao().persistir(re);
            new ItemHistoricoDao().persistir(new ItemHistorico(re));
            response.sendRedirect("index.jsp?onload=mostra_msg.jsp?mensagem_ok=O Status deste pedido de equivalencia foi alterado e salvo com sucesso!");
        }
        //processRequest(request, response);
        // response.sendRedirect("index.jsp?onload=login.jsp?mensagem_erro=Nao foi possivel obter dados de login, por favor faca o ligin novamente");
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
        try {

            String action = request.getParameter("ok");
            if ("persistir".equals(action)) {
                Disciplina d = new DisciplinaDao().obterPorId(Integer.parseInt(request.getParameter("disciplina_id")));
                EmailControler em = new EmailControler();
                RequisicaoEquivalencia requisicao = new RequisicaoEquivalencia();
                HttpSession session = request.getSession(true);
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                if (usuario != null) {
                    String ementa = request.getParameter("ementa");
                    requisicao.setAlunoRa(usuario.getLogin());
                    requisicao.setEmenta(ementa);
                    requisicao.setDiciplinaRequerida(d);
                    new RequisicaoEquivalenciaDao().persistir(requisicao);
                    new ItemHistoricoDao().persistir(new ItemHistorico(requisicao));
                    response.sendRedirect("index.jsp?onload=mostra_msg.jsp?mensagem_ok=Seu pedido de equivalencia foi criado com sucesso!");
                } else {
                    response.sendRedirect("index.jsp?onload=login.jsp?mensagem_erro=Nao foi possivel obter dados de login, por favor faca o login novamente");
                }
            }
            if ("indeferir".equals(action)) {
                RequisicaoEquivalencia re = new RequisicaoEquivalenciaDao().obterPorId(Integer.parseInt(request.getParameter("pedido_id")));
                re.setStatus(StatusSolicitacao.NEGADO);
                re.setDataFinal(Calendar.getInstance());
                new RequisicaoEquivalenciaDao().persistir(re);
                new ItemHistoricoDao().persistir(new ItemHistorico(re));
                response.sendRedirect("index.jsp?onload=mostra_msg.jsp?mensagem_ok=O Status deste pedido de equivalencia foi alterado e salvo com sucesso para o status \"NEGADO\"!");
            }
        } catch (Exception e) {
            response.sendRedirect("index.jsp?onload=login.jsp?mensagem_erro=Nao foi possivel Processar seu pedido pelo seguinte erro: " + e.toString() + ", por favor tente Novamente!");
            return;
        } finally {
            PrintWriter p = response.getWriter();
            p.print("Ocorreu um erro grave...");

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
