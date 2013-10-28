package br.com.model;

import java.util.Date;

public class Funcionario extends PessoaFisica {

    private double salario;
    private Date dataAdimissao;
    private String ctps;
    private String senha;
    private String login;
    

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "salario=" + salario + ", dataAdimissao=" + dataAdimissao + ", ctps=" + ctps + ", senha=" + senha + ", login=" + login + '}';
    }
}

  