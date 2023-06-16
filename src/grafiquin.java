import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class grafiquin {
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new grafiquin().createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        // Criar o JFrame
        JFrame frame = new JFrame("Exemplo de JComboBox com gráfico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Criar o dataset inicial
        dataset = createDataset("Opção 1");

        // Criar o gráfico inicial
        chart = createChart(dataset);

        // Criar o ChartPanel
        chartPanel = new ChartPanel(chart);

        // Criar o JComboBox
        String[] options = { "Opção 1", "Opção 2", "Opção 3" };
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                updateChart(selectedOption);
                showChartFrame();
            }
        });

        // Adicionar o JComboBox ao JFrame
        frame.setLayout(new BorderLayout());
        frame.add(comboBox, BorderLayout.NORTH);

        // Exibir o JFrame
        frame.setVisible(true);
    }

    private void updateChart(String selectedOption) {
        // Atualizar o dataset com base na opção selecionada
        dataset = createDataset(selectedOption);

        // Atualizar o gráfico com o novo dataset
        chart.getCategoryPlot().setDataset(dataset);
    }

    private DefaultCategoryDataset createDataset(String option) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (option.equals("Opção 1")) {
            dataset.addValue(200, "Produtos A", "Janeiro");
            dataset.addValue(300, "Produtos A", "Fevereiro");
            dataset.addValue(400, "Produtos A", "Março");
        } else if (option.equals("Opção 2")) {
            dataset.addValue(150, "Produtos B", "Janeiro");
            dataset.addValue(250, "Produtos B", "Fevereiro");
            dataset.addValue(350, "Produtos B", "Março");
        } else if (option.equals("Opção 3")) {
            dataset.addValue(100, "Produtos C", "Janeiro");
            dataset.addValue(200, "Produtos C", "Fevereiro");
            dataset.addValue(300, "Produtos C", "Março");
        }
        return dataset;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart("Vendas Mensais", "Mês", "Vendas", dataset, PlotOrientation.VERTICAL, false, false, false);
        return chart;
    }

    private void showChartFrame() {
        // Criar o JFrame para exibir o gráfico
        JFrame chartFrame = new JFrame("Gráfico");
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.setSize(400, 300);
        
        // Adicionar o ChartPanel ao JFrame
        chartFrame.getContentPane().add(chartPanel);

        // Exibir o JFrame do gráfico
        chartFrame.setVisible(true);
    }
}