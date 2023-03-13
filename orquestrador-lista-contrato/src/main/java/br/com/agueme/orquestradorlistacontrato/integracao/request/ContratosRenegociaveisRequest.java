package br.com.agueme.orquestradorlistacontrato.integracao.request;

import br.com.agueme.orquestradorlistacontrato.integracao.response.ContratosResponse;

public class ContratosRenegociaveisRequest {

    private String codigoProduto;
    private String numeroContrato;

    public ContratosRenegociaveisRequest(ContratosResponse contratosResponse) {
        this.codigoProduto = contratosResponse.getCodigoProduto();
        this.numeroContrato = contratosResponse.getNumeroContrato();
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }
}
