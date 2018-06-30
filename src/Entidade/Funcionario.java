/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Aluno
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "cpf", name = "UK_Funcionario_Cpf"),
    @UniqueConstraint(columnNames = "rg", name = "UK_Funcionario_Rg"),
    @UniqueConstraint(columnNames = "login", name = "UK_Funcionario_Login")
})
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private Integer pkFuncionario;

    @Column(length = 50, nullable = false)
    private String nomeFunc;

    @Column(length = 11, nullable = false)
    private String cpf;

    @Column(length = 9, nullable = false)
    private String rg;

    @Column(length = 50)
    private String cargo;

    @Column(nullable = true)
    private Float salario;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtContratacao;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean status;

    @Column(length = 16, nullable = false)
    private String login;

    @Column(length = 16, nullable = false)
    private String senha;

    public Integer getPkFuncionario() {
        return pkFuncionario;
    }

    public void setPkFuncionario(Integer pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Date getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(Date dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
