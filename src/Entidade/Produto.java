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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Aluno
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "nomeProduto", name = "UK_Produto_NomeProduto")
})
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private Integer pkProduto;

    @Column(length = 50, nullable = false)
    private String nomeProduto;

    @Column(nullable = false)
    private Float precoVenda;

    @Column(length = 50)
    private String fornecedor;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "fkCategoria",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_Produto_Categoria"))
    private Categoria categoria;

    public Integer getPkProduto() {
        return pkProduto;
    }

    public void setPkProduto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getPreco() {
        return precoVenda;
    }

    public void setPreco(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
