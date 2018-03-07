package com.hfsystems.projetos.servih.pessoas;

import java.util.Date;
/**
 * @author HF-Systems
 */
public abstract class  Pessoa implements java.io.Serializable{

   
    private int CPF;
    private Date data_nascimento;
    private String Cidade;

    
    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }
   
    

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }
    

    
}