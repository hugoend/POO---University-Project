/*
 * PROJETO DE POO - UFRB - SEMESTRE 2017.1
 * ALUNO: HUGO FLORIANO  
 */
package com.hfsystems.projetos.servih.pessoas;
/**
 *
 * @author HF-Systems
 */
import com.hfsystems.projetos.poo.servih.empresa.NotaF;
import  java.util.ArrayList;
      
public class Cliente extends Pessoa implements java.io.Serializable{

    private ArrayList<Integer> cods = new ArrayList<>();
    private ArrayList<NotaF> Nota = new ArrayList<>();
    private String Nome;
    
    public ArrayList<NotaF> getNota() {
        return Nota;
    }

    public void setNota(NotaF Nota) {
        this.Nota.add(Nota);
        
    }
    

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    
    public boolean isComprou() {
        return comprou;
    }

    public void setComprou(boolean comprou) {
        this.comprou = comprou;
    }
    
    private boolean comprou;
    
    
    public ArrayList<Integer> getCods() {
        return cods;
    }

    public void setCods(int Cod) {
        cods.add(Cod);
    }
    
    
   }
