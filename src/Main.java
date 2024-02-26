import Enums.ETipoMotorizacao;
import Entities.Veiculo;
import Repository.Repository;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Repository repository = new Repository();

        Veiculo v1 = new Veiculo("Chevrolet", "Classic", 100.0, ETipoMotorizacao.gasolina, 50, 25.0);
        Veiculo v2 = new Veiculo("Ford", "Fiesta", 120.0, ETipoMotorizacao.gasolina, 45, 10.0);
        Veiculo v3 = new Veiculo("Volkswagen", "Gol", 110.0, ETipoMotorizacao.flex, 48, 10.0);
        Veiculo v4 = new Veiculo("Fiat", "Palio", 105.0, ETipoMotorizacao.flex, 47, 10.0);
        Veiculo v5 = new Veiculo("Renault", "Duster", 115.0, ETipoMotorizacao.diesel, 50, 30.0);
        Veiculo v6 = new Veiculo("Toyota", "Corolla", 130.0, ETipoMotorizacao.flex, 55, 0.0);
        Veiculo v7 = new Veiculo("Hyundai", "HB20", 125.0, ETipoMotorizacao.flex, 48, 0.0);
        Veiculo v8 = new Veiculo("Honda", "Civic", 140.0, ETipoMotorizacao.flex, 52, 0.0);
        Veiculo v9 = new Veiculo("Chevrolet", "Onix", 112.0, ETipoMotorizacao.flex, 48, 0.0);
        Veiculo v10 = new Veiculo("Ford", "Ka", 108.0, ETipoMotorizacao.flex, 45, 0.0);
        Veiculo v11 = new Veiculo("Volkswagen", "Fox", 117.0, ETipoMotorizacao.flex, 47, 0.0);
        Veiculo v12 = new Veiculo("Fiat", "Uno", 95.0, ETipoMotorizacao.flex, 42, 0.0);
        Veiculo v13 = new Veiculo("Renault", "Kwid", 100.0, ETipoMotorizacao.flex, 40, 0.0);
        Veiculo v14 = new Veiculo("Toyota", "Etios", 110.0, ETipoMotorizacao.flex, 45, 0.0);
        Veiculo v15 = new Veiculo("BYD", "Dolphin", 190.0, ETipoMotorizacao.eletrico, 50, 0.0);

        repository.CadastrarVeiculo(v1);
        repository.CadastrarVeiculo(v2);
        repository.CadastrarVeiculo(v3);
        repository.CadastrarVeiculo(v4);
        repository.CadastrarVeiculo(v5);
        repository.CadastrarVeiculo(v6);
        repository.CadastrarVeiculo(v7);
        repository.CadastrarVeiculo(v8);
        repository.CadastrarVeiculo(v9);
        repository.CadastrarVeiculo(v10);
        repository.CadastrarVeiculo(v11);
        repository.CadastrarVeiculo(v12);
        repository.CadastrarVeiculo(v13);
        repository.CadastrarVeiculo(v14);
        repository.CadastrarVeiculo(v15);


        // listando todos
        System.out.println("- Listando todos os veiculos:");
        for(var veiculo : repository.ListarTodosVeiculos())
            System.out.println(veiculo.getMarca() + " - " + veiculo.getModelo());

        // listando os 10 veiculos com maior autonomia
        System.out.println("\n- Listando os 10 veiculos com maior autonomia:");
        for(var veiculo : repository.ListarVeiculosMaiorAutonomia())
            System.out.println(veiculo.getMarca() + " - " + veiculo.getModelo());

        System.out.println("\n- Listando veiculos por tipo de motorização (gasolina, flex, diesel, eletrico):");
        System.out.println("\n --Gasolina:");
        for(var veiculo : repository.ListarVeiculosPorMotorizacao(ETipoMotorizacao.gasolina))
            System.out.println(veiculo.getMarca() + " - " + veiculo.getModelo());

        System.out.println("\n--Flex:");
        for(var veiculo : repository.ListarVeiculosPorMotorizacao(ETipoMotorizacao.flex))
            System.out.println(veiculo.getMarca() + " - " + veiculo.getModelo());

        System.out.println("\n--Diesel:");
        for(var veiculo : repository.ListarVeiculosPorMotorizacao(ETipoMotorizacao.diesel))
            System.out.println(veiculo.getMarca() + " - " + veiculo.getModelo());

        System.out.println("\n--Eletrico:");
        for(var veiculo : repository.ListarVeiculosPorMotorizacao(ETipoMotorizacao.eletrico))
            System.out.println(veiculo.getMarca() + " - " + veiculo.getModelo());

        // Abastecendo Veiculos
        System.out.println("\n- Abastecendo veiculos:");
        repository.Abastecer(ETipoMotorizacao.gasolina, 20);
        System.out.println(v1);
        System.out.println(v2);

    }
}