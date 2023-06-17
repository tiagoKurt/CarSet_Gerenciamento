import com.car.Enumerations.ClassificacaoGastos;
import com.car.Modelos.Gastos;
import com.car.persistencia.GastosDao;
import com.car.persistencia.IGastosDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tiago
 */
public class testeGraficos extends JFrame{
    float gastosGraficoCombustivel = 0;
    float gastosGraficoImposto = 0;
    float gastosGraficoMecanico = 0;
    float gastosGraficoSeguro = 0;
    float gastosGraficoOutros = 0;
    
    
        public testeGraficos(){
    setDefaultCloseOperation (EXIT_ON_CLOSE);
    setTitle("Gráfico Pizza"); 
    setSize(950,700);
    setLocationRelativeTo(null);
    criarGrafico();
    setVisible(true);
    }
        
        public void criarGrafico(){
            try {
                DefaultCategoryDataset barra = new DefaultCategoryDataset();
                IGastosDao objetoDao = new GastosDao();
                
                ArrayList<Gastos> listaDeGastos = objetoDao.listaDeGastos();
                for(int i = 0; i < listaDeGastos.size();i++){
                    if(listaDeGastos.get(i).getIdentificadorGasto() == ClassificacaoGastos.COMBUSTIVEL ){
                        String[] data = listaDeGastos.get(i).getDataGasto().toString().split("-");
                        gastosGraficoCombustivel += listaDeGastos.get(i).getGastoTotal();
                        
                        if(data[1].equals("01")){
                            barra.setValue(listaDeGastos.get(i).getGastoTotal(),"JANEIRO","");
                        }
                        if(data[1].equals("02")){
                             barra.setValue(listaDeGastos.get(i).getGastoTotal(),"FEVEREIRO","");
                        }
                        if(data[1].equals("03")){
                             barra.setValue(listaDeGastos.get(i).getGastoTotal(),"MARÇO","");
                        }
                    }
                    
                   
                    
                    
                }
                
                
                
                
                JFreeChart grafico = ChartFactory.createBarChart3D("SOMA DE TODOS OS GASTOS POR TIPO","TIPOS DE GASTOS","TOTAL GASTOS",barra,PlotOrientation.VERTICAL,true,true,false);
                ChartPanel painel  = new ChartPanel(grafico);
                add(painel);
            } catch (Exception ex) {
                Logger.getLogger(testeGraficos.class.getName()).log(Level.SEVERE, null, ex);
            }
   
        
       }
        
        
        public static void main(String[] args) {
        new testeGraficos();
    }
        
    }
