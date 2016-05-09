/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.controle.financeiro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Emanuel Batista da Silva Filho - https://github.com/emanuelbatista
 */
public class DataUtil {
    
    public static Date convertData(String data) throws ParseException{
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.parse(data);
    }
}
