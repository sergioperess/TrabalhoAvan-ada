import java.util.Scanner;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Main {
    public static void main(String args[]) {

        int opcao;
        do {

            opcao = exibirMenu();
            if (opcao == 1) {
                criaPizza();
            } else if (opcao == 2) {
                criaGraficoArea();
            } else if (opcao == 3) {
                criaGraficoBarra();
            } else if (opcao == 4) {
                System.out.println("Até logo!");
            } else {
                System.out.println("NÚMERO INVÁLIDO");
                System.out.println("DIGITE NOVAMENTE");
            }

        } while (opcao != 4);

    }

    private static void criaPizza() {
        DefaultPieDataset dadosGrafico = new DefaultPieDataset();
        dadosGrafico.setValue("Java 5", 10);
        dadosGrafico.setValue("Java 6", 20);
        dadosGrafico.setValue("Java 7", 20);
        dadosGrafico.setValue("Java 8", 50);

        GraficoPizza graficoPizza = new GraficoPizza("Versões mais usadas do Java", dadosGrafico);
        graficoPizza.exibirGraficoEmFrame(500, 500);
    }

    private static void criaGraficoArea() {
        // Legenda da parte de baixo
        XYSeries pontosDoGrafico = new XYSeries("Programadores Java por ano");

        // Adiciona pontos no gráfico
        pontosDoGrafico.add(1995, 100);
        pontosDoGrafico.add(2000, 5000);
        pontosDoGrafico.add(2005, 20000);
        pontosDoGrafico.add(2010, 17000);
        pontosDoGrafico.add(2015, 40000);
        pontosDoGrafico.add(2025, 19000);

        XYDataset datasetAreaXY = new XYSeriesCollection(pontosDoGrafico);
        GraficoArea graficoArea = new GraficoArea("Programadores Java", datasetAreaXY);
        graficoArea.exibirGraficoEmFrame(600, 640);
    }

    private static void criaGraficoBarra() {
        final String titulo = "USUÁRIOS E PAIXÕES";
        final String quantidadeUsuarios = "QUANTIDADE DE USUÁRIOS";

        DefaultCategoryDataset datasetBarras = new DefaultCategoryDataset();

        datasetBarras.addValue(2000, "Java 1.5", quantidadeUsuarios);
        datasetBarras.addValue(8000, "Java 1.6", quantidadeUsuarios);
        datasetBarras.addValue(12000, "Java 1.7", quantidadeUsuarios);
        datasetBarras.addValue(20000, "Java 1.8", quantidadeUsuarios);

        GraficoBarra graficoBarra = new GraficoBarra(titulo, "", quantidadeUsuarios, datasetBarras);
        graficoBarra.exibirGraficoEmFrame(600, 640);

    }

    private static int exibirMenu() {
        System.out.println("\n");
        System.out.println("1 - Grágico de Pizza");
        System.out.println("2 - Gráfico de Área");
        System.out.println("3 - Gráfico de Barras");
        System.out.println("4 - Sair");

        System.out.println("\nDigite a opção desejada: ");

        // Objeto da classe Scanner para pedir a entrada do usuário
        Scanner entrada = new Scanner(System.in);
        // Pede entrada pro usuário
        int opcao = entrada.nextInt();
        // Retorna a entrada
        return opcao;
    }
}
