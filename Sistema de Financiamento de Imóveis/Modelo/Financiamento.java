package Modelo;


import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;


    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }

    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){
        this.valorImovel  = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double pagamentoMensal();

    public abstract double totalPagamento();

    public void mostrarValorTotal(){
        System.out.println("O valor do imóvel é R$ " + valorImovel);
        System.out.println("O valor total do imóvel é R$ " + this.totalPagamento());
    }
}
