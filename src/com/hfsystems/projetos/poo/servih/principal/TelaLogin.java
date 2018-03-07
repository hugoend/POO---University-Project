/*
 * PROJETO DE POO - UFRB - SEMESTRE 2017.1
 * ALUNO: HUGO FLORIANO  
 */
package com.hfsystems.projetos.poo.servih.principal;
import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author HF-Systems
 */
    public class TelaLogin extends JFrame{
        
        private JButton Entrar; 
        private JButton Cancelar;
        private JTextField Login;
        private JPasswordField Senha;

    public boolean isEntrou() {
        return entrou;
    }

    public void setEntrou(boolean entrou) {
        this.entrou = entrou;
    }
        private boolean entrou;
        
        public TelaLogin(){
         
            super("Login - SERVIH");
            Login = new JTextField();
            Senha = new JPasswordField();            
            Entrar = new JButton("Entrar");
            Entrar.addActionListener(new BotaoEntrarListenner());
            Cancelar = new JButton("Limpar");
            Cancelar.addActionListener(new BotaoCancelarListenner());
            Container c = getContentPane();
            
            c.setLayout(new GridLayout(3,2));
            c.add(new JLabel("Login: "));
            c.add(Login);
            c.add(new JLabel("Senha: "));
            c.add(Senha);
            c.add(Entrar);
            c.add(Cancelar); 
            
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(300,200);
            setLocationRelativeTo(null);
         
        }
        
        class BotaoEntrarListenner implements ActionListener{
            @Override
             public void actionPerformed(ActionEvent e){
                 
                     if(Login.getText().equals("Usuario") && Senha.getText().equals("1234")){
                         JOptionPane.showMessageDialog(null, "BEM VINDO !");
                         setEntrou(true);
                         dispose();
                     }
                     else{
                         JOptionPane.showMessageDialog(null, "Login ou Senha errado !");
                         Login.setText("");
                         Senha.setText("");   
                     }
                     
                     
                }
              }
        
        
        class BotaoCancelarListenner implements ActionListener{
             @Override
             public void actionPerformed(ActionEvent e){
                 Login.setText("");
                 Senha.setText("");
                 
            }
        }
}
