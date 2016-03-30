/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.daos;

import br.ifirst.karine.entities.Produto;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Wanderson
 */
public class ProdutoDao extends AbstractDao<Long, Produto> {

    public List<Produto> findAllByNome(String nome) {

        TypedQuery<Produto> query = em.createNamedQuery("Produto.findAllByNome", entityClass);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();

    }

    public Produto findByReferencia(String referencia) {

        try {
            TypedQuery<Produto> query = em.createNamedQuery("Produto.findByReferencia", entityClass);
            query.setParameter("referencia", referencia);

            return query.getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }

    }

    public List<Produto> findAllByReferencia(String referencia) {

        try {
            TypedQuery<Produto> query = em.createNamedQuery("Produto.findAllByReferencia", entityClass);
            query.setParameter("referencia", "%" + referencia + "%");

            return query.getResultList();
        } catch (NoResultException exception) {
            return null;
        }

    }

}
