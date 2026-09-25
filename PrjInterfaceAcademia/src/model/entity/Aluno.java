package model.entity;

import java.time.LocalDate;

public class Aluno implements Pessoa {
    private String codigo;
    private LocalDate dataNascimento;
    private Plano tipo;

    public Aluno(String codigo, String nome, String cpf, LocalDate dataNascimento, Plano tipo) {
        super();
        this.codigo = codigo;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Plano getTipo() {
        return tipo;
    }

    public void setTipo(Plano tipo) {
        this.tipo = tipo;
    }

}