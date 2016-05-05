/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.validacao;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class ValidadorBeans {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validar(T bean, Class<?>... grupos) throws ValidationException{
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean, grupos);
        if (!constraintViolations.isEmpty()) {
            StringBuilder descricao = new StringBuilder();
            ConstraintViolation<T> constraintViolation = constraintViolations.iterator().next();
            descricao.append("Objeto Inválido: ");
            descricao.append("A propriedade '")
                    .append(constraintViolation.getPropertyPath().toString())
                    .append("' está inválida contém o seguinte erro: ")
                    .append(constraintViolation.getMessage());
            throw new javax.validation.ValidationException(descricao.toString());
        }
    }
}
