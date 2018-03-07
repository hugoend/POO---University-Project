package com.hfsystems.projetos.poo.servih.empresa;
/**
 *
 * @author HF-SYSTEMS
 */
import com.hfsystems.projetos.poo.servih.empresa.Produtos;
import com.hfsystems.projetos.servih.pessoas.Cliente;
import com.hfsystems.projetos.servih.pessoas.Vendedor;
import java.util.ArrayList;
import java.util.Random;
public class NotaF implements java.io.Serializable{

    
    Vendedor V = new Vendedor(); 
    int qtd;
    private double valorCompra;
    static int codigoNota;
    private ArrayList<Produtos> Prod = new ArrayList<>();
    private ArrayList<Integer> Qtd = new ArrayList<>();
    private Cliente Cli = new Cliente();

    public Vendedor getV() {
        return V;
    }

    public void setV(Vendedor V) {
        this.V = V;
    }

    public Cliente getCli() {
        return Cli;
    }

    public void setCli(Cliente Cli) {
        this.Cli = Cli;
    }
    

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra += valorCompra;
    }

    public ArrayList<Produtos> getProd() {
        return Prod;
    }

    public void setProd(ArrayList<Produtos> Prod) {
        this.Prod = Prod;
    }

    public ArrayList<Integer> getQtd() {
        return Qtd;
    }

    public void setQtd(ArrayList<Integer> Qtd) {
        this.Qtd = Qtd;
    }

    
    
    public void fecharNota(int qtd){

    }
    
        
    
}
