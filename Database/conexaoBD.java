/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

// IMPORTA A CLASSE CLASSE CONECTION, RESPONSAVEL POR REPRESENTAR UMA CONEXAO
// ATIVA ENTRE O SISTEMA JAVA E O BANCO DE DADOSS
import java.sql.Connection;

// IMPORTA A CLASSE DRIVERMANAGER RESPONSAVEL POR GERENCIAR OS DRIVERS E ESTABELESCER
// A CONEXAO COM BANCO DE DADOS
import java.sql.DriverManager;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexaoBD {
    

  private static final String URL =
          "jdbc:mysql://localhost:3306/banco_os";
  
  private static final String USUARIO = "root";
  
    private static final String SENHA = "";
    
    public static Connection getConexao(){
    
        try {
        
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;
    }
        catch (SQLException erro){
            
          JOptionPane.showMessageDialog(
            null,
                    "erro ao conectar com banco de dados:\n"
                    + erro.getMessage()
            );
            return null;
        }
    }
}
