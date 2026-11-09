/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author jonathanpereira
 */
public class Validacoes {
    

    // Verifica se o nome foi preenchido
    public static boolean validarNome(String nome) {

        return nome != null && !nome.trim().isEmpty();

    }

    // Verifica se o CPF possui 11 números
    public static boolean validarCPF(String cpf) {

        if (cpf == null) {
            return false;
        }

        String cpfNumerico = cpf.replaceAll("\\D", "");

        return cpfNumerico.length() == 11;

    }

    // Verifica se a idade é um número válido e positivo
    public static boolean validarIdade(String idade) {

        try {

            int valor = Integer.parseInt(idade);

            return valor > 0;

        } catch (NumberFormatException erro) {

            return false;

        }
    }

    // Verifica se todos os dados foram preenchidos corretamente
    public static boolean validarCliente(
            String nome, String cpf, String idade) {

        return validarNome(nome)
                && validarCPF(cpf)
                && validarIdade(idade);

    }

    // Remove caracteres não numéricos do CPF
    public static String formatarCPF(String cpf) {

        if (cpf == null) {
            return "";
        }

        return cpf.replaceAll("\\D", "");

    }
}


