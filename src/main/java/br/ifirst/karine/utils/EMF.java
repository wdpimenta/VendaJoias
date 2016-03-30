/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifirst.karine.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Wanderson
 */
public final class EMF {

    private static EntityManagerFactory emfInstance = null;

    private EMF() {
    }

    public static EntityManagerFactory get() {

        if (emfInstance == null) {
            set();
        }

        return emfInstance;
    }

    private static void set() {
        emfInstance = Persistence.createEntityManagerFactory("karine.0PU", Util.getPropertiesDB());
    }

}
