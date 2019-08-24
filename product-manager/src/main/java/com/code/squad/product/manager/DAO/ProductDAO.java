/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.squad.product.manager.DAO;

import com.code.squad.product.manager.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author marcelo.moraes
 */
public class ProductDAO {

    //parametros para conexão com o bd
    //"com.mysql.cj.jdbc.Driver"
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do MySQL - Se mudar o SGBD mude o Driver
    private static final String LOGIN = "root"; //nome de um usuário do banco de dados
    private static final String SENHA = "adminadmin";//sua senha de acesso, bd do senac tem essa senha
    private static final String URL = "jdbc:mysql://localhost:3306/produtobd?useTimezone=true&serverTimezone=UTC"; //URL do banco de dados
    private static Connection ConexaoProduto;

    //funcao para salvar dados no bd 
    public static boolean salvarDados(Product p) {

        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            ConexaoProduto = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = ConexaoProduto.prepareStatement("INSERT INTO PRODUTOBD.PRODUTO (NOME, DESCRICAO, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DISPONIVEL, DT_CADASTRO) VALUES(?, ?, ?, ?, ?, ?, ? )");

            comando.setString(1, (p.getNome()));
            comando.setString(2, (p.getDescricao()));
            comando.setDouble(3, (p.getPrecoCompra()));
            comando.setDouble(4, (p.getPrecoVenda()));
            comando.setInt(5, (p.getQuantidade()));
            comando.setBoolean(6, (p.isStatus()));
            comando.setString(7, (p.getDate()));

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            System.out.println(ex);
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
    public static boolean atualizar(Product p) {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            ConexaoProduto = DriverManager.getConnection(URL, LOGIN, SENHA);

            PreparedStatement comando = ConexaoProduto.prepareStatement("UPDATE PRODUTOBD.PRODUTO SET NOME=?, DESCRICAO=?, PRECO_COMPRA=?, PRECO_VENDA=?, QUANTIDADE=?, DISPONIVEL=? WHERE ID= ?");

            comando.setString(1, (p.getNome()));
            comando.setString(2, (p.getDescricao()));
            comando.setDouble(3, (p.getPrecoCompra()));
            comando.setDouble(4, (p.getPrecoVenda()));
            comando.setInt(5, (p.getQuantidade()));
            comando.setBoolean(6, (p.isStatus()));

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

    public static ArrayList<Product> getProdutos() {
        ArrayList<Product> listaProdutos = new ArrayList<Product>();

        try {
//Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            //Monto a URL
            ConexaoProduto = DriverManager.getConnection(URL, LOGIN, SENHA);
            Statement comando = ConexaoProduto.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM PRODUTOBD.PRODUTO;");

            if (rs != null) {
                while (rs.next()) {
                    Product prod = new Product();
                    //set dos dados 
                    prod.setId(rs.getInt("ID"));
                    prod.setDescricao(rs.getString("DESCRICAO"));
                    prod.setNome(rs.getString("NOME"));
                    prod.setQuantidade(rs.getInt("QUANTIDADE"));
                    prod.setPrecoCompra(rs.getDouble("PRECO_VENDA"));
                    prod.setPrecoVenda(rs.getDouble("PRECO_COMPRA"));
                    listaProdutos.add(prod);
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
