/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.util;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ClassesModelUtil {

    public static <T> void preencherCamposNotNull(T update, T model, Class<T> clazz) {
        try {
            for (Field campo : clazz.getDeclaredFields()) {
                campo.setAccessible(true);
                Object value = campo.get(update);
                if (value != null) {
                    campo.set(model, value);
                }
            }
            Class superClazz = clazz.getSuperclass();
            while (superClazz != null) {
                for (Field campo : superClazz.getDeclaredFields()) {
                    campo.setAccessible(true);
                    Object value = campo.get(update);
                    if (value != null) {
                        campo.set(model, value);
                    }
                }
                superClazz = superClazz.getSuperclass();
            }
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(ClassesModelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
