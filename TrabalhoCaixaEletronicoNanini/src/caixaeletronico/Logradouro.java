
package caixaeletronico;

public class Logradouro {
    private final String logradouro;
    private final String numero;
    private final String cidade;
    private final String estado;

    public Logradouro(String logradouro, String numero, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    
    public String toString() {
        return "Endereco : " + "Rua:" + logradouro + " numero: " + numero + "\n   Cidade: " + cidade + " Estado: " + estado;
    }
    
}
