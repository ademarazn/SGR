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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aluno
 */
@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private Integer pkPedido;

    @Column(nullable = false)
    private Integer comanda;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtPedido;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean status;

    @Column(length = 150)
    private String obs;

    @ManyToOne
    @JoinColumn(name = "fkCliente",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_Pedido_Cliente"))
    private Cliente cliente;

    public Integer getPkPedido() {
        return pkPedido;
    }

    public void setPkPedido(Integer pkPedido) {
        this.pkPedido = pkPedido;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getComanda() {
        return comanda;
    }

    public void setComanda(Integer comanda) {
        this.comanda = comanda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
