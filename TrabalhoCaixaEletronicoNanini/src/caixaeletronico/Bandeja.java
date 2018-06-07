package caixaeletronico;

public class Bandeja {
    private final double valorFace;
    private int qntNotas;

    public Bandeja(double valorFace, int qntNotas) {
        this.valorFace = valorFace;
        this.qntNotas = qntNotas;
    }  
    public double getValorFace() {
        return valorFace;
    }
    
    public int getQntNotas() {
        return qntNotas;
    }

    public void retirarNotas(int s){
        this.qntNotas -= s;
    }
    
}
