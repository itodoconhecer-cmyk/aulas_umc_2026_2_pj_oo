package model;

import model.valueObjects.DemaisDados;
import model.valueObjects.Tipo;
import model.valueObjects.ValorDoc;

public class Documento {
    private Tipo tipo;
    private ValorDoc valor;
    private DemaisDados demaisDados;

    public Documento(Tipo tipo, ValorDoc valor, DemaisDados demaisDaddos) {
        this.tipo = tipo;
        this.valor = valor;
        this.demaisDados = demaisDados;
    }

    public Documento() {
    }

    public void exibir() {
        System.out.println(this.tipo.getValor() + ", " + this.valor.getValor() + " - " + this.demaisDados.getValor());
    }
}
