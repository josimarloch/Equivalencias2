/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author a1207490
 */
public class DaoGenerics<T> implements Dao<T> {

    static Session session = null;
    protected Class clazz;

    public DaoGenerics() {
        
    }

    protected Session getsession() {
       // session = HibernateConfiguration.getSessionFactory().getCurrentSession();
        if (session == null) {
            session = HibernateConfiguration.getSessionFactory().openSession();
            return session;
        }else {
            return session;
        }
    }

    @Override
    public void persistir(T o) {

        getsession().saveOrUpdate(o);
        getsession().flush();
        
    }

    public void atualizar(T o) {
        getsession().update(o);
        getsession().flush();
    }

    @Override
    public void remover(T o) {
        session = HibernateConfiguration.getSessionFactory().openSession();
        session.delete(o);
        session.flush();
    }

    @Override
    public T obterPorId(int id) {
        T objeto = null;
        if (id > 0) {
            session = getsession();
            Query select = session.createQuery(
                    "From " + clazz.getSimpleName() + " where id = " + id);
            objeto = (T) select.uniqueResult();
            session.flush();
        }
        return objeto;
    }

    @Override
    public List<T> listar(String filtro) {
        List<T> lista = null;
        if (filtro != null) {
            session = HibernateConfiguration.getSessionFactory().openSession();
            Query query = session.createQuery(filtro);
            lista = query.list();
            session.flush();
        }
        return lista;
    }

    @Override
    public List<T> listar() {
        session = HibernateConfiguration.getSessionFactory().openSession();
        Query query = session.createQuery("From " + clazz.getSimpleName());
        List<T> lista = query.list();
        session.flush();
        return lista;
    }
}
