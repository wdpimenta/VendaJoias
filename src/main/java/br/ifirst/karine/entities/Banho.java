/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Banho.findAll", query = "SELECT b FROM Banho b"),
    @NamedQuery(name = "Banho.findById", query = "SELECT b FROM Banho b WHERE b.id = :id"),
    @NamedQuery(name = "Banho.findByNome", query = "SELECT b FROM Banho b WHERE b.nome = :nome"),
    @NamedQuery(name = "Banho.findAllByNome", query = "SELECT b FROM Banho b WHERE b.nome like :nome"),
    @NamedQuery(name = "Banho.findBySigla", query = "SELECT b FROM Banho b WHERE b.sigla = :sigla"),
    @NamedQuery(name = "Banho.findAllBySigla", query = "SELECT b FROM Banho b WHERE b.sigla like :sigla"),
    @NamedQuery(name = "Banho.findByValorGrama", query = "SELECT b FROM Banho b WHERE b.valorGrama = :valorGrama")})
public class Banho extends Entidade {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @NotNull
    @Column(length = 30)
    private String nome;
    @Column(length = 2)
    @NotNull
    private String sigla;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_grama", precision = 19, scale = 4)
    @NotNull
    private BigDecimal valorGrama;
    @OneToMany(mappedBy = "banho")
    private Collection<ProdutoBanho> produtoBanhoCollection;

    public Banho() {
    }

    public Banho(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public BigDecimal getValorGrama() {
        return valorGrama;
    }

    public void setValorGrama(BigDecimal valorGrama) {
        this.valorGrama = valorGrama;
    }

    @XmlTransient
    public Collection<ProdutoBanho> getProdutoBanhoCollection() {
        return produtoBanhoCollection;
    }

    public void setProdutoBanhoCollection(Collection<ProdutoBanho> produtoBanhoCollection) {
        this.produtoBanhoCollection = produtoBanhoCollection;
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
        if (!(object instanceof Banho)) {
            return false;
        }
        return this.hashCode() == object.hashCode();
    }

    @Override
    public String toString() {
        return  sigla + "-" + nome;
    }

}
