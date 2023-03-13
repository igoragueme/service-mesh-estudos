package br.com.agueme.orquestradorlistacontrato.facade;

import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosRenegociaveisResponse;
import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosResponse;
import br.com.agueme.orquestradorlistacontrato.service.ContratosService;
import br.com.agueme.orquestradorlistacontrato.service.PoliticasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrquestradorContratosFacade {

    private ContratosService contratosService;
    private PoliticasService politicasService;

    public OrquestradorContratosFacade(ContratosService contratosService, PoliticasService politicasService) {
        this.contratosService = contratosService;
        this.politicasService = politicasService;
    }

    public List<ContratosResponse> orquestraContratos(String cpf, String canaryHeader, String serviceMeshHeader){
        List<ContratosResponse> contratos = this.contratosService.getContratos(cpf, canaryHeader, serviceMeshHeader);

        Map<String, List<ContratosResponse>> contratosMap =
                contratos.stream()
                        .collect(Collectors.groupingBy(contrato -> contrato.getCodigoProduto() + contrato.getNumeroContrato()));

        List<ContratosRenegociaveisResponse> contratosRenegociaveis = politicasService.getContratosRenegociaveis(contratos, canaryHeader, serviceMeshHeader);

        return contratosRenegociaveis.stream()
                .filter(contrato -> contrato.isRenegociavel())
                .map(contratoRenegociavel -> contratosMap.get(contratoRenegociavel.getCodigoProduto() + contratoRenegociavel.getNumeroContrato()).stream().findFirst().get())
                .collect(Collectors.toList());
    }

}
