package Modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int vagasGaragem, int numeroAndar){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public double taxa = this.taxaJurosAnual / 100;

    @Override
    public double totalPagamento() {
        return this.valorImovel * (1 + (this.taxa * this.prazoFinanciamento));
    }

    @Override
    public double pagamentoMensal() {
        return this.totalPagamento() / (this.prazoFinanciamento * 12);
    }

    public int getVagasGaragem(){return this.vagasGaragem;}
    public int getNumeroAndar(){return this.numeroAndar;}

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getValorImovel());
        sb.append(this.getPrazoFinanciamento());
        sb.append(this.getTaxaJurosAnual());
        sb.append(this.getNumeroAndar());
        sb.append(this.getVagasGaragem());
        return sb.toString() + ";";
    }
}
