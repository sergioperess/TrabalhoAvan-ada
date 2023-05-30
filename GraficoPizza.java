import java.io.File;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;

public class GraficoPizza {
    // Método para criar o dataset do gráfico
    private final String titulo; // titulo do gráfico
    private final PieDataset datasetPizza;
    private JFreeChart graficoPizza; // Para poder criar a tela do gráfico

    // construtor
    public GraficoPizza(String titulo, PieDataset datasetPizza) {
        this.titulo = titulo;
        this.datasetPizza = datasetPizza;

        // criar gráfico
        this.criarGrafico();
    }

    // Método pra criar gráfico
    private void criarGrafico() {
        // titulo gráfico, dados do gráfico, legenda do gráfico, tooltip e url
        graficoPizza = ChartFactory.createPieChart(titulo, datasetPizza, true, true, false);
    }

    public void exibirGraficoEmFrame(int largura, int altura) {
        JFrame frame = new JFrame(titulo);
        frame.setPreferredSize(new DimensionUIResource(altura, largura));

        // Exibir o grafico
        ChartPanel painelDoGrafico = new ChartPanel(graficoPizza);

        painelDoGrafico.setPreferredSize(new DimensionUIResource(altura, largura));

        frame.add(painelDoGrafico);
        frame.pack();
        frame.setVisible(true);
    }

    // Método para riar um aquivo JPEG
    public void criarArqJPEG(String caminho, int largura, int altura) {
        File arquivoGrafico = new File(caminho + ".jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(arquivoGrafico, graficoPizza, largura, altura);
            // metodo para abrir arquivo
            java.awt.Desktop.getDesktop().open(arquivoGrafico);
        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo " + e.getMessage());
        }

    }
}
