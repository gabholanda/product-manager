/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.squad.product.manager.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcelo.moraes
 */
public class ProductDAO {

    //parametros para conexão com o bd
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do MySQL - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root"; //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";//sua senha de acesso, bd do senac tem essa senha
    private static final String URL = "jdbc:mysql://localhost:3306/produtobd?useTimezone=true&serverTimezone=UTC"; //URL do banco de dados
    private static Connection ConexaoProduto;

    //funcao para salvar dados no bd 
    public static boolean salvarDados() {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            ConexaoProduto = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement pst = ConexaoProduto.prepareStatement("INSERT INTO PRODUTOBD.PRODUTO (NOME, DESCRICAO, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DISPONIVEL) VALUES(?, ?, ?, ?, ?, ?)");

            pst.setString(1, ());
            pst.setString(2, ());
            pst.setDouble(3, ());
            pst.setDouble(4, ());
            pst.setInt(5, ());
            pst.setBoolean(6, ());

            int linhasAfetadas = pst.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                ConexaoProduto.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }

        return retorno;

    }

    //funcao para exclusao de dados no bd 
    public static boolean excluir(int idl) {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            ConexaoProduto = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = ConexaoProduto.prepareStatement("DELETE FROM PRODUTOBD.PRODUTO WHERE ID= ?");

            comando.setInt(1, idl);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                ConexaoProduto.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }

        return retorno;
    }

    //funcao para atualizar de dados no bd 
    public static boolean atualizar() {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            ConexaoProduto = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = ConexaoProduto.prepareStatement("UPDATE PRODUTOBD.PRODUTO SET NOME=?, DESCRICAO=?, PRECO_COMPRA=?, PRECO_VENDA=?, QUANTIDADE=?, DISPONIVEL=? WHERE ID= ?");

            pst.setString(1, ());
            pst.setString(2, ());
            pst.setString(3, ());
            pst.setInt(4, ());
            pst.setString(5, ());
            pst.setDouble(6, ());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                ConexaoProduto.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }

        return retorno;

    }

    public static ArrayList<> () {
        ArrayList<>  = new ArrayList<>();

        try {
//Carrego o driver para acesso ao banco
            Class.forName(DRIVER);            
             //Monto a URL
            ConexaoProduto = DriverManager.getConnection(URL, LOGIN, SENHA);
            PreparedStatement pst = ConexaoProduto.prepareStatement();
            ResultSet rs = pst.executeQuery("SELECT * FROM PRODUTOBD.PRODUTO;");
            
             if (rs != null) {
            while (rs.next()) {
                Produto prod = new Produto(); 
                 //set dos dados 
                 
                 listaProduto.add(c);
            } 
           
             } else {
                throw new SQLException();
            }

         } catch (SQLException e) {
            listaProdutos = null;
        } catch (ClassNotFoundException ex) {
            listaProdutos = null;
        } finally {
            try {
                ConexaoProduto.close();
            } catch (SQLException ex) {
                listaProdutos = null;
            }
        }

        return listaProdutos;

    }

}
