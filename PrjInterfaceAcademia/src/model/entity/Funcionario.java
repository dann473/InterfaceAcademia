package model.entity;

public class Funcionario implements Pessoa {
    private Integer codigo;


    public Funcionario(Integer codigo, String nome, String cpf, String senha) {
        this.codigo = codigo;
    }


    public Integer getCodigo() {
        return codigo;
    }


    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }


}