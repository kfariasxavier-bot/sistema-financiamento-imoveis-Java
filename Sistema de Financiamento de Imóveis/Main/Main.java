package Main;

import Modelo.Apartamento;
import Modelo.Casa;
import Modelo.Terreno;
import util.InterfaceUsuario;
import Modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        financiamentos.add(new Casa(200000, 30, 11, 32, 300));
        financiamentos.add(new Casa(300000, 27, 10, 40, 1000));
        financiamentos.add(new Apartamento(150000, 15, 12.4, 120, 5));
        financiamentos.add(new Apartamento(200000, 30, 11, 60, 2));
        financiamentos.add(new Terreno(330000, 31, 12, "Comercial"));

        double somaImoveis = 0;
        double somaFinanciamentos = 0;
        int numero = 1;


        for (Financiamento financiamento: financiamentos) {
            somaImoveis += financiamento.getValorImovel();

            somaFinanciamentos += financiamento.totalPagamento();

            System.out.println("Financiamento " + numero);
            financiamento.mostrarValorTotal();

            numero++;
            System.out.println();
            System.out.println("-------------------------------------------------------------------");
        }

        System.out.println("Total dos imóveis: " + somaImoveis);
        System.out.println("Total dos Financiamentos: " + somaFinanciamentos);

        InterfaceUsuario InterfaceUsuario = new InterfaceUsuario();
        String tipoImovel = InterfaceUsuario.pedirTipoImovel();
        double taxaJuros = InterfaceUsuario.pedirTaxaJuros();
        int prazoFinanciamentoAnos = InterfaceUsuario.pedirPrazoFinanciamento();
        double valorImovel = InterfaceUsuario.pedirValorImovel();

        Financiamento financ = null;

        if (tipoImovel.equalsIgnoreCase("Casa")){
            double areaConstruida = InterfaceUsuario.pedirAreaConstruida();
            double tamanhoTerreno = InterfaceUsuario.pedirTamanhoTerreno();

            financ = new Casa(valorImovel, prazoFinanciamentoAnos, taxaJuros, areaConstruida, tamanhoTerreno);
        }
        else if (tipoImovel.equalsIgnoreCase("Apartamento")){
            int numeroVagas = InterfaceUsuario.pedirNumeroVagas();
            int numeroAndar = InterfaceUsuario.pedirNumeroAndar();

            financ = new Apartamento(valorImovel, prazoFinanciamentoAnos, taxaJuros, numeroVagas, numeroAndar);
        }
        else if (tipoImovel.equalsIgnoreCase("Terreno")){
            String tipoZona = InterfaceUsuario.pediTipoZona();

            financ = new Terreno(valorImovel, prazoFinanciamentoAnos, taxaJuros, tipoZona);
        }
        financiamentos.add(financ);

        FileWriter escritor = null;

        try{
            escritor = new FileWriter("Financiamentos.text");
            for (Financiamento financiamento : financiamentos) {
                escritor.write(financiamento.toString());
                escritor.write(("\n"));
            }
            escritor.flush();
            escritor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectOutputStream obj = new ObjectOutputStream(
                    new FileOutputStream("financiamentosSerializable.text"));

            obj.writeObject(financiamentos);
            obj.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream ler = new ObjectInputStream(
                    new FileInputStream("financiamentosSerializable.text"));

            ArrayList<Financiamento> listaLida =
                    (ArrayList<Financiamento>) ler.readObject();

            ler.close();

            for (Financiamento f : listaLida) {
                System.out.println(f);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
