package br.edu.ifpb.pos.service.autos.status.utils;

import br.edu.ifpb.pos.relatorio.entidades.OrdemServico;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class JsonUtils {

    public static <T> List<T> converterJsonEmLista(String json, T type){
        Type listType = new TypeToken<List<T>>() {}.getType();        
        List<T> result = (List<T>) new Gson().fromJson(json, listType);
        return result;
    }
    
    public static List<OrdemServico> converterJsonEmListaOrdemServico(String json){
        Type listType = new TypeToken<List<OrdemServico>>() {}.getType();        
        List<OrdemServico> result = (List<OrdemServico>) new Gson().fromJson(json, listType);
        return result;
    }
    
    public static OrdemServico converterJsonEmOrdemServico(String json){
        return new Gson().fromJson(json, OrdemServico.class);
    }
    
    public static <T> T converterJsonEmObjeto (String json, Class<T> type){
        return (T) new Gson().fromJson(json, type);
    }
    
    public static String converterObjectEmJson (Object src, Class type){
        return new Gson().toJson(src, type);
    }
    
}
