/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_basedatos;

import java.sql.SQLException;

/**
 * La clase Basedatos es clase main del Proyecto y es la que nos permite abrir el Menú.
 * @author Jose Carlos
 */
public class Basedatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Menu men = new Menu ();
        men.setVisible(true);   
    }
    
}
