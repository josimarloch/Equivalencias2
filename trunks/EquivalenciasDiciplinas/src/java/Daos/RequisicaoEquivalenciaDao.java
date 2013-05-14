/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import beans.Disciplina;
import beans.RequisicaoEquivalencia;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author josimar
 */
public class RequisicaoEquivalenciaDao extends DaoGenerics<RequisicaoEquivalencia> {

    public RequisicaoEquivalenciaDao() {
        clazz =RequisicaoEquivalencia.class;
    }
    public List<RequisicaoEquivalencia> listaPorLogin(String login){
       // listar("AlunoRa = " +login);
         List<RequisicaoEquivalencia> lista = null;
        if (login != null) {
            session = getsession();
            Query query = session.createQuery(
                    "select r from RequisicaoEquivalencia r where r.AlunoRa = '" +login +"'");
                 //   "From disciplina where curso.id = " +id );
            lista = query.list();
            session.flush();
        }
        return lista;
    }
    public List<RequisicaoEquivalencia> listaPorEmailProfessor(String email){
       // listar("AlunoRa = " +login);
         List<RequisicaoEquivalencia> lista = null;
        if (email != null) {
            session = getsession();
            Query query = session.createQuery(
                    "select r from RequisicaoEquivalencia r where r.diciplinaRequerida.professor.email = '" +email +"'");
                 //   "From disciplina where curso.id = " +id );
            lista = query.list();
            session.flush();
        }
        return lista;
    }
    
}
