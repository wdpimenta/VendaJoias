/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.entities;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wanderson
 */
@Entity
@Table(name = "produto_banho", catalog = "loja_joia", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"banho_id", "produto_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoBanho.findAll", query = "SELECT p FROM ProdutoBanho p"),
    @NamedQuery(name = "ProdutoBanho.findById", query = "SELECT p FROM ProdutoBanho p WHERE p.id = :id")})
public class ProdutoBanho extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @JoinColumn(name = "banho_id", referencedColumnName = "id")
    @ManyToOne
    private Banho banho;
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne
    private Produto produto;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total", precision = 19, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "gramas", precision = 19, scale = 4)
    private BigDecimal gramas;

    @OneToMany(mappedBy = "produtoBanho")
    private Collection<PedidoItemBanho> pedidoItemBanhos;

    public ProdutoBanho() {
    }

    public ProdutoBanho(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Banho getBanho() {
        return banho;
    }

    public void setBanho(Banho banho) {
        this.banho = banho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getGramas() {
        return gramas;
    }

    public void setGramas(BigDecimal gramas) {
        this.gramas = gramas;
    }

    @XmlTransient
    public Collection<PedidoItemBanho> getPedidoItemBanhos() {
        return pedidoItemBanhos;
    }

    public void setPedidoItemBanhos(Collection<PedidoItemBanho> pedidoItemBanhos) {
        this.pedidoItemBanhos = pedidoItemBanhos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.banho);
        hash = 89 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return banho.toString();
    }

}
