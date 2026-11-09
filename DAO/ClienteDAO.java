
package DAO;

// Importa a classe ConexaoBD, responsável por estabelecer
// a conexão entre o sistema Java e o banco de dados.
import Database.conexaoBD;
// Importa a classe Cliente, que representa os dados
// de um cliente, como nome, idade, CPF e ID.
import Model.Cliente;
// Importa a classe Connection, responsável por representar
// uma conexão ativa com o banco de dados.
import java.sql.Connection;
// Importa a classe PreparedStatement, utilizada para preparar
// e executar comandos SQL com parâmetros de forma segura.
import java.sql.PreparedStatement;
// Importa a classe ResultSet, responsável por armazenar
// os resultados retornados por uma consulta SQL (SELECT).
import java.sql.ResultSet;
// Importa a classe SQLException, utilizada para identificar
// e tratar erros que podem ocorrer durante operações com o banco.
import java.sql.SQLException;
// Importa a classe ArrayList, utilizada para criar uma lista
// que permite armazenar vários objetos Cliente.
import java.util.ArrayList;
// Importa a interface List, utilizada para declarar
// e trabalhar com listas de objetos no Java.
import java.util.List;

public class ClienteDAO {

    // MÉTODO PARA CADASTRAR UM CLIENTE NO BANCO DE DADOS
// Retorna true se o cadastro for realizado e false se ocorrer algum erro.
public boolean cadastrar(Cliente cliente) {

    // Cria o comando SQL para inserir um novo cliente na tabela cliente.
    // Os sinais de interrogação (?) representam os valores que serão preenchidos posteriormente.
    String sql = "INSERT INTO cliente (nome, idade, cpf) VALUES (?, ?, ?)";

    // Abre a conexão com o banco de dados.
    // O PreparedStatement prepara o comando SQL para receber os valores.
    // O try-with-resources fecha automaticamente a conexão e o comando ao terminar.
    try (Connection conn = conexaoBD.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Define o primeiro parâmetro (?) com o nome do cliente.
        stmt.setString(1, cliente.getNome());

    
        // Define o terceiro parâmetro (?) com o CPF do cliente.
        stmt.setString(3, cliente.getCpf());

        // Executa o comando SQL no banco de dados.
        // executeUpdate() é utilizado em operações de INSERT, UPDATE e DELETE.
        stmt.executeUpdate();

        // Retorna true indicando que o cadastro foi executado com sucesso.
        return true;

    // Captura possíveis erros que acontecem durante a operação com o banco.
    } catch (SQLException e) {

        // Exibe no console a mensagem de erro retornada pelo banco de dados.
        System.out.println("Erro ao cadastrar: " + e.getMessage());

        // Retorna false indicando que o cadastro não foi realizado.
        return false;
    }
}
// MÉTODO PARA CONSULTAR E LISTAR TODOS OS CLIENTES CADASTRADOS
// Retorna uma lista contendo objetos da classe Cliente.
public List<Cliente> listar() {

    // Cria uma lista vazia para armazenar os clientes encontrados no banco.
    List<Cliente> lista = new ArrayList<>();

    // Cria o comando SQL para buscar os dados dos clientes.
    // ORDER BY id organiza os resultados pelo identificador do cliente.
    String sql = "SELECT id, nome, cpf, idade FROM cliente ORDER BY id";

    // Abre a conexão com o banco de dados.
    // Prepara o comando SQL e executa a consulta.
    // O ResultSet recebe os registros retornados pelo SELECT.
    try (Connection conn = conexaoBD.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        // Percorre os registros retornados pelo banco de dados.
        // rs.next() avança para o próximo registro.
        // Enquanto houver registros, o laço continuará executando.
        while (rs.next()) {

            // Cria um novo objeto da classe Cliente para armazenar os dados de um registro.
            Cliente cliente = new Cliente();

            // Recupera o valor da coluna id e atribui ao atributo id do objeto.
            cliente.setId(rs.getInt("id"));

            // Recupera o nome do banco e atribui ao atributo nome do objeto.
            cliente.setNome(rs.getString("nome"));

            // Recupera o CPF do banco e atribui ao atributo cpf do objeto.
            cliente.setCpf(rs.getString("cpf"));

          

            // Adiciona o objeto Cliente preenchido dentro da lista.
            lista.add(cliente);
        }

    // Captura possíveis erros durante a consulta dos dados.
    } catch (SQLException e) {

        // Exibe no console a mensagem de erro.
        System.out.println("Erro ao listar: " + e.getMessage());
    }

    // Retorna a lista contendo os clientes encontrados.
    return lista;
}
// MÉTODO PARA EXCLUIR UM CLIENTE DO BANCO DE DADOS.
// Recebe o ID do cliente que deverá ser excluído.
// Retorna true se algum registro for excluído e false caso contrário.
public boolean excluir(int id) {

    // Cria o comando SQL para excluir um cliente da tabela.
    // O sinal de interrogação (?) será substituído pelo ID informado.
    String sql = "DELETE FROM cliente WHERE id = ?";

    // Abre a conexão com o banco de dados.
    // Prepara o comando SQL para receber o ID do cliente.
    try (Connection conn = conexaoBD.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Define o primeiro parâmetro (?) com o ID recebido pelo método.
        stmt.setInt(1, id);

        // Executa o comando DELETE no banco de dados.
        // executeUpdate() retorna a quantidade de registros afetados.
        // Se o resultado for maior que zero, significa que um cliente foi excluído.
        return stmt.executeUpdate() > 0;

    // Captura possíveis erros durante a exclusão.
    } catch (SQLException e) {

        // Exibe no console a mensagem de erro.
        System.out.println("Erro ao excluir: " + e.getMessage());

        // Retorna false indicando que ocorreu um erro na exclusão.
        return false;
    }
}

    }
