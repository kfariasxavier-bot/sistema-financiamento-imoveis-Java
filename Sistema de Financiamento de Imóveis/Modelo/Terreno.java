package Modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, String tipoZona){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }


    public double pagamentoMensal() {
        double pagamentoMensal;
        pagamentoMensal = (this.valorImovel / (this.prazoFinanciamento * 12 )) * (1 + (this.taxaJurosAnual / 12) * 0.02);
        return pagamentoMensal;
    }

    @Override
    public double totalPagamento() {
        double totalPagamento;
        totalPagamento = this.pagamentoMensal() * this.prazoFinanciamento * 12;
        return totalPagamento;
    }

    public String getTipoZona(){return this.tipoZona;}

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getValorImovel());
        sb.append(this.getPrazoFinanciamento());
        sb.append(this.getTaxaJurosAnual());
        sb.append(this.getTipoZona());
        return sb.toString() + ";";
    }
}
