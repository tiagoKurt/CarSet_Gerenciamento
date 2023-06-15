
import com.car.Enumerations.ClassificacaoGastos;
import com.car.Modelos.GastosCombustivel;
import com.car.persistencia.IGastosCombustivelDao;
import com.car.persistencia.IMarcasDAO;
import com.car.persistencia.MarcasDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TiposCombustiveisGastos;
import com.car.Modelos.Veiculos;
import com.car.persistencia.GastosCombustivelDao;
import com.car.persistencia.IVeiculosDAO;
import com.car.persistencia.VeiculosDAO;
import java.sql.Date;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class teste {
    public static void main(String[] args){
        try {
            int idVeiculo = 0;
            Date date = new Date(System.currentTimeMillis());
            VeiculosDAO objetoVDao = new VeiculosDAO();
            System.out.println(objetoVDao.buscarVeiculos("SKRR777").getId());
            
            
            GastosCombustivel objeto = new GastosCombustivel(0, ClassificacaoGastos.COMBUSTIVEL,TiposCombustiveisGastos.Gasolina, 50, (float) 2, 20,date,objetoVDao.buscarVeiculos("SKRR777"));
            IGastosCombustivelDao objetoDao = new GastosCombustivelDao();
            objetoDao.InserirGastos(objeto);
                    
            
           
                    } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
