/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.relatorios;

import br.ifirst.karine.entities.PedidoItemBanho;
import java.util.List;

/**
 *
 * @author Wanderson
 */
public class JPRPeditoItemBanhoDataSource extends JPRDataSource<PedidoItemBanho>{
    
    public JPRPeditoItemBanhoDataSource(List<PedidoItemBanho> list) {
        super(list);
    }
    
}
