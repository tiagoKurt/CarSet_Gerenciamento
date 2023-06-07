
import com.car.persistencia.IMarcasDAO;
import com.car.persistencia.MarcasDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class teste {
    public static void main(String[] args) {
        
        IMarcasDAO objeto;
        try {
            objeto = new MarcasDAO();
            System.out.println(objeto.buscar(1));
        } catch (Exception ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
