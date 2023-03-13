package br.com.agueme.orquestradorlistacontrato.service;

import br.com.agueme.orquestradorlistacontrato.integracao.client.PoliticasClient;
import br.com.agueme.orquestradorlistacontrato.integracao.request.ContratosRenegociaveisRequest;
import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosRenegociaveisResponse;
import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoliticasService {

    private PoliticasClient politicaClient;

    public PoliticasService(PoliticasClient politicaClient) {
        this.politicaClient = politicaClient;
    }

    public List<ContratosRenegociaveisResponse> getContratosRenegociaveis(List<ContratosResponse> contratosResponses,
                                                                          String canaryHeader,
                                                                          String serviceMeshHeader){
        List<ContratosRenegociaveisRequest> contratosRenegociaveisRequestList = contratosResponses.stream()
                .map(ContratosRenegociaveisRequest::new)
                .collect(Collectors.toList());

        if(canaryHeader != null && serviceMeshHeader == null){
            return politicaClient.getContratosRenegociaveis(contratosRenegociaveisRequestList, canaryHeader).getBody();
        }else if(canaryHeader != null && serviceMeshHeader != null)
            return politicaClient.getContratosRenegociaveis2(contratosRenegociaveisRequestList, canaryHeader, serviceMeshHeader).getBody();
        else if(canaryHeader == null && serviceMeshHeader != null){
            return politicaClient.getContratosRenegociaveis2(contratosRenegociaveisRequestList, serviceMeshHeader).getBody();
        }else {
            return politicaClient.getContratosRenegociaveis(contratosRenegociaveisRequestList).getBody();
        }
    }

}
