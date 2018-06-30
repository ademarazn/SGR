/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Aluno
 */
@Entity
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue
    private Integer pkItemPedido;

    @Column(nullable = false)
    private Integer qtdProduto;

    @Column(nullable = false)
    private Float precoVenda;

    @ManyToOne
    @JoinColumn(name = "fkPedido",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_ItemPedido_Pedido"))
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "fkProduto",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_ItemPedido_Produto"))
    private Produto produto;

    public Integer getPkItemPedido() {
        return pkItemPedido;
    }

    public void setPkItemPedido(Integer pkItemPedido) {
        this.pkItemPedido = pkItemPedido;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
