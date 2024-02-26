package Repository;

import Enums.ETipoMotorizacao;
import Entities.Veiculo;
import Interface.IRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Repository implements IRepository {
    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    @Override
    public Boolean CadastrarVeiculo(Veiculo veiculo) {
        return veiculos.add(veiculo);
    }

    @Override
    public ArrayList<Veiculo> ListarTodosVeiculos(){
            if(!veiculos.isEmpty())
                return veiculos;
            return null;
    }

    @Override
    public ArrayList<Veiculo> ListarVeiculosMaiorAutonomia() throws Exception{
        ArrayList<Veiculo> veiculosComMaiorAutonomia = new ArrayList<>();
        ArrayList<Veiculo> veiculosCopiados = new ArrayList<>(veiculos);

        for(int i = 0; i < 10; i++){
            Veiculo veiculoComMaiorAutonomia = null;
            double maiorAutonomia = Double.MIN_VALUE;

            for(Veiculo veiculo : veiculosCopiados)
                if(veiculo.getAutonomia() > maiorAutonomia){
                    maiorAutonomia = veiculo.getAutonomia();
                    veiculoComMaiorAutonomia = veiculo;
                }

            if (veiculoComMaiorAutonomia != null){
                veiculosComMaiorAutonomia.add(veiculoComMaiorAutonomia);
                veiculosCopiados.remove(veiculoComMaiorAutonomia);
            }
        }

        return veiculosComMaiorAutonomia;
    }

    @Override
    public ArrayList<Veiculo> ListarVeiculosMenorAutonomia() {
        ArrayList<Veiculo> veiculosComMaiorAutonomia = new ArrayList<>();
        ArrayList<Veiculo> veiculosCopiados = new ArrayList<>(veiculos);

        for(int i = 0; i < 10; i++){
            Veiculo veiculoComMaiorAutonomia = null;
            double maiorAutonomia = Double.MIN_VALUE;

            for(Veiculo veiculo : veiculosCopiados)
                if(veiculo.getAutonomia() > maiorAutonomia){
                    maiorAutonomia = veiculo.getAutonomia();
                    veiculoComMaiorAutonomia = veiculo;
                }

            if (veiculoComMaiorAutonomia != null){
                veiculosComMaiorAutonomia.add(veiculoComMaiorAutonomia);
                veiculosCopiados.remove(veiculoComMaiorAutonomia);
            }
        }

        return veiculosComMaiorAutonomia;
    }

    @Override
    public ArrayList<Veiculo> ListarVeiculosPorMotorizacao(ETipoMotorizacao motorizacao) {
        var filter = veiculos.stream().filter(v -> v.getTipoMotorizacao().equals(motorizacao))
                .collect(Collectors.toList());

        return new ArrayList<>(filter);
    }

    @Override
    public void Abastecer(ETipoMotorizacao tipoMotorizacao, double qtdCombustivel) {
        var veiculoParaAbastecer = ListarVeiculosPorMotorizacao(tipoMotorizacao);

        for(Veiculo veiculo : veiculoParaAbastecer){
            var qtdDisponivel = veiculo.getQtdDisponivelDeTanque();

            if(qtdDisponivel >= qtdCombustivel){
                var enchendoTanque = (int)Math.round(qtdDisponivel - qtdCombustivel);
                veiculo.setCapacidadeDeTanque(enchendoTanque);
            } else{
                System.out.println("A quantidade de combustivel que você deseja inserir ultrapassa a capacidade do tanque do " + veiculo.getModelo());
            }
        }

        System.out.println("Frota abastecida com sucesso");
    }

    @Override
    public ArrayList<Veiculo> ListarVeiculosPorAutonomiaInferior(String autonomia) {
        return null;
    }
}
