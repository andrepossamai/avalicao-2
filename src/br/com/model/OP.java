
package br.com.model;

public class OP {
    
    private int id;
    private String cliente;
    private String funcionario;
    private String servico;
    private int numeropecas;
    private String lote;

    public OP() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getNumeropecas() {
        return numeropecas;
    }

    public void setNumeropecas(int numeropecas) {
        this.numeropecas = numeropecas;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

}