package br.com.agueme.politicas.controller;

import br.com.agueme.politicas.controller.request.ContratosRenegociaveisRequest;
import br.com.agueme.politicas.controller.response.ContratosRenegociaveisResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@RestController
public class PoliticasController {

    private final Logger logger = LoggerFactory.getLogger(PoliticasController.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostMapping("/contratos_renegociaveis")
    public ResponseEntity<List<ContratosRenegociaveisResponse>> getContratosRenegociaveis(@RequestBody List<ContratosRenegociaveisRequest> contratosRenegociaveisRequest,
                                                                                          @RequestHeader(value = "canary", required = false) String canaryHeader,
                                                                                          @RequestHeader(value = "service-mesh", required = false) String serviceMesh) {
        logger.info("Uri: /contratos_renegociaveis | canaryHeader: " + canaryHeader + " service-mesh: " + serviceMesh + " release-2.0.0");
        List<ContratosRenegociaveisResponse> contratos = contratosRenegociaveisRequest.stream()
                .map(contrato -> {

                    int random = ThreadLocalRandom.current().nextInt(1, 20 + 1);

                    if (random % 2 == 0) {
                        return new ContratosRenegociaveisResponse(contrato.getCodigoProduto(), contrato.getNumeroContrato(), true);
                    } else {
                        return new ContratosRenegociaveisResponse(contrato.getCodigoProduto(), contrato.getNumeroContrato(), false);
                    }
                }).collect(Collectors.toList());

        return new ResponseEntity<List<ContratosRenegociaveisResponse>>(contratos, HttpStatus.OK);
    }

}