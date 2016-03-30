/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.NotNull;

/**
 *
 * @author Wanderson
 */
@Entity
@Table(catalog = "loja_joia", schema = "public")
@XmlRootElement
public class Usuario extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 32, nullable = false)
    private String senha;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private EStatusUsuario status;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EStatusUsuario getStatus() {
        return status;
    }

    public void setStatus(EStatusUsuario status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
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
        return "br.ifirst.karine.entities.Usuario[ id=" + id + " ]";
    }

}
