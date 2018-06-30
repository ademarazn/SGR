/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Empresa;
import Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aluno
 */
public class EmpresaDAO {

    public Empresa consultar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criterio = sessao.createCriteria(Empresa.class);
        Empresa empresa = (Empresa) criterio.uniqueResult();
        sessao.close();
        return empresa;
    }

    public void alterar(Empresa empresa) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = sessao.beginTransaction();
        sessao.update(empresa);
        transacao.commit();
        sessao.close();
    }

}
