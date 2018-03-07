/*
 * PROJETO DE POO - UFRB - SEMESTRE 2017.1
 * ALUNO: HUGO FLORIANO  
 */
package com.hfsystems.projetos.servih.pessoas;
import com.hfsystems.projetos.poo.servih.principal.Autenticavel;
import com.hfsystems.projetos.poo.servih.empresa.NotaF;
import com.hfsystems.projetos.poo.servih.empresa.Deposito;
import java.util.ArrayList;
/**
 * @author HF_SYSTEMS
 */
public class Vendedor extends Pessoa implements Autenticavel{
 
    private String Nome;
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public Vendedor(){
        setNome("Carlos Magno");
        setCidade("Cruz das Almas");
        setCPF(1234567);
    }
    
    @Override
    public void Autenticavel(String Login, String Senha) {
        if(Login.equals("Carlos Magno") && Senha.equals("1234"))
        {
           //
        }
        else{
            System.err.println("Login ou senha incorretos ! ");
        }
    }
}
