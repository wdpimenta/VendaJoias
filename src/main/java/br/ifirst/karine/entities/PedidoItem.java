/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Wanderson
 */
@Entity
@Table(name = "pedido_item", catalog = "loja_joia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoItem.findAll", query = "SELECT p FROM PedidoItem p"),
    @NamedQuery(name = "PedidoItem.findById", query = "SELECT p FROM PedidoItem p WHERE p.id = :id"),
    @NamedQuery(name = "PedidoItem.findByQuantidade", query = "SELECT p FROM PedidoItem p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "PedidoItem.findByValorTotal", query = "SELECT p FROM PedidoItem p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "PedidoItem.findByValorUnitario", query = "SELECT p FROM PedidoItem p WHERE p.valorUnitario = :valorUnitario")})
public class PedidoItem extends Entidade {

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

    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @ManyToOne
    private Pedido pedido;

    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne
    private Produto produto;

    @OneToMany(mappedBy = "pedidoItem", cascade = CascadeType.ALL)
    private Collection<PedidoItemBanho> pedidoItemBanhos;

    public PedidoItem() {
    }

    public PedidoItem(Long id) {
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Collection<PedidoItemBanho> getPedidoItemBanhos() {
        if (pedidoItemBanhos == null) {
            pedidoItemBanhos = new ArrayList<>();
        } else {
            for (PedidoItemBanho pedidoItemBanho : pedidoItemBanhos) {
                pedidoItemBanho.setPedidoItem(this);
            }
        }
        return pedidoItemBanhos;
    }

    public void setPedidoItemBanhos(Collection<PedidoItemBanho> pedidoItemBanhos) {
        this.pedidoItemBanhos = pedidoItemBanhos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.produto);
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
        return "br.ifirst.karine.entities.PedidoItem[ id=" + id + " ]";
    }

}
