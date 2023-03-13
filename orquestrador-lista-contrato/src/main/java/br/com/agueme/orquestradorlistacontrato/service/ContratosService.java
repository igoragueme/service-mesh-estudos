package br.com.agueme.orquestradorlistacontrato.service;

import br.com.agueme.orquestradorlistacontrato.integracao.client.ContratosClient;
import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratosService {

    private ContratosClient contratosClient;

    public ContratosService(ContratosClient contratosClient) {
        this.contratosClient = contratosClient;
    }

    public List<ContratosResponse> getContratos(String cpf, String canaryHeader, String serviceMeshHeader){
        List<ContratosResponse> contratosResponses;
        if(canaryHeader != null && serviceMeshHeader == null){
            contratosResponses = contratosClient.getContratos(cpf, canaryHeader).getBody();
        }else if(canaryHeader != null && serviceMeshHeader != null)
            contratosResponses = contratosClient.getContratos2(cpf, canaryHeader, serviceMeshHeader).getBody();

        else if(canaryHeader == null && serviceMeshHeader != null){
            contratosResponses = contratosClient.getContratos2(cpf, serviceMeshHeader).getBody();
        }else {
            contratosResponses = contratosClient.getContratos(cpf).getBody();
        }

        if(contratosResponses.isEmpty()){
            throw new RuntimeException("Cpf sem contrato");
        }

        return contratosResponses;
    }

}
