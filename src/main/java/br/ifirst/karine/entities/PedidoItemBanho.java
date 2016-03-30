/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.entities;

import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wanderson
 */
@Entity
@Table(name = "pedido_item_banho", catalog = "loja_joia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoItemBanho.findAll", query = "SELECT p FROM PedidoItemBanho p"),
    @NamedQuery(name = "PedidoItemBanho.findById", query = "SELECT p FROM PedidoItemBanho p WHERE p.id = :id"),
    @NamedQuery(name = "PedidoItemBanho.findByQuantidade", query = "SELECT p FROM PedidoItemBanho p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "PedidoItemBanho.findByValorTotal", query = "SELECT p FROM PedidoItemBanho p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "PedidoItemBanho.findByValorUnitario", query = "SELECT p FROM PedidoItemBanho p WHERE p.valorUnitario = :valorUnitario")})
public class PedidoItemBanho extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 9, scale = 2)
    private BigDecimal quantidade = BigDecimal.ZERO;
    @Column(name = "valor_total", precision = 19, scale = 2)
    private BigDecimal valorTotal = BigDecimal.ZERO;
    @Column(name = "valor_unitario", precision = 19, scale = 2)
    private BigDecimal valorUnitario = BigDecimal.ZERO;

    @JoinColumn(name = "produto_banho_id", referencedColumnName = "id")
    @ManyToOne
    private ProdutoBanho produtoBanho;
    
    @JoinColumn(name = "pedido_item_id", referencedColumnName = "id")
    @ManyToOne
    private PedidoItem pedidoItem;

    public PedidoItemBanho() {
    }

    public PedidoItemBanho(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public ProdutoBanho getProdutoBanho() {
        return produtoBanho;
    }

    public void setProdutoBanho(ProdutoBanho produtoBanho) {
        this.produtoBanho = produtoBanho;
    }

    public PedidoItem getPedidoItem() {
        return pedidoItem;
    }

    public void setPedidoItem(PedidoItem pedidoItem) {
        this.pedidoItem = pedidoItem;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.produtoBanho);
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
        return "br.ifirst.karine.entities.PedidoItemBanho[ id=" + id + " ]";
    }

}
