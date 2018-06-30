/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Categoria;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aluno
 */
public class CategoriaDAO {

    public void incluir(Categoria categoria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(categoria);
        transacao.commit();
        sessao.close();
    }

    public Categoria consultarPorCodigo(int pkCategoria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Categoria.class);
        criterio.add(Restrictions.eq("pkCategoria", pkCategoria));
        Categoria categoria = (Categoria) criterio.uniqueResult();
        sessao.close();
        return categoria;
    }

    public List<Categoria> consultarTudoOrdenado() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Categoria.class);
        List<Categoria> categorias = criterio.list();
        sessao.close();
        return categorias;
    }

    public List<Categoria> consultarPorNome(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Categoria.class);
        criterio.add(Restrictions.like("nomeCategoria", nome + "%"));
        criterio.addOrder(Order.asc("nomeCategoria"));
        List<Categoria> categorias = criterio.list();
        sessao.close();
        return categorias;
    }

    public List<Categoria> consultarPorTipo(String tipo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Categoria.class);
        criterio.add(Restrictions.like("tipo", tipo));
        criterio.addOrder(Order.asc("nomeCategoria"));
        List<Categoria> categorias = criterio.list();
        sessao.close();
        return categorias;
    }

    public Categoria consultarPorNomeUk(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Categoria.class);
        criterio.add(Restrictions.eq("nomeCategoria", nome));
        Categoria categoria = (Categoria) criterio.uniqueResult();
        sessao.close();
        return categoria;
    }

    public void alterar(Categoria categoria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.update(categoria);
        transacao.commit();
        sessao.close();
    }

}
