package Entities;

import Enums.ETipoMotorizacao;
import lombok.Data;

@Data
public class Veiculo {
    String marca;
    String modelo;
    double autonomia;
    ETipoMotorizacao tipoMotorizacao;
    Integer capacidadeDeTanque;
    double qtdDisponivelDeTanque;

    public Veiculo(String marca, String modelo, double autonomia, ETipoMotorizacao tipoMotorizacao,Integer capacidadeDeTanque, double qtdDisponivelDeTanque){
        this.marca = marca.toLowerCase();
        this.modelo = modelo.toLowerCase();
        this.autonomia = autonomia;
        this.tipoMotorizacao = tipoMotorizacao;
        this.capacidadeDeTanque = capacidadeDeTanque;
        this.qtdDisponivelDeTanque = qtdDisponivelDeTanque;
    }

    public String toString(){
        return getMarca() + " - "
                + getModelo()
                + ": "
                + getAutonomia()
                + ", "
                + getTipoMotorizacao()
                + ", "
                + getCapacidadeDeTanque()
                + ", "
                + getQtdDisponivelDeTanque();
    }
}
