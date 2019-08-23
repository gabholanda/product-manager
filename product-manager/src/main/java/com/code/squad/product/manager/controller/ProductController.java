/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.squad.product.manager.controller;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcelo.moraes
 */
public class ProductController {
    
        public static boolean excluir(int pIdProduto)
    {
        return Product.excluir(pIdProduto);
    }
    public static ArrayList<String[]> getProduto() throws SQLException
    {
        ArrayList<Produto> produtos = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
        for(int i=0;i<produtos.size();i++)
        {
        	listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getCodProduto()),produtos.get(i).getNome(),
                produtos.get(i).getFornecedor(),String.valueOf(produtos.get(i).getQntEstoque()), 
                String.valueOf(produtos.get(i).getQntCaixa()),String.valueOf(produtos.get(i).getPeso()),
                String.valueOf(produtos.get(i).getPreco()),produtos.get(i).getCategoria()});
        
        }
        
        return listaProdutos;
        
    }
    
}
