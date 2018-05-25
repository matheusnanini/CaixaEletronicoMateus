
package caixaeletronico;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String logradouro,numero,cidade,estado,codigo;
        int op,op2;
        
JOptionPane.showMessageDialog(null, "Inicializar o Caixa", "Mensagem  Inicial", JOptionPane.INFORMATION_MESSAGE);
		
		
		
		
		logradouro = JOptionPane.showInputDialog("Entre com a RUA do caixa: ");  	
		numero = JOptionPane.showInputDialog("Entre com o NUMERO do lote na rua em que esta o caixa caixa: ");
		cidade = JOptionPane.showInputDialog("Entre com a CIDADE: ");  
		estado = JOptionPane.showInputDialog("Entre com o ESTADO: ");  
		codigo = JOptionPane.showInputDialog("Entre com o CODIGO do caixa EX.: (AA123): ");
		
      
        CaixaEletronico caixa = new CaixaEletronico(logradouro,numero,cidade,estado,codigo);
    	String msg ="";
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog("Menu\n\n0: Sair \n1: Informacoes do caixa \n2: Operacoes \n3: Saque \n4:Sobre"));
            switch (op){
                case 1:
                	msg="Saldo Caixa: "+caixa.getCodigo()+"R$ "+caixa.saldo();
            		JOptionPane.showMessageDialog(null, msg, "Informacoes",JOptionPane.INFORMATION_MESSAGE);
            		
            		
                    break;
                case 2:
                    do{
                        op2 = Integer.parseInt(JOptionPane.showInputDialog("Digite \n\n0: Voltar\n1: Saldo Caixa\n2:Saldo Bandeja 1 \n3:Saldo Bandeja 2 \n4:Saldo Bandeja 3\n5: Saldo Bandeja 4"));

                    switch (op2){                        case 1:
                        	msg ="\n\nSaldo Geral: "+caixa.getCodigo()+"   R$ "+caixa.saldo();
                    		JOptionPane.showMessageDialog(null,  msg, "Saldo",JOptionPane.INFORMATION_MESSAGE);

                            break;
                        case 2:
                        	 msg ="\n\nSaldo bandeja 1: R$ "+caixa.saldoBandeja(0);
                    		JOptionPane.showMessageDialog(null, msg, "Saldo", JOptionPane.INFORMATION_MESSAGE);

                            break;
                        case 3:
                            msg ="\n\nSaldo bandeja 1: R$ "+caixa.saldoBandeja(1);
                    		JOptionPane.showMessageDialog(null,  msg, "Saldo bandeja 1",JOptionPane.INFORMATION_MESSAGE);
                            break; 
                        case 4:
                        	msg ="\n\nSaldo bandeja 1: R$ "+caixa.saldoBandeja(2);
                    		JOptionPane.showMessageDialog(null,  msg, "Saldo bandeja 2",JOptionPane.INFORMATION_MESSAGE);

                            break;
                        case 5:
                        	msg ="\n\nSaldo bandeja 1: R$ "+caixa.saldoBandeja(3);
                    		JOptionPane.showMessageDialog(null, "Saldo bandeja 3", msg, JOptionPane.INFORMATION_MESSAGE);

                            break;                        
                    }}while (op2 != 0);
                    break;
                case 3:
                	double op3 = 0.0;
                	op3= Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser sacado"));
                
                    if(caixa.sacar(op3)==true){
                        System.out.println(caixa.realizarSaque());
                    }else{
                        if(op3>caixa.saldo()){
                        	msg ="Saldo do caixa insuficiente.\n\n Valor disponivel: " +caixa.saldo();
                    		JOptionPane.showMessageDialog(null, "Saldo", "Saldo do caixa insuficiente.", JOptionPane.INFORMATION_MESSAGE);

   
                        }else{
                        	JOptionPane.showMessageDialog(null, "Saldo", "Nao Disponivel.", JOptionPane.INFORMATION_MESSAGE);
                        }    
                    }
                    break;
                case 4:
                	JOptionPane.showMessageDialog(null, msg, "Informacoes",JOptionPane.INFORMATION_MESSAGE);
            		
                break;
            }
        }while(op != 0);
    }
    
}

