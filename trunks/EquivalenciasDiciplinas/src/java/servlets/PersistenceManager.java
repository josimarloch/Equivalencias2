/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Daos.CursoDao;
import Daos.DisciplinaDao;
import Daos.ProfessorDao;
import beans.Curso;
import beans.Disciplina;
import beans.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josimar
 */
@WebServlet(name = "PersistenceManager", urlPatterns = {"/admin/PersistenceManager"})
public class PersistenceManager extends HttpServlet {

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
            out.println("<title>Servlet PersistenceManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersistenceManager at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);
        String ok = request.getParameter("ok");
        if (ok != null) {
            if (ok.equals("cadastra_professor")) {
                String nome = request.getParameter("nome").trim();
                String email = request.getParameter("email").trim();
                ProfessorDao pd = new ProfessorDao();
                // if(pd.getPorEmail(email)!=null)

                if (!nome.equals("") && !email.equals("")) {
                    new ProfessorDao().persistir(new Professor(nome, email));
                    response.sendRedirect("index.jsp?onload=cadastra_professor.jsp?mensagem_ok=Professor cadastrado com sucesso!");
                } else {
                    response.sendRedirect("index.jsp?onload=cadastra_professor.jsp?mensagem_erro=Nome ou email Invalido! por favor verifique os campos&professor_nome=" + nome + "&professor_email=" + email + "");

                }
            } else if (ok.equals("cadastra_curso")) {
                String nome = request.getParameter("nome").trim();
                if (!nome.equals("")) {
                    new CursoDao().persistir(new Curso(nome.toUpperCase()));
                    response.sendRedirect("index.jsp?onload=cadastra_curso.jsp?mensagem_ok=Curso cadastrado com sucesso!");
                } else {
                    response.sendRedirect("index.jsp?onload=cadastra_curso.jsp?mensagem_erro=Nome invalido para curso");

                }

            } else if (ok.equals("cadastra_disciplina")) {
                String nome = request.getParameter("nome").trim();
                String curso = request.getParameter("curso_id").trim();
                String professor = request.getParameter("professor_id").trim();
                if (!nome.equals("")) {
                    Curso c = new CursoDao().obterPorId(Integer.parseInt(curso));
                    Disciplina d = new Disciplina();
                    d.setNome(nome);
                    d.setCurso(c);
                    d.setEmenta(request.getParameter("ementa").trim());

                    if (!professor.equals("0")) {
                        d.setProfessor(new ProfessorDao().obterPorId(Integer.parseInt(professor)));
                    }
                    new DisciplinaDao().persistir(d);
                    response.sendRedirect("index.jsp?onload=cadastra_disciplina.jsp?mensagem_ok=Disciplina cadastrada com sucesso!");
                } else {
                    response.sendRedirect("index.jsp?onload=cadastra_disciplina.jsp?mensagem_erro=Erro: nome invalido para disciplina!");

                }
            } else if ("vincular_professor".equals(ok)) {
                String professor = request.getParameter("professor_id").trim();
                Disciplina d = new DisciplinaDao().obterPorId(Integer.parseInt(request.getParameter("disciplina_id")    ));
                if (!professor.equals("0")) {
                    d.setProfessor(new ProfessorDao().obterPorId(Integer.parseInt(professor)));
                }else{
                response.sendRedirect("index.jsp?onload=mostra_msg.jsp?mensagem_erro=Professor invalido, por favor escolha o professor corretamente!");
                return;
                }
                new DisciplinaDao().persistir(d);
                response.sendRedirect("index.jsp?onload=mostra_msg.jsp?mensagem_ok=Professor vinculado a Disciplina com sucesso!");

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
