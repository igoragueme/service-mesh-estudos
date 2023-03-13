package br.com.agueme.politicas.controller.response;

public class ContratosRenegociaveisResponse {

    private String codigoProduto;
    private String numeroContrato;
    private boolean renegociavel;

    public ContratosRenegociaveisResponse(String codigoProduto, String numeroContrato, boolean renegociavel) {
        this.codigoProduto = codigoProduto;
        this.numeroContrato = numeroContrato;
        this.renegociavel = renegociavel;
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

    public boolean isRenegociavel() {
        return renegociavel;
    }

    public void setRenegociavel(boolean renegociavel) {
        this.renegociavel = renegociavel;
    }

}
