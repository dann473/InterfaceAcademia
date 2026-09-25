package model.entity;

public class Plano {
    private String nomePlano;
    private double precoMensal;

    public Plano(String nomePlano, double precoMensal) {
        super();
        this.nomePlano = nomePlano;
        this.precoMensal = precoMensal;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public double getPrecoMensal() {
        return precoMensal;
    }

    public void setPrecoMensal(double precoMensal) {
        this.precoMensal = precoMensal;
    }

}