/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Aluno
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "nomeCategoria", name = "UK_Categoria_NomeCategoria")
})
public class Categoria implements Serializable {

    @Id
    @GeneratedValue
    private Integer pkCategoria;

    @Column(length = 50, nullable = false)
    private String nomeCategoria;

    @Column(length = 8, nullable = false)
    private String tipo;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean controleVenda;

    public Integer getPkCategoria() {
        return pkCategoria;
    }

    public void setPkCategoria(Integer pkCategoria) {
        this.pkCategoria = pkCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getControleVenda() {
        return controleVenda;
    }

    public void setControleVenda(Boolean controleVenda) {
        this.controleVenda = controleVenda;
    }

}
