/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Pedido;
import Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aluno
 */
public class PedidoDAO {

    public void incluir(Pedido pedido) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(pedido);
        transacao.commit();
        sessao.close();
    }

    public Pedido consultarPedidoAtivoPorComanda(int comanda) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Pedido.class);
        criterio.add(Restrictions.eq("comanda", comanda));
        criterio.add(Restrictions.eq("status", true));
        Pedido pedido = (Pedido) criterio.uniqueResult();
        sessao.close();
        return pedido;
    }

    public void alterar(Pedido pedido) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.update(pedido);
        transacao.commit();
        sessao.close();
    }

}
