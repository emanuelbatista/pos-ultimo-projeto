package br.edu.ifpb.pos.relatorio.resources;

import br.edu.ifpb.pos.relatorio.entidades.ContaPagamento;
import br.edu.ifpb.pos.relatorio.service.RelatorioService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class ContaPagamentoPorDataResource extends ServerResource {

    private RelatorioService relatorioService = new RelatorioService();

    @Get("json")
    public ContaPagamento[] getResource() throws ParseException {
        String dataTexto = getAttribute("data");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date data = dateFormat.parse(dataTexto);
        return relatorioService.getRelatorioContaPagamentoPorData(data);
    }

}
