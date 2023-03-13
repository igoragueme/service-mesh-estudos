package br.com.agueme.orquestradorlistacontrato.controller;

import br.com.agueme.orquestradorlistacontrato.facade.OrquestradorContratosFacade;
import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrquestradorController {

    private final Logger logger = LoggerFactory.getLogger(OrquestradorController.class);

    private OrquestradorContratosFacade orquestradorContratosFacade;

    public OrquestradorController(OrquestradorContratosFacade orquestradorContratosFacade) {
        this.orquestradorContratosFacade = orquestradorContratosFacade;
    }

    @GetMapping("/v1/contratos")
    public ResponseEntity<List<ContratosResponse>> getContratos(@RequestParam("cpf")String cpf,
                                                                @RequestHeader(value = "canary", required = false) String canary,
                                                                @RequestHeader(value = "service-mesh", required = false) String serviceMesh){
        logger.info("Uri: /v1/contratos | Header canary: " + canary + " service-mesh: " + serviceMesh + " | Cpf: " + cpf);
        return new ResponseEntity<>(orquestradorContratosFacade.orquestraContratos(cpf, canary, serviceMesh), HttpStatus.OK);
    }

}
