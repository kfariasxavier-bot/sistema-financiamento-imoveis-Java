package util;

import java.util.Scanner;

public class InterfaceUsuario{
    Scanner scanner = new Scanner(System.in);

    public String pedirTipoImovel() {
        System.out.print("Digite o tipo do imóvel (Apartamento, Casa ou Terreno.): ");
        String tipoImovel = scanner.next();
        return tipoImovel;
    }

    public double pedirValorImovel() {
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                double valorImovel = scanner.nextDouble();

                if (valorImovel > 0) {
                    return valorImovel;
                }
            System.out.print("Digite um número válido que seja acima de zero.");
            } catch (Exception e) {
            System.out.println("Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public int pedirPrazoFinanciamento(){
        while (true) {
            try {
                System.out.print("Digite o prazo do financiamento: ");
                int prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento > 0) {
                    return prazoFinanciamento;

                }
                System.out.print("Digite um prazo válido que seja acima de zero.");
            } catch (Exception e) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public double pedirTaxaJuros(){
        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual: ");
                double taxaJuros = scanner.nextDouble();
                if (taxaJuros > 0) {
                    return taxaJuros;
                }
                System.out.print("Digite uma taxa de juros válida que seja acima de 0.");
            } catch (Exception e) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public double pedirAreaConstruida() {
        while (true) {
            try {
                System.out.print("Digite o tamanho da área construida: ");
                double areaConstruida = scanner.nextDouble();
                if (areaConstruida > 0) {
                    return areaConstruida;
                }
                System.out.print("Digite um tamanho válido.");
            } catch (Exception e) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public double pedirTamanhoTerreno() {
        while (true) {
            try {
                System.out.print("Digite o tamanho do terreno: ");
                double tamanhoTerreno = scanner.nextDouble();
                if (tamanhoTerreno > 0) {
                    return tamanhoTerreno;
                }
                System.out.print("Digite um tamanho válido.");
            } catch (Exception e) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
            }
        }
    }
    public int pedirNumeroVagas(){
        while (true) {
            try {
                System.out.print("Digite o número de vagas: ");
                int numeroVagas = scanner.nextInt();
                if (numeroVagas > 0) {
                    return numeroVagas;
                }
                System.out.print("Digite um número válido.");
            } catch (Exception e) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public int pedirNumeroAndar() {
        while (true) {
            try {
                System.out.print("Digite o número do andar: ");
                int numeroAndar = scanner.nextInt();
                if (numeroAndar > 0) {
                    return numeroAndar;
                }
                System.out.print("Digite um número válido.");
            } catch (Exception e) {
                System.out.println("Digite apenas números.");
                scanner.nextLine();
            }
        }
    }
    public String pediTipoZona(){
        while (true) {
            System.out.print("Digite o tipo da zona: ");
            String tipoZona = scanner.next();
                return tipoZona;
            }
        }
}
