/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.squad.product.manager.controller;

import com.code.squad.product.manager.DAO.ProductDAO;
import com.code.squad.product.manager.model.Product;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcelo.moraes
 */
public class ProductController {

    public static boolean salvar(String nome, String descricao, double precoCompra, double precoVenda, int quantidade, boolean status, String date) {
        Product p = new Product(nome, descricao, precoCompra, precoVenda, quantidade, status, date);
        return ProductDAO.salvarDados(p);
    }
    
    public static boolean atualizar(String nome, String descricao, double precoCompra, double precoVenda, int quantidade, boolean status, String date) {
        Product p = new Product(nome, descricao, precoCompra, precoVenda, quantidade, status, date);
        return ProductDAO.atualizar(p);
    }
    
    public static boolean excluir(int id) {
        return ProductDAO.excluir(id);
    }

    public static ArrayList<String[]> getProdutos() throws SQLException {
        ArrayList<Product> produtos = ProductDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.add(new String[]{
                
                String.valueOf(produtos.get(i).getId()),
                produtos.get(i).getNome(),
                produtos.get(i).getDescricao(),
                String.valueOf(produtos.get(i).getPrecoCompra()),
                String.valueOf(produtos.get(i).getPrecoVenda()),
                String.valueOf(produtos.get(i).getQuantidade())
            });

        }

        return listaProdutos;
    }

}
