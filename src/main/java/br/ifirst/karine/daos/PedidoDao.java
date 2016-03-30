/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.daos;

import br.ifirst.karine.entities.Cliente;
import br.ifirst.karine.entities.EStatus;
import br.ifirst.karine.entities.Pedido;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Wanderson
 */
public class PedidoDao extends AbstractDao<Long, Pedido> {

    public List<Pedido> findAllByCliente(long cdCliente) {
        return findAllByClienteAndDtIniAndDtFimAndStatus(cdCliente, null, null, null);
    }

    public List<Pedido> findAllByClienteAndStatus(long cdCliente, EStatus status) {
        return findAllByClienteAndDtIniAndDtFimAndStatus(cdCliente, null, null, status);
    }

    public List<Pedido> findAllByClienteAndDtIniAndStatus(long cdCliente, Date dtIni, EStatus status) {
        return findAllByClienteAndDtIniAndDtFimAndStatus(cdCliente, dtIni, null, status);
    }

    public List<Pedido> findAllByClienteAndDtIni(long cdCliente, Date dtIni) {
        return findAllByClienteAndDtIniAndDtFimAndStatus(cdCliente, dtIni, null, null);
    }

    public List<Pedido> findAllByClienteAndDtFimAndStatus(long cdCliente, Date dtFim, EStatus status) {
        return findAllByClienteAndDtIniAndDtFimAndStatus(cdCliente, null, dtFim, status);
    }

    public List<Pedido> findAllByClienteAndDtFim(long cdCliente, Date dtFim) {
        return findAllByClienteAndDtIniAndDtFimAndStatus(cdCliente, null, dtFim, null);
    }

    public List<Pedido> findAllByClienteAndDtIniAndDtFim(long cdCliente, Date dtIni, Date dtFim) {
        return findAllByClienteAndDtIniAndDtFimAndStatus(cdCliente, dtIni, dtFim, null);
    }

    public List<Pedido> findAllByClienteAndDtIniAndDtFimAndStatus(long cdCliente, Date dtIni, Date dtFim, EStatus status) {

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Pedido as p WHERE NOT p.cliente IS NULL ");

        if (cdCliente > 0L) {
            sb.append("AND p.cliente = :cliente ");
        }
        
        if (dtFim != null && dtIni != null) {
            sb.append("AND p.dataCadastro BETWEEN :dataCadastroIni AND :dataCadastroFim ");
        } else if (dtFim == null && dtIni != null) {
            sb.append("AND p.dataCadastro >= :dataCadastroIni ");
        } else if (dtFim != null && dtIni == null) {
            sb.append("AND p.dataCadastro <= :dataCadastroFim ");
        }

        if (status != null) {
            sb.append("AND p.status = :status ");
        }

        

        TypedQuery<Pedido> query = em.createQuery(sb.toString(), entityClass);

        if (cdCliente > 0L) {
            query.setParameter("cliente", new Cliente(cdCliente));
        }

        if (dtFim != null && dtIni != null) {
            query.setParameter("dataCadastroIni", dtIni);
            query.setParameter("dataCadastroFim", dtFim);
        } else if (dtFim == null && dtIni != null) {
            query.setParameter("dataCadastroIni", dtIni);
        } else if (dtFim != null && dtIni == null) {
            query.setParameter("dataCadastroFim", dtFim);
        }

        if (status != null) {
            query.setParameter("status", status);
        }

        return query.getResultList();

    }
}
