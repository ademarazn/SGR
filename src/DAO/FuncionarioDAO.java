/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Funcionario;
import Util.HibernateUtil;
import java.util.Date;
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
public class FuncionarioDAO {

    public void incluir(Funcionario func) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.save(func);
        transacao.commit();
        sessao.close();
    }

    public List<Funcionario> consultarTudoOrdenado() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Funcionario.class);
        criterio.addOrder(Order.asc("nomeFunc"));
        criterio.addOrder(Order.asc("cpf"));
        List<Funcionario> funcionarios = criterio.list();
        sessao.close();
        return funcionarios;
    }

    public Funcionario consultarPorCpf(String cpf) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Funcionario.class);
        criterio.add(Restrictions.eq("cpf", cpf));
        Funcionario funcionario = (Funcionario) criterio.uniqueResult();
        sessao.close();
        return funcionario;
    }

    public Funcionario consultarPorRg(String rg) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Funcionario.class);
        criterio.add(Restrictions.eq("rg", rg));
        Funcionario funcionario = (Funcionario) criterio.uniqueResult();
        sessao.close();
        return funcionario;
    }

    public Funcionario consultarPorLogin(String login) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Funcionario.class);
        criterio.add(Restrictions.eq("login", login));
        Funcionario funcionario = (Funcionario) criterio.uniqueResult();
        sessao.close();
        return funcionario;
    }

    public List<Funcionario> consultarPorNome(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Funcionario.class);
        criterio.add(Restrictions.like("nomeFunc", nome + "%"));
        criterio.addOrder(Order.asc("nomeFunc"));
        criterio.addOrder(Order.asc("cpf"));
        List<Funcionario> funcionarios = criterio.list();
        sessao.close();
        return funcionarios;
    }

    public List<Funcionario> consultarPorPeriodo(Date ini, Date fim) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Funcionario.class);
        criterio.add(Restrictions.between("dtContratacao", ini, fim));
        criterio.addOrder(Order.asc("nomeFunc"));
        criterio.addOrder(Order.asc("cpf"));
        List<Funcionario> funcionarios = criterio.list();
        sessao.close();
        return funcionarios;
    }

    public void alterar(Funcionario func) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.update(func);
        transacao.commit();
        sessao.close();
    }

    public Funcionario validarLogin(String login, String senha) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Funcionario.class);
        criterio.add(Restrictions.eq("login", login));
        criterio.add(Restrictions.eq("senha", senha));
        Funcionario funcionario = (Funcionario) criterio.uniqueResult();
        sessao.close();
        return funcionario;
    }

}
