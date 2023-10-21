package com.example.smile;

public class Trabalhadores {

    private String NOME;
    private String SETOR;
    private String META;
    private String CLO;
    private long Id;




    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getSETOR() {
        return SETOR;
    }

    public void setSETOR(String SETOR) {
        this.SETOR = SETOR;
    }
}
