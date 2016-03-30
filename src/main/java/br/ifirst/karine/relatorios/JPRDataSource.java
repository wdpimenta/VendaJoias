/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.relatorios;

import br.ifirst.karine.utils.ReflectionUtil;
import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Wanderson
 * @param <T>
 */
public abstract class JPRDataSource<T> implements JRDataSource {

    private final Iterator<T> iterator;

    private T beanCorrente;

    public JPRDataSource(List<T> list) {
        this.iterator = list.iterator();
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        Object bean = beanCorrente;

        return ReflectionUtil.getFieldValue(bean, field.getName());
    }

    @Override
    public boolean next() throws JRException {
        boolean retorno = iterator.hasNext();
        if (retorno) {
            beanCorrente = iterator.next();
        }
        return retorno;
    }
    
}
