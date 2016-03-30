/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.daos;

import br.ifirst.karine.entities.Cliente;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Wanderson
 */
public class ClienteDao extends AbstractDao<Long, Cliente> {

    public List<Cliente> findAllByCnpjCpf(String cpfcnpj) {

        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAllByCnpjCpf", entityClass);
        query.setParameter("cnpjCpf", cpfcnpj + "%");
        return query.getResultList();

    }

    public List<Cliente> findAllByNome(String nome) {

        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAllByNome", entityClass);
        query.setParameter("nome", nome + "%");
        return query.getResultList();

    }
    
    public List<Cliente> findAllByTelefone(String telefone) {

        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findAllByTelefone", entityClass);
        query.setParameter("telefone", telefone + "%");
        return query.getResultList();

    }
}
