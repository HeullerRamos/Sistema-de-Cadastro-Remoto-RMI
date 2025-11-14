package com.github.heuller;

import java.io.Serializable;

public class Aluno implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private String curso;

    public Aluno(int id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno [ID=" + id + ", Nome=" + nome + ", Curso=" + curso + "]";
    }
}
