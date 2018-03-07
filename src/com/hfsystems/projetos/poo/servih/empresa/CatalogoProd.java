/*
 * PROJETO DE POO - UFRB - SEMESTRE 2017.1
 * ALUNO: HUGO FLORIANO  
 */
package com.hfsystems.projetos.poo.servih.empresa;

import java.util.ArrayList;

/**
 *
 * @author asd
 */
public class CatalogoProd implements java.io.Serializable{
    private ArrayList<Produtos> Prod = new ArrayList<>();
    private ArrayList<Integer> quantidade = new ArrayList<>();
    
    
    public ArrayList<Integer> getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(ArrayList<Integer> quantidade) {
        this.quantidade = quantidade;
    }
    
    public ArrayList<Produtos> getProd() {
        return Prod;
    }

    public void setProd(Produtos P) {
        Prod.add(P);
    }
    
    
    
}
