/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.NotNull;

/**
 *
 * @author Wanderson
 */
@Entity
@Table(catalog = "loja_joia", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"),
    @NamedQuery(name = "Pedido.findByDataCadastro", query = "SELECT p FROM Pedido p WHERE p.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Pedido.findByValorTotal", query = "SELECT p FROM Pedido p WHERE p.valorTotal = :valorTotal")})
public class Pedido extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total", precision = 19, scale = 2)
    private BigDecimal valorTotal;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne
    @NotNull
    private Cliente cliente;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private EStatus status;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @NotNull
    private Collection<PedidoItem> pedidoItens;

    public Pedido() {
    }

    public Pedido(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<PedidoItem> getPedidoItens() {
        if (pedidoItens == null) {
            pedidoItens = new ArrayList<>();
        } else {
            for (PedidoItem pedidoIten : pedidoItens) {
                pedidoIten.setPedido(this);
            }
        }
        return pedidoItens;
    }

    public void setPedidoItens(Collection<PedidoItem> pedidoItens) {
        this.pedidoItens = pedidoItens;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        return this.hashCode() == object.hashCode();
    }

    @Override
    public String toString() {
        return "br.ifirst.karine.entities.Pedido[ id=" + id + " ]";
    }

}
