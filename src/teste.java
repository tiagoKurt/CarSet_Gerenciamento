
import com.car.Enumerations.ClassificacaoGastos;
import com.car.Modelos.GastosCombustivel;
import com.car.persistencia.IGastosCombustivelDao;
import com.car.persistencia.IMarcasDAO;
import com.car.persistencia.MarcasDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TiposCombustiveisGastos;
import com.car.Modelos.GastosMecanico;
import com.car.Modelos.Veiculos;
import com.car.persistencia.GastosCombustivelDao;
import com.car.persistencia.GastosMecanicoDao;
import com.car.persistencia.IGastosMecanicoDao;
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
            System.out.println(objetoVDao.buscarVeiculos("weq2321").getId());
       
            
            GastosMecanico objeto = new GastosMecanico(0,ClassificacaoGastos.MECANICO,"Vistoria",null,0,0,100,date,objetoVDao.buscarVeiculos("weq2321"));
            IGastosMecanicoDao objetoDao = new GastosMecanicoDao();
            objetoDao.InserirGastos(objeto);
                    
            
           
                    } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
