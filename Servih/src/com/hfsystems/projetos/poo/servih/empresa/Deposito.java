/*
 * PROJETO DE POO - UFRB - SEMESTRE 2017.1
 * ALUNO: HUGO FLORIANO  
 */
package com.hfsystems.projetos.poo.servih.empresa;
/**
 *
 * @author HF-Systems
 * 
 */
import com.hfsystems.projetos.servih.pessoas.Cliente;
import java.util.ArrayList;
public class Deposito implements java.io.Serializable{

   private ArrayList<Produtos> Prod = new ArrayList<>();
    
   
    public void setProd(ArrayList<Produtos> Prod) {
        this.Prod = Prod;
    }
    

    public ArrayList<Produtos> getProd() {
        return Prod;
    }

    public void setProd(Produtos P) {
        Prod.add(P);
    }
   
   
}
