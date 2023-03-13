package br.com.agueme.orquestradorlistacontrato.integracao.client;

import br.com.agueme.orquestradorlistacontrato.integracao.request.ContratosRenegociaveisRequest;
import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosRenegociaveisResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "politicasClient", url = "${politicas.url}")
public interface PoliticasClient {

    @PostMapping("/contratos_renegociaveis")
    ResponseEntity<List<ContratosRenegociaveisResponse>> getContratosRenegociaveis(List<ContratosRenegociaveisRequest> contratosRenegociaveisRequest);

    @PostMapping("/contratos_renegociaveis")
    ResponseEntity<List<ContratosRenegociaveisResponse>> getContratosRenegociaveis(@RequestBody List<ContratosRenegociaveisRequest> contratosRenegociaveisRequest,
                                                                                   @RequestHeader("canary") String canary);

    @PostMapping("/contratos_renegociaveis")
    ResponseEntity<List<ContratosRenegociaveisResponse>> getContratosRenegociaveis2(@RequestBody List<ContratosRenegociaveisRequest> contratosRenegociaveisRequest,
                                                                                    @RequestHeader("service-mesh") String serviceMesh);

    @PostMapping("/contratos_renegociaveis")
    ResponseEntity<List<ContratosRenegociaveisResponse>> getContratosRenegociaveis2(@RequestBody List<ContratosRenegociaveisRequest> contratosRenegociaveisRequest,
                                                                                    @RequestHeader("canary") String canary,
                                                                                    @RequestHeader("service-mesh") String serviceMesh);

}
