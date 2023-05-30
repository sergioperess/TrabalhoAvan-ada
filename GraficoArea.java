
import java.io.File;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

public class GraficoArea {
    private final String titulo;
    private final XYDataset datasetAreaXY;
    private JFreeChart graficoArea;

    public GraficoArea(String titulo, XYDataset datasetAreaXY) {
        this.titulo = titulo;
        this.datasetAreaXY = datasetAreaXY;

        // criar gráfico
        this.criarGrafico();
    }

    // Método para criar o gráfico
    private void criarGrafico() {
        // titulo, x, y, dados do gráfico, horientação, exibir legenda, toltio e url
        this.graficoArea = ChartFactory.createXYAreaChart(
                titulo,
                "Ano",
                "Quantidade",
                datasetAreaXY,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);
    }

    public void exibirGraficoEmFrame(int largura, int altura) {
        JFrame frame = new JFrame(titulo);
        frame.setPreferredSize(new DimensionUIResource(altura, largura));

        // Exibir o grafico
        ChartPanel painelDoGrafico = new ChartPanel(graficoArea);

        painelDoGrafico.setPreferredSize(new DimensionUIResource(altura, largura));

        frame.add(painelDoGrafico);
        frame.pack();
        frame.setVisible(true);
    }

    // Método para riar um aquivo JPEG
    public void criarArqJPEG(String caminho, int largura, int altura) {
        File arquivoGrafico = new File(caminho + ".jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(arquivoGrafico, graficoArea, largura, altura);
            // metodo para abrir arquivo
            java.awt.Desktop.getDesktop().open(arquivoGrafico);
        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo " + e.getMessage());
        }

    }

}
