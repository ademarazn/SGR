/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.ItemPedido;
import Util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aluno
 */
public class ItemPedidoDAO {

    public void incluir(ItemPedido itemPedido) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(itemPedido);
        transacao.commit();
        sessao.close();
    }

    public ItemPedido consultarPorCodigo(int pkItemPedido) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        ItemPedido itemPedido = (ItemPedido) sessao.get(ItemPedido.class, pkItemPedido);
        sessao.close();
        return itemPedido;
    }

    public List<ItemPedido> consultarPorPedido(int pkPedido) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(ItemPedido.class);
        criterio.createAlias("pedido", "p");
        criterio.add(Restrictions.eq("p.pkPedido", pkPedido));
        criterio.addOrder(Order.asc("pkItemPedido"));
        List<ItemPedido> itensPedido = criterio.list();
        sessao.close();
        return itensPedido;
    }

    public List<Object> consultarPorPeriodo(Date ini, Date fim) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(ItemPedido.class);
        criterio.createAlias("pedido", "p");
        criterio.createAlias("produto", "prod");
        criterio.add(Restrictions.between("p.dtPedido", ini, fim));
        criterio.setProjection(Projections.projectionList()
                .add(Projections.property("prod.pkProduto"))
                .add(Projections.groupProperty("prod.nomeProduto"))
                .add(Projections.sum("qtdProduto"))
                .add(Projections.property("precoVenda")));
        criterio.addOrder(Order.asc("prod.nomeProduto"));
        List<Object> itensPedido = criterio.list();
        sessao.close();
        return itensPedido;
    }

    public void alterar(ItemPedido itemPedido) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.update(itemPedido);
        transacao.commit();
        sessao.close();
    }

    public void excluir(ItemPedido itemPedido) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.delete(itemPedido);
        transacao.commit();
        sessao.close();
    }

}
