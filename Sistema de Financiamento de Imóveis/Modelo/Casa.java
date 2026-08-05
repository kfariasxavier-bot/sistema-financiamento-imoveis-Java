package Modelo;

import util.AumentoMaiorQueJurosException;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    private void CalcularAcrescimoJuros(double valorJuros, double valorAcrescimo)
            throws AumentoMaiorQueJurosException {

        if (valorAcrescimo > (valorJuros / 2)) {
            throw new AumentoMaiorQueJurosException("O valor do acréscimo é maior que a metade do valor dos juros. Por isso vamos igualar o valor dos acréscimos ao valor dos juros.");
        }
    }

    public double pagamentoMensal() {

        double pagamentoMensal;
        double amortizacao = this.valorImovel / (this.prazoFinanciamento * 12);
        double valorJuros = amortizacao * ((this.taxaJurosAnual / 100) / 12);
        double valorAcrescimo = 240;
        try {
            CalcularAcrescimoJuros(valorJuros, valorAcrescimo);
        } catch (AumentoMaiorQueJurosException e) {
            valorAcrescimo = valorJuros;
        }
        pagamentoMensal = amortizacao * (1 + (this.taxaJurosAnual / 12)) + valorAcrescimo;
        return pagamentoMensal;
    }

    @Override
    public double totalPagamento() {
        double totalPagamento;
        totalPagamento = this.pagamentoMensal() * this.prazoFinanciamento * 12;
        return totalPagamento;
    }

    public double getAreaConstruida(){return this.areaConstruida;}

    public double getTamanhoTerreno(){return this.tamanhoTerreno;}

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getValorImovel());
        sb.append(this.getPrazoFinanciamento());
        sb.append(this.getTaxaJurosAnual());
        sb.append(this.getAreaConstruida());
        sb.append(this.getTamanhoTerreno());
        return sb.toString() + ";";
    }

}
