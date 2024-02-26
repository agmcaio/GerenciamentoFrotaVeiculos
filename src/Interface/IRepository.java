package Interface;

import Enums.ETipoMotorizacao;
import Entities.Veiculo;

import java.util.ArrayList;

public interface IRepository {
    Boolean CadastrarVeiculo(Veiculo veiculo) throws Exception;
    ArrayList<Veiculo> ListarTodosVeiculos();
    ArrayList<Veiculo> ListarVeiculosMaiorAutonomia() throws Exception;
    ArrayList<Veiculo> ListarVeiculosMenorAutonomia();
    ArrayList<Veiculo> ListarVeiculosPorMotorizacao(ETipoMotorizacao motorizacao);
    void Abastecer(ETipoMotorizacao tipoMotorizacao, double qtdCombustivel);
    ArrayList<Veiculo> ListarVeiculosPorAutonomiaInferior(double autonomia) throws Exception;
}
