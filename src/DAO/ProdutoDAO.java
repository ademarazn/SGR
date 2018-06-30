/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Produto;
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
public class ProdutoDAO {

    public void incluir(Produto produto) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(produto);
        transacao.commit();
        sessao.close();
    }

    public Produto consultarPorCodigo(int pkProduto, boolean apenasAtivo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Produto.class);
        criterio.add(Restrictions.idEq(pkProduto));
        if (apenasAtivo) {
            criterio.add(Restrictions.eq("status", true));
        }
        Produto produto = (Produto) criterio.uniqueResult();
        sessao.close();
        return produto;
    }

    public List<Produto> consultarTudoOrdenado(boolean apenasAtivo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Produto.class);
        if (apenasAtivo) {
            criterio.add(Restrictions.eq("status", true));
        }
        criterio.addOrder(Order.asc("nomeProduto"));
        List<Produto> produtos = criterio.list();
        sessao.close();
        return produtos;
    }

    public List<Produto> consultarPorNome(String nome, boolean apenasAtivo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Produto.class);
        criterio.add(Restrictions.like("nomeProduto", nome + "%"));
        if (apenasAtivo) {
            criterio.add(Restrictions.eq("status", true));
        }
        criterio.addOrder(Order.asc("nomeProduto"));
        List<Produto> produtos = criterio.list();
        sessao.close();
        return produtos;
    }

    public Produto consultarPorNomeUk(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Produto.class);
        criterio.add(Restrictions.eq("nomeProduto", nome));
        Produto produto = (Produto) criterio.uniqueResult();
        sessao.close();
        return produto;
    }

    public void alterar(Produto produto) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.update(produto);
        transacao.commit();
        sessao.close();
    }

}
