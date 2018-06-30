/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Cliente;
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
public class ClienteDAO {

    public void incluir(Cliente cliente) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(cliente);
        transacao.commit();
        sessao.close();
    }

    public Cliente consultarPorCodigo(int pkCliente) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = (Cliente) sessao.get(Cliente.class, pkCliente);
        sessao.close();
        return cliente;
    }

    public List<Cliente> consultarTudoOrdenado() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Cliente.class);
        List<Cliente> clientes = criterio.list();
        sessao.close();
        return clientes;
    }

    public List<Cliente> consultarPorNome(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Cliente.class);
        criterio.add(Restrictions.like("nomeCliente", nome + "%"));
        criterio.addOrder(Order.asc("nomeCliente"));
        List<Cliente> clientes = criterio.list();
        sessao.close();
        return clientes;
    }

    public Cliente consultarPorCpf(String cpf) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Cliente.class);
        criterio.add(Restrictions.eq("cpf", cpf));
        Cliente cliente = (Cliente) criterio.uniqueResult();
        sessao.close();
        return cliente;
    }

    public Cliente consultarPorRg(String rg) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Cliente.class);
        criterio.add(Restrictions.eq("rg", rg));
        Cliente cliente = (Cliente) criterio.uniqueResult();
        sessao.close();
        return cliente;
    }

    public void alterar(Cliente cliente) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.update(cliente);
        transacao.commit();
        sessao.close();
    }

}
