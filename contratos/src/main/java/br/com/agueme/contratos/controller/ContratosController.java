package br.com.agueme.contratos.controller;

import br.com.agueme.contratos.controller.response.ContratosResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
public class ContratosController {

    private final Logger logger = LoggerFactory.getLogger(ContratosController.class);

    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping("/contratos")
    public ResponseEntity<List<ContratosResponse>> getContratos(@RequestParam("cpf")String cpf,
                                                                @RequestHeader(value = "canary", required = false) String canaryHeader,
                                                                @RequestHeader(value = "service-mesh", required = false) String serviceMesh){
        logger.info("Uri: /contratos | canaryHeader: " + canaryHeader + " service-mesh: " + serviceMesh);
        ContratosResponse contratosResponse = new ContratosResponse();
        contratosResponse.setCodigoProduto("5643");
        contratosResponse.setNumeroContrato("987984319");
        contratosResponse.setNomeProduto("Banco Igor - Pão de Açucar");
        contratosResponse.setSaldo(BigDecimal.valueOf(13312.23));

        ContratosResponse contratosResponse1 = new ContratosResponse();
        contratosResponse1.setCodigoProduto("5643");
        contratosResponse1.setNumeroContrato("97249685436");
        contratosResponse1.setNomeProduto("Banco Igor Card - Marisa");
        contratosResponse1.setSaldo(BigDecimal.valueOf(5646.74));

        ContratosResponse contratosResponse2 = new ContratosResponse();
        contratosResponse2.setCodigoProduto("4830");
        contratosResponse2.setNumeroContrato("7413164943");
        contratosResponse2.setNomeProduto("LIS - Conta Corrente IgorPersonalite");
        contratosResponse2.setSaldo(BigDecimal.valueOf(2315464.13));

        ContratosResponse contratosResponse3 = new ContratosResponse();
        contratosResponse3.setCodigoProduto("6744");
        contratosResponse3.setNumeroContrato("3654651331");
        contratosResponse3.setNomeProduto("Credcomp");
        contratosResponse3.setSaldo(BigDecimal.valueOf(13312.23));

        return new ResponseEntity<List<ContratosResponse>>(Arrays.asList(contratosResponse, contratosResponse1, contratosResponse2, contratosResponse3), HttpStatus.OK);
    }
}