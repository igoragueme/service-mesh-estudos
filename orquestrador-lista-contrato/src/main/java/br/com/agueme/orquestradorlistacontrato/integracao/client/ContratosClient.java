package br.com.agueme.orquestradorlistacontrato.integracao.client;

import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "contratosClient", url = "${contratos.url}")
public interface ContratosClient {

    @GetMapping("/contratos")
    ResponseEntity<List<ContratosResponse>> getContratos(@RequestParam("cpf")String cpf);

    @GetMapping("/contratos")
    ResponseEntity<List<ContratosResponse>> getContratos(@RequestParam("cpf")String cpf,
                                                         @RequestHeader("canary") String canary);

    @GetMapping("/contratos")
    ResponseEntity<List<ContratosResponse>> getContratos2(@RequestParam("cpf")String cpf,
                                                         @RequestHeader("service-mesh") String servicemesh);

    @GetMapping("/contratos")
    ResponseEntity<List<ContratosResponse>> getContratos2(@RequestParam("cpf")String cpf,
                                                          @RequestHeader("canary") String canary,
                                                          @RequestHeader("service-mesh") String servicemesh);

}
