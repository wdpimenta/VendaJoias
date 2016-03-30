/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.entities;

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
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByBairro", query = "SELECT c FROM Cliente c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "Cliente.findByCep", query = "SELECT c FROM Cliente c WHERE c.cep = :cep"),
    @NamedQuery(name = "Cliente.findByCelular", query = "SELECT c FROM Cliente c WHERE c.celular = :celular"),
    @NamedQuery(name = "Cliente.findByCidade", query = "SELECT c FROM Cliente c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "Cliente.findByCnpjCpf", query = "SELECT c FROM Cliente c WHERE c.cnpjCpf = :cnpjCpf"),
    @NamedQuery(name = "Cliente.findAllByCnpjCpf", query = "SELECT c FROM Cliente c WHERE c.cnpjCpf like :cnpjCpf"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByEndereco", query = "SELECT c FROM Cliente c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findAllByNome", query = "SELECT c FROM Cliente c WHERE c.nome like :nome"),
    @NamedQuery(name = "Cliente.findByRgInscEst", query = "SELECT c FROM Cliente c WHERE c.rgInscEst = :rgInscEst"),
    @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Cliente.findAllByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone like :telefone or c.celular like :telefone"),
    @NamedQuery(name = "Cliente.findByUf", query = "SELECT c FROM Cliente c WHERE c.uf = :uf")})
public class Cliente extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Column(length = 60)
    private String bairro;
    @Column(length = 8)
    private String cep;
    @Column(length = 11)
    private String celular;
    @Column(length = 60)
    private String cidade;
    @Column(name = "cnpj_cpf", length = 14)
    @NotNull
    private String cnpjCpf;
    @Column(length = 255)
    private String email;
    @Column(length = 120)
    private String endereco;
    @Column(length = 100)
    @NotNull
    private String nome;
    @Column(name = "rg_insc_est", length = 15)
    private String rgInscEst;
    @Column(length = 11)
    private String telefone;
    @Column(length = 2)
    private String uf;
    @OneToMany(mappedBy = "cliente")
    private Collection<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRgInscEst() {
        return rgInscEst;
    }

    public void setRgInscEst(String rgInscEst) {
        this.rgInscEst = rgInscEst;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @XmlTransient

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Collection<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Collection<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        return this.hashCode() == object.hashCode();
    }

    @Override
    public String toString() {
        return nome;
    }

}
