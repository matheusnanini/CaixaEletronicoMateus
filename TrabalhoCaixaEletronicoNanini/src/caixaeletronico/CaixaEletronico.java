package caixaeletronico;


public class CaixaEletronico {
    private final Bandeja b[] = new Bandeja[4];
    private final Logradouro logradouro;
    private final String codigo;
    String s0,s1,s2,s3;
 
    public CaixaEletronico(String logradouro,String numero,String cidade,String estado,String codigo) {
        this.logradouro = new Logradouro(logradouro,numero,cidade,estado);
        this.b[0] = new Bandeja(100,100);
        this.b[1] = new Bandeja(50,100);
        this.b[2] = new Bandeja(20,100);
        this.b[3] = new Bandeja(10,100);
     
        
        this.codigo = codigo.toUpperCase();
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public String realizarSaque(){
        return s0+s1+s2+s3;
    }
  
    public double saldo(){
    return (b[0].getValorFace()*b[0].getQntNotas()+b[1].getValorFace()*b[1].getQntNotas()+
            b[2].getValorFace()*b[2].getQntNotas()+b[3].getValorFace()*b[3].getQntNotas());
    }
    
    public double saldoBandeja(int s){
        return b[s].getQntNotas()*b[s].getValorFace();
    }
       
    public boolean sacar(double valor){
    int contador0 = 0, contador1 = 0, contador2 = 0, contador3 = 0;

    if(valor<=this.saldo()){
        
        do{
            if(valor/b[0].getValorFace()>=1&&(b[0].getQntNotas()-contador0)>0){
            contador0++;
            valor -= b[0].getValorFace();
            }
        }while(valor/b[0].getValorFace()>=1&&(b[0].getQntNotas()-contador0)>0);
        
        do{
            if(valor/b[1].getValorFace()>=1&&(b[1].getQntNotas()-contador1)>0){
            contador1++;
            valor -= b[1].getValorFace();
            }
        }while(valor/b[1].getValorFace()>=1&&(b[1].getQntNotas()-contador1)>0);
    
        do{
            if(valor/b[2].getValorFace()>=1&&(b[2].getQntNotas()-contador2)>0){
            contador2++;
            valor -= b[2].getValorFace();
            }
        }while(valor/b[2].getValorFace()>=1&&(b[2].getQntNotas()-contador2)>0);       
   
        do{
            if(valor/b[3].getValorFace()>=1&&(b[3].getQntNotas()-contador3)>0){
            contador3++;
            valor -= b[3].getValorFace();
            }
        }while(valor/b[3].getValorFace()>=1&&(b[3].getQntNotas()-contador3)>0);
        
        if(contador0>0){
            this.s0 = Integer.toString(contador0)+ " Nota(s) de 100  ";
        }else this.s0="";
        if(contador1>0){
            this.s1 = Integer.toString(contador1)+ " Nota(s) de 50   ";
        }else this.s1="";
        if(contador2>0){
            this.s2 = Integer.toString(contador2)+ " Nota(s) de 20   ";
        }else this.s2="";
        if(contador3>0){
            this.s3 = Integer.toString(contador3)+ " Nota(s) de 10   ";
        }else this.s3="";

        } if(valor == 0){
            b[0].retirarNotas(contador0);
            b[1].retirarNotas(contador1);
            b[2].retirarNotas(contador2);
            b[3].retirarNotas(contador3);
            return true;
        }else
            return false;
    }
    
    @Override
    public String toString() {
        return "   Caixa: "+this.codigo+"\n   "+logradouro.toString();
    }
    
    
}
