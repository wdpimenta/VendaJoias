/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.daos;

import java.util.List;

/**
 *
 * @author Wanderson
 * @param <PK>
 * @param <T>
 */
public interface IDao<PK, T> {

    public void create(T entity);

    public void edit(T entity);

    public void remove(T entity);

    public T find(PK id);

    public List<T> findAll();

    public List<T> findRange(int[] range);

    public long count();
}
