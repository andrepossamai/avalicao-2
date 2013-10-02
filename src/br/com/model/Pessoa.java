package br.com.model;

import java.util.Date;

public class Pessoa {

    private int id;
    private String nome;
    private Date dataCadastro;
    private String telefoneContato1;
    private String telefoneContato2;
    private String email; 
    private Endereco endereco; 

    public Pessoa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTelefoneContato1() {
        return telefoneContato1;
    }

    public void setTelefoneContato1(String telefoneContato1) {
        this.telefoneContato1 = telefoneContato1;
    }

    public String getTelefoneContato2() {
        return telefoneContato2;
    }

    public void setTelefoneContato2(String telefoneContato2) {
        this.telefoneContato2 = telefoneContato2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
