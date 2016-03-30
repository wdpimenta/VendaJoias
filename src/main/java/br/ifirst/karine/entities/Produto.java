/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.entities;

import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByReferencia", query = "SELECT p FROM Produto p WHERE p.referencia = :referencia"),
    @NamedQuery(name = "Produto.findByComprimento", query = "SELECT p FROM Produto p WHERE p.comprimento = :comprimento"),
    @NamedQuery(name = "Produto.findByLargura", query = "SELECT p FROM Produto p WHERE p.largura = :largura"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findAllByNome", query = "SELECT p FROM Produto p WHERE p.nome like :nome"),
    @NamedQuery(name = "Produto.findAllByReferencia", query = "SELECT p FROM Produto p WHERE p.referencia like :referencia")})
public class Produto extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 19, scale = 1)
    @NotNull
    private BigDecimal comprimento;
    @Lob
    private byte[] foto;
    @Column(precision = 19, scale = 1)
    @NotNull
    private BigDecimal largura;
    @Column(length = 15, unique = true)
    @NotNull
    private String referencia;
    @Column(length = 100)
    @NotNull
    private String nome;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Collection<ProdutoBanho> produtoBanhos;

    public Produto() {
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getComprimento() {
        return comprimento;
    }

    public void setComprimento(BigDecimal comprimento) {
        this.comprimento = comprimento;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<ProdutoBanho> getProdutoBanhos() {
        for (ProdutoBanho produtoBanho : produtoBanhos) {
            produtoBanho.setProduto(this);
        }
        return produtoBanhos;
    }

    public void setProdutoBanhos(Collection<ProdutoBanho> produtoBanhos) {
        this.produtoBanhos = produtoBanhos;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        return this.hashCode() == object.hashCode();
    }

    @Override
    public String toString() {
        return id + "-" + nome;
    }

}
