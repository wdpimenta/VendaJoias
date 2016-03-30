/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.relatorios;

import br.ifirst.karine.entities.Pedido;
import java.util.List;

/**
 *
 * @author Wanderson
 */
public class JPRPedidoDataSource extends JPRDataSource<Pedido>{

    public JPRPedidoDataSource(List<Pedido> list) {
        super(list);
    }

    
}
