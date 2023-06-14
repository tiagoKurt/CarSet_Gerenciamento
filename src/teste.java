
import com.car.Enumerations.ClassificacaoGastos;
import com.car.Modelos.GastosCombustivel;
import com.car.persistencia.IGastosCombustivelDao;
import com.car.persistencia.IMarcasDAO;
import com.car.persistencia.MarcasDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.car.Enumerations.TipoCombustivel;
import com.car.persistencia.GastosCombustivelDao;
import java.sql.Date;

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
            Date date = new Date(System.currentTimeMillis());
            
            GastosCombustivel objeto = new GastosCombustivel(0, ClassificacaoGastos.COMBUSTIVEL,TipoCombustivel.FLEX, 50, 282, (float) 2, 20,date);
            IGastosCombustivelDao objetoDao = new GastosCombustivelDao();
            objetoDao.InserirGastos(objeto);
                    
                    } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
