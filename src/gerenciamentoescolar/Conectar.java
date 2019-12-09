/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentoescolar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ancelmocastro
 */
public class Conectar {
  Connection conectar = null;
   
  public Connection Escola(){   
    try
      {
        Class.forName("org.gjt.mm.mysql.Driver");
        conectar = DriverManager.getConnection("jdbc:mysql://localhost/Escola","root","root1234"); 
      }
    catch(SQLException ex) 
      {
        JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de Dados!","Erro",JOptionPane.ERROR_MESSAGE);
      }
       
    catch(ClassNotFoundException ex) 
      {   
             
      }
    return conectar;
    
    }
}
