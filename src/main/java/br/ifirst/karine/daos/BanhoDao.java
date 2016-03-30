/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.daos;

import br.ifirst.karine.entities.Banho;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Wanderson
 */
public class BanhoDao extends AbstractDao<Long, Banho> {

    public List<Banho> findAllByNome(String nome) {

        TypedQuery<Banho> query = em.createNamedQuery("Banho.findAllByNome", entityClass);
        query.setParameter("nome", nome + "%");
        return query.getResultList();

    }

    public List<Banho> findAllBySigla(String sigla) {

        TypedQuery<Banho> query = em.createNamedQuery("Banho.findAllBySigla", entityClass);
        query.setParameter("sigla", sigla + "%");
        return query.getResultList();

    }

    public Banho findBySigla(String sigla) {

        TypedQuery<Banho> query = em.createNamedQuery("Banho.findBySigla", entityClass);
        query.setParameter("sigla", sigla);
        return query.getSingleResult();

    }
}
