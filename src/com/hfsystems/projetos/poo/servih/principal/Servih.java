/*
 * PROJETO DE POO - UFRB - SEMESTRE 2017.1
 * ALUNO: HUGO FLORIANO  
 */
package com.hfsystems.projetos.poo.servih.principal;
import com.hfsystems.projetos.poo.servih.empresa.NotaF;
import static com.hfsystems.projetos.poo.servih.principal.LimparConsole.clearConsole;
import com.hfsystems.projetos.poo.servih.empresa.CatalogoProd;
import com.hfsystems.projetos.poo.servih.empresa.Deposito;
import com.hfsystems.projetos.poo.servih.empresa.Empresa;
import com.hfsystems.projetos.poo.servih.empresa.Produtos;
import com.hfsystems.projetos.servih.pessoas.Vendedor;
import com.hfsystems.projetos.servih.pessoas.Cliente;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HF - SYSTEMS
*/

public class Servih {		
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        TelaLogin T = new TelaLogin();
        boolean menu = true;
        while(true){
        T.setVisible(true);
        if(!T.isEntrou()){
        }
        else{
        T.dispose();
        int i = 0;
        Scanner S = new Scanner(System.in);
        Empresa Emp = new Empresa();
        Vendedor v = new Vendedor();
        Deposito Dep = new Deposito();
        CatalogoProd Catalogo = new CatalogoProd();
        int f = 0;
        
        for(;;){   
        clearConsole();
        System.out.println("\t\t\t+---------SERVIH-----------+");
        System.out.println("\t\t\t[1] - Produtos");
        System.out.println("\t\t\t[2] - Clientes");
        System.out.println("\t\t\t+--------------------------+");
        System.out.println("\t\t\t[3] - Vender");
        System.out.println("\t\t\t[4] - Listar Notas Fiscais");
        System.out.println("\t\t\t[5] - Carregar Arquivo");
        System.out.println("\t\t\t[6] - Sair");
        System.out.println("\t\t\t+--------------------------+");
        System.out.print("\t\t\tOpção válida: ");
        i=S.nextInt();
        
        switch (i){
                
            case 1: 
                //Produtos
                Op1(v, Emp,Dep, Catalogo);
                break;
            case 2:
                //Clientes
                Op2(Emp);
                Salvar(Emp, Dep);
                break;
            case 3:
                //Vender
                Op3(Emp,Dep, v);
                Salvar(Emp, Dep);
                break;
            case 4: 
                //Listar Notas
                Op4(Emp, v);
                break;
            case 5:
                //Carregar dos Arquivos
                Emp = Carregar();
                Dep = CarregarDep();
                break;
            case 6:
                 //Sair
                Salvar(Emp, Dep);
                menu = false;
                break;
            default:
                System.out.println("\t\t\tEssa opção não é válida");
            }
            if(menu == false){
                break;
            }
       
        }
         
        }
        if(menu == false){
         break;
            }
        }
    
    }
    

    
    //Produtos
    public static void Op1(Vendedor v, Empresa Emp, Deposito Dep, CatalogoProd Catalogo) throws IOException{
        clearConsole();
        Scanner S = new Scanner(System.in);
        int i = 0;
        int sair = 1;
        
        for(;;){
            System.out.println("\t\t\t+---------SERVIH-PRODUTOS----------+");
            System.out.println("\t\t\t[1] - Cadastrar Produtos");
            System.out.println("\t\t\t[2] - Listar Produtos");
            System.out.println("\t\t\t[3] - Buscar Produto");
            System.out.println("\t\t\t[4] - Voltar");
            System.out.println("\t\t\t+-----------------------------------+");
            System.out.print("\t\t\tOpção válida: ");
            i = S.nextInt();
        switch (i){
            case 1:
                
                clearConsole();
                
                Scanner d = new Scanner(System.in);
                int Code, qtdProd;
                String Nome, Tipo;
                double preco;
                
                System.out.print("\t\t\tNome prod: ");
                Nome = d.nextLine();
                System.out.print("\t\t\tTipo: ");
                Tipo = d.nextLine();
                System.out.print("\t\t\tCodigo: ");
                Code = d.nextInt();
                System.out.print("\t\t\tPreço: R$ ");
                preco = d.nextDouble();
                System.out.print("\t\t\tQuantidade: ");
                qtdProd = d.nextInt();
                
                Produtos Produto = new Produtos();
                int qtdProdIndex = qtdProd;
                while(qtdProd > 0){
                    Produtos mais = new Produtos();
                    mais.setNome(Nome);
                    mais.setCodigo(Code);
                    mais.setPreco(preco);
                    mais.setTipo(Tipo);
                    mais.setQuantidade(qtdProdIndex);
                    Dep.setProd(mais);
                    //Se eu vender um produto a um cliente, terei de remover 
                    //o produto do deposito, porém ele ainda irá existir no catalogo da empresa.
                    //APENAS UM PRODUTO (O EXEMPLAR) NO CATALOGO DA EMPRESA...
                    if(qtdProd == qtdProdIndex){
                        Emp.getCata().getProd().add(mais);
                        Emp.getCata().getQuantidade().add(qtdProdIndex);
                    }
                    qtdProd--;
                    }
                   
                    Salvar(Emp, Dep);
                break;
            case 2:
                
                    if(Emp.getCata().getProd().isEmpty()){
                        System.out.println("\t\t\tNão existem produtos cadastrados no catalogo.");
                    }
                    else{
                        System.out.println("\t\t\tPRODUTOS DA EMPRESA");
                        int  qtd = 0;
                        int code = 0;
                        for(int k = 0; k < Emp.getCata().getProd().size(); k++){
                            
                            System.out.println("\t\t\t*********************");
                            System.out.println("\t\t\tNome: "+Emp.getCata().getProd().get(k).getNome());
                            System.out.println("\t\t\tCodigo: "+Emp.getCata().getProd().get(k).getCodigo());
                            System.out.println("\t\t\tTipo: "+Emp.getCata().getProd().get(k).getTipo());
                            System.out.println("\t\t\tPreço: R$ "+Emp.getCata().getProd().get(k).getPreco());
                            code = Emp.getCata().getProd().get(k).getCodigo();
                             qtd = 0;
                            for(int p = 0; p < Dep.getProd().size(); p++){
                            if(code == Dep.getProd().get(p).getCodigo()){
                                qtd++;
                            }
                            }
                            System.out.println("\t\t\tQuantidade em Deposito: "+qtd);
                            System.out.println("\t\t\t*********************");
                        
                        }
                        
                        }
                    
                break;
            case 3:
                Scanner l = new Scanner(System.in);
               
                System.out.println("\t\t\tDigite o codigo do produto: ");
                int code = l.nextInt();
                int indice = searchProdDep(Dep, code);
                if(indice == -1){
                    break;
                }
                else if(indice == -2){
                    System.out.println("\t\t\tNão existem Produtos cadastrados com esse codigo");
                    break;
                }
                else{
                    int qtd = 0;
                    for(int p = 0; p < Dep.getProd().size(); p++){
                        if(code == Dep.getProd().get(p).getCodigo()){
                            qtd++;
                            }
                        }
                    
                    
                    System.out.println("\t\t\tNome: "+ Dep.getProd().get(indice).getNome()+
                    "\n\t\t\tTipo:" 
                    + Dep.getProd().get(indice).getTipo()+
                    "\n\t\t\tQuantidade: "
                    +qtd+
                    "\n\t\t\tPreço: R$"+
                    +Dep.getProd().get(indice).getPreco());
                }
                break;
            case 4: 
                sair = 0;
                break;
         default:
                System.out.println("\t\t\tEssa opção não é válida");
            }
        
        if(sair == 0){
            break;
        }
       }
    }
    
    //Clientes
    public static void Op2(Empresa Emp){
        clearConsole();
        Scanner S = new Scanner(System.in);
        int i = 0, j = 0, sair = 0;
            for(;;){
                System.out.println("\t\t\t+---------SERVIH-CLIENTES----------+");
                System.out.println("\t\t\t[1] - Cadastrar Cliente");
                System.out.println("\t\t\t[2] - Listar Clientes");
                System.out.println("\t\t\t[3] - Buscar Cliente");
                System.out.println("\t\t\t[4] - Voltar");
                System.out.println("\t\t\t+----------------------------------+");
                System.out.print("\t\t\tOpção válida: ");
                i = S.nextInt();
                
                switch (i){
                    case 1:
                         Cliente c = new Cliente();
                         Scanner s = new Scanner(System.in);
                         System.out.print("\t\t\tNome do Cliente: ");
                         c.setNome(s.nextLine());
                         System.out.print("\t\t\tCidade do Cliente: ");
                         c.setCidade(s.nextLine());
                         System.out.print("\t\t\tCPF: ");
                         c.setCPF(s.nextInt());
                         Emp.getCli().add(c);
                         break;
                    case 2:
                            if(Emp.getCli().isEmpty()){
                                System.out.println("\t\t\tNão existem clientes cadastrados");
                            }
                            else{
                            System.out.println("\t\t\tIMPRIMINDO CLIENTES");
                            for(int k = 0; k < Emp.getCli().size(); k++){
                             System.out.println("\t\t\t*********************");
                             System.out.println("\t\t\t"+Emp.getCli().get(k).getNome());
                             System.out.println("\t\t\t"+Emp.getCli().get(k).getCPF());
                             System.out.println("\t\t\t"+Emp.getCli().get(k).getCidade());
                             System.out.println("\t\t\t*********************");
                            }
                            }
                         break;
                    case 3: 
                            Scanner t = new Scanner(System.in);
                            clearConsole();
                            System.out.print("\t\t\tCPF do Cliente: ");
                            int indice = searchCli(Emp, t.nextInt());
                            if(indice == -1){
                                break;
                            }
                            else if(indice == -2){
                                System.out.println("\t\t\tNão existem Clientes cadastrados com esse CPF");
                                break;
                            }
                            else{
                             int qtd = 0;
                             double valor_total = 0;
                            System.out.println("\t\t\tNome: "+ Emp.getCli().get(indice).getNome()+"\n\t\t\tCidade:" 
                            + Emp.getCli().get(indice).getCidade() + "\n\t\t\tCPF: "
                            +Emp.getCli().get(indice).getCPF());
                            System.out.println("\t\t\tNOTAS DO CLIENTE:");
                            for(int l = 0; l < Emp.getNota().size(); l++){
                                if(Emp.getNota().get(l).getCli().getCPF() == Emp.getCli().get(indice).getCPF()){
                                    System.out.println("\t\t\tVendedor: "+Emp.getNota().get(l).getV().getNome());
                                    for(int o = 0; o < Emp.getNota().get(l).getProd().size(); o++){
                                        System.out.println("\t\t\tProduto: "+Emp.getNota().get(l).getProd().get(o).getNome());
                                        System.out.println("\t\t\tTipo: "+Emp.getNota().get(l).getProd().get(o).getTipo());
                                        System.out.println("\t\t\tPreço Unitário: R$ "+Emp.getNota().get(l).getProd().get(o).getPreco());
                                        System.out.println();
                                        qtd++;
                                    }
                                    System.out.println("\t\t\tQuantidade de Produtos: "+Emp.getCli().get(indice).getNota().get(indice).getQtd().get(indice));
                                    System.out.println("\t\t\tValor Total: R$ "+Emp.getNota().get(l).getValorCompra());
                                    System.out.println("\t\t\t*************FIM DE NOTA*************");
                                    System.out.println();
                                }
                                
                                
                            }
                            
                            }
                        break;
                    case 4: 
                        sair = 1;
                        break;
                 default:
                        System.out.println("\t\t\tEssa opção não é válida !");
                }
                if(sair == 1)break;
                
        }
        
    }
    
    //Vender
    public static void Op3(Empresa Emp,Deposito Dep, Vendedor V) throws IOException{
        clearConsole();
        Scanner S = new Scanner(System.in);
        if(Emp.getCli().isEmpty()){
            clearConsole();
            System.out.println("\t\t\tNão existem Clientes Cadastrados");    
        }
        else if(Dep.getProd().isEmpty()){
            System.out.println("\t\t\tNão existem Produtos no deposito");
        } 
        else {
            System.out.print("\t\t\tCPF do Cliente: ");
            int indiceCli = searchCli(Emp, S.nextInt());
              if(indiceCli != -2 && indiceCli != -1){
                                
                            Scanner k = new Scanner(System.in);
                            NotaF nota = new NotaF();
                            
                            nota.setCli(Emp.getCli().get(indiceCli));
                            nota.setV(V);
                            
                            int  i = 1;
                                while(i == 1){
                                        System.out.print("\t\t\tCodigo do Produto: ");
                                        int cod = S.nextInt();
                                        System.out.print("\t\t\tQuantidade de Produtos: ");
                                        int qtdProd = S.nextInt();
                                        int qtdProdIndex = qtdProd;
                                        //Verificar se ainda existem desses produtos em deposito no Deposito
                                        int indiceProd  = searchProdDep(Dep, cod);
                                        if(indiceProd == -1 || indiceProd == -2){
                                            System.out.println("\t\t\tNão existem mais deste produto no deposito");
                                            break;
                                        }
                                        else if(qtdProdIndex > Dep.getProd().get(indiceProd).getQuantidade()){
                                            System.out.println("\t\t\tQuantidade de pedido maior que estoque");
                                            break;
                                        }
                                        //Adicionando produto a nota fiscal do Cliente
                                        nota.getProd().add(Dep.getProd().get(indiceProd));
                                        nota.getQtd().add(qtdProd);
                                        double compra =  Dep.getProd().get(indiceProd).getPreco(); 
                                        nota.setValorCompra( compra * qtdProdIndex);
                                        System.out.println("\t\t\tValor total compra: R$ "+nota.getValorCompra());
                                        
                                        //Removendo Produto do deposito, NÃO DO CATALOGO DA EMPRESA
                                        for(int r = 0; r < qtdProd; r++){
                                            for(int l = 0; l < Dep.getProd().size(); l++){
                                                int indexProdRemover = searchProdDep(Dep, cod);
                                                    if(indexProdRemover == -2){
                                                       //Apenas continua a procurar
                                                    }
                                                    else if(indexProdRemover == -1){
                                                       //Não faz nada
                                                       break;
                                                    }
                                                    else{
                                                        Dep.getProd().remove(indexProdRemover);
                                                        break;
                                                    }
                                             }
                                        }
                                        System.out.print("\n\t\t\tVender mais: \n\t\t\t[1] = SIM\n\t\t\t[2] = NÃO");
                                        i = k.nextInt();
                                        
                                        
                                }
                                Emp.getNota().add(nota);
                                Emp.getCli().get(indiceCli).getNota().add(nota);
                                        
                            }
                        }
                    }
        
    
    //Listar Notas Fiscais
    public static void Op4(Empresa Emp, Vendedor V){
        
            clearConsole();
                for(int l = 0; l < Emp.getNota().size();l++){

                System.out.println("\t\t\tNOME DO VENDEDOR: " + V.getNome());
                System.out.println("\t\t\tNome do Cliente: "+Emp.getNota().get(l).getCli().getNome());
                System.out.println("\t\t\tCPF do Cliente: "+Emp.getNota().get(l).getCli().getCPF());
                System.out.println("\t\t\tCidade do Cliente: "+Emp.getNota().get(l).getCli().getCidade());
                System.out.println();
                System.out.println("\t\t\t**********COMPROU********");
                    for(int t = 0; t < Emp.getNota().get(l).getProd().size(); t++){
                    System.out.println("\t\t\tNome do Produto: "+Emp.getNota().get(l).getProd().get(t).getNome());
                    System.out.println("\t\t\tQuantidade: "+Emp.getNota().get(l).getQtd().get(t));

                    }
                    System.out.println("\t\t\tValor total da compra: " +Emp.getNota().get(l).getValorCompra());
                    System.out.println("\n\n");
                }
                
                System.out.print("\t\t\tAperte qualquer tecla para continuar: ");
                Scanner s = new Scanner(System.in);
                s.next();
                
        } 
   
    
    public static int searchCli(Empresa Emp, int cpf){
           
        int indice = 0, indiceNao = 0;
        boolean encontrou = false; 
        if(Emp.getCli().isEmpty()){
               return -1;
        }
        else{
            for(int k = 0; k < Emp.getCli().size(); k++){
                if(Emp.getCli().get(k).getCPF() == cpf){
                    encontrou = true;
                    indice = k;
                    break;
                } 
            }
        }
        if(encontrou){
        return (indice);
        }
        else{
        return (-2);
        }
    }
    public static int searchProdDep(Deposito Dep, int Code){
        
        int indice = 0;
        boolean encontrou = false; 
        if(Dep.getProd().isEmpty()){
        System.out.println("\t\t\tNÃO EXISTEM PRODUTOS NO DEPOSITO.");
        return -1;
        }
        else{
            for(int k = 0; k < Dep.getProd().size(); k++){
                if(Dep.getProd().get(k).getCodigo() == Code){
                    encontrou = true;
                    indice = k;
                    break;
                } 
            }
        }
        if(encontrou){
            return (indice);
        }
        else{
                return (-2);
            }
        }
    
    
    public static int searchProdEmp(Empresa Emp, int Code){
        
        int indice = 0;
        boolean encontrou = false; 
        if(Emp.getCata().getProd().isEmpty()){
        System.out.println("\t\t\tNÃO EXISTEM PRODUTOS CADASTRADOS NO CATALOGO.");
        return -1;
        }
        else{
            for(int k = 0; k < Emp.getCata().getProd().size(); k++){
                if(Emp.getCata().getProd().get(k).getCodigo() == Code){
                    encontrou = true;
                    indice = k;
                    break;
                } 
            }
        }
        if(encontrou){
            return (indice);
        }
        else{
                return (-2);
            }
        }
    
    
    
    
    
    public static void Salvar(Empresa Emp, Deposito Dep) throws IOException{
       
                FileOutputStream arquivoGravar = new FileOutputStream("Empresa.txt");
                ObjectOutputStream objetoGrava = new ObjectOutputStream(arquivoGravar);
                objetoGrava.writeObject(Emp);
                objetoGrava.close();
                arquivoGravar.close();
                
                FileOutputStream arqGravar2 = new FileOutputStream("ProdutosDeposito.txt");
                ObjectOutputStream objeto2 = new ObjectOutputStream(arqGravar2);
                objeto2.writeObject(Dep.getProd());
                objeto2.close();
                arqGravar2.close();
             
    }

    
    public static Empresa Carregar() throws FileNotFoundException,IOException, ClassNotFoundException{
        
            FileInputStream arquivoLer = new FileInputStream("Empresa.txt");
            ObjectInputStream objetoLer = new ObjectInputStream(arquivoLer);
            Empresa Emp = new Empresa();
            Emp = (Empresa) (objetoLer.readObject());
            
           
            objetoLer.close();
            arquivoLer.close();
            return (Emp);
    
    }
    
   
    public static Deposito CarregarDep() throws FileNotFoundException,IOException, ClassNotFoundException{
        
            FileInputStream arquivoLer = new FileInputStream("ProdutosDeposito.txt");
            ObjectInputStream objetoLer = new ObjectInputStream(arquivoLer);
            ArrayList<Produtos> Prod = new ArrayList<>();
            Prod = (ArrayList<Produtos>) (objetoLer.readObject());
            Deposito Dep = new Deposito();
            Dep.setProd(Prod);
           
            arquivoLer.close();
            objetoLer.close();
            return (Dep);
    
    }
    
    
}
	
        
