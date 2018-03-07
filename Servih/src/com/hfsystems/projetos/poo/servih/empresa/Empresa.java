/*
 * PROJETO DE POO - UFRB - SEMESTRE 2017.1
 * ALUNO: HUGO FLORIANO  
 */


package com.hfsystems.projetos.poo.servih.empresa;

import com.hfsystems.projetos.servih.pessoas.Cliente;
import com.hfsystems.projetos.servih.pessoas.Vendedor;
import java.util.ArrayList;

/**
 *
 * @author HF- SYSTEMS
 */
public class Empresa implements java.io.Serializable {
 
    ArrayList<Cliente> cli = new ArrayList<>();
    CatalogoProd Cata = new CatalogoProd();
    ArrayList<Vendedor> V = new ArrayList<>();
    ArrayList<NotaF> Nota = new ArrayList<>();

    public CatalogoProd getCata() {
        return Cata;
    }

    public void setCata(CatalogoProd Cata) {
        this.Cata = Cata;
    }

    public ArrayList<Vendedor> getV() {
        return V;
    }

    public void setV(ArrayList<Vendedor> V) {
        this.V = V;
    }
   
    
    public ArrayList<NotaF> getNota() {
        return Nota;
    }

    public void setNota(ArrayList<NotaF> Nota) {
        this.Nota = Nota;
    }
    
    
    
    public void setCli(ArrayList<Cliente> cli) {
        this.cli = cli;
    }

    public ArrayList<Cliente> getCli() {
        return cli;
    }

    public void setCli(Cliente C) {
        cli.add(C);
    }
   
    
   
}
