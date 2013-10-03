package br.com.model;

import java.sql.Date;

public class Funcionario extends PessoaFisica {

    private double salario;
    private Date dataAdimissao;
    private String ctps;

    public Funcionario() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(Date dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }
   
}