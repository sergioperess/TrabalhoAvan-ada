import java.io.File;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra {
    private final String titulo;
    private final String textoEixoX;
    private final String textoEixoY;
    private final DefaultCategoryDataset categoryDataset;
    private JFreeChart graficoBarras;

    public GraficoBarra(String titulo, String textoEixoX, String textoEixoY,
            DefaultCategoryDataset categoryDataset) {
        this.titulo = titulo;
        this.textoEixoX = textoEixoX;
        this.textoEixoY = textoEixoY;
        this.categoryDataset = categoryDataset;
        this.criarGrafico();
    }

    private void criarGrafico() {
        // titulo, eixo y, eixo x, os dados, orientação, legenda, toltip, url
        this.graficoBarras = ChartFactory.createBarChart(
                titulo,
                textoEixoY,
                textoEixoX,
                categoryDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
    }

    public void exibirGraficoEmFrame(int largura, int altura) {
        JFrame frame = new JFrame(titulo);
        frame.setPreferredSize(new DimensionUIResource(altura, largura));

        // Exibir o grafico
        ChartPanel painelDoGrafico = new ChartPanel(graficoBarras);

        painelDoGrafico.setPreferredSize(new DimensionUIResource(altura, largura));

        frame.add(painelDoGrafico);
        frame.pack();
        frame.setVisible(true);
    }

    // Método para riar um aquivo JPEG
    public void criarArqJPEG(String caminho, int largura, int altura) {
        File arquivoGrafico = new File(caminho + ".jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(arquivoGrafico, graficoBarras, largura, altura);
            // metodo para abrir arquivo
            java.awt.Desktop.getDesktop().open(arquivoGrafico);
        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo " + e.getMessage());
        }

    }

}
