package Repository;

import Enums.ETipoMotorizacao;
import Entities.Veiculo;
import Interface.IRepository;

import java.util.*;
import java.util.stream.Collectors;

public class Repository implements IRepository {
    private static Map<String, ArrayList<String>> marcaEModeloMap = new HashMap<>();
    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public Repository(){
        MapeandoAsMarcasEModelos();
    }

    @Override
    public Boolean CadastrarVeiculo(Veiculo veiculo) throws Exception{
        if(!ValidarVeiculo(veiculo.getMarca(), veiculo.getModelo()))
            throw new Exception("Erro ao cadastrar veiculo: "
                    + veiculo.getMarca() + "-" + veiculo.getModelo() + ", confira se a marca do carro é do modelo correto");

        return veiculos.add(veiculo);
    }

    private boolean ValidarVeiculo(String marca, String modelo) {
        ArrayList<String> modelosValidos = marcaEModeloMap.get(marca);
        return modelosValidos != null && modelosValidos.contains(modelo);
    }

    @Override
    public ArrayList<Veiculo> ListarTodosVeiculos(){
            if(!veiculos.isEmpty())
                return veiculos;
            return null;
    }

    @Override
    public ArrayList<Veiculo> ListarVeiculosMaiorAutonomia() throws Exception{
        List<Veiculo> veiculosOrdenados = veiculos.stream()
                .sorted(Comparator.comparing(Veiculo::getAutonomia).reversed())
                .limit(10)
                .collect(Collectors.toList());

        return  new ArrayList<>(veiculosOrdenados);
    }

    @Override
    public ArrayList<Veiculo> ListarVeiculosMenorAutonomia() {
        List<Veiculo> veiculosOrdenados = veiculos.stream()
                .sorted(Comparator.comparing(Veiculo::getAutonomia))
                .limit(10)
                .collect(Collectors.toList());

        return  new ArrayList<>(veiculosOrdenados);
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
                System.out.println(veiculo.getModelo() + " abastecido com sucesso - Capacidade atual do tanque: " + veiculo.getCapacidadeDeTanque());
            } else{
                System.out.println("A quantidade de combustivel que você deseja inserir ultrapassa a capacidade do tanque do " + veiculo.getModelo());
            }
        }
    }

    @Override
    public ArrayList<Veiculo> ListarVeiculosPorAutonomiaInferior(double autonomia) throws Exception{
        ArrayList<Veiculo> veiculosComAutonomiaInferior = new ArrayList<>();

        for(Veiculo veiculo : veiculos)
            if(veiculo.getAutonomia() < autonomia)
                veiculosComAutonomiaInferior.add(veiculo);

        if(veiculosComAutonomiaInferior.isEmpty())
            throw new Exception("Não há veiculos com autonomia inferior ao que foi inserido.");

        return veiculosComAutonomiaInferior;
    }

    private static void MapeandoAsMarcasEModelos()
    {
        marcaEModeloMap.put("chevrolet", new ArrayList<>());
        marcaEModeloMap.put("ford", new ArrayList<>());
        marcaEModeloMap.put("volkswagen", new ArrayList<>());
        marcaEModeloMap.put("fiat", new ArrayList<>());
        marcaEModeloMap.put("renault", new ArrayList<>());
        marcaEModeloMap.put("toyota", new ArrayList<>());
        marcaEModeloMap.put("hyundai", new ArrayList<>());
        marcaEModeloMap.put("honda", new ArrayList<>());
        marcaEModeloMap.put("volkswagen", new ArrayList<>());
        marcaEModeloMap.put("fiat", new ArrayList<>());
        marcaEModeloMap.put("byd", new ArrayList<>());

        marcaEModeloMap.get("chevrolet").add("onix");
        marcaEModeloMap.get("chevrolet").add("classic");
        marcaEModeloMap.get("volkswagen").add("fox");
        marcaEModeloMap.get("volkswagen").add("gol");
        marcaEModeloMap.get("fiat").add("uno");
        marcaEModeloMap.get("fiat").add("palio");
        marcaEModeloMap.get("renault").add("duster");
        marcaEModeloMap.get("renault").add("kwid");
        marcaEModeloMap.get("toyota").add("corolla");
        marcaEModeloMap.get("toyota").add("etios");
        marcaEModeloMap.get("hyundai").add("hb20");
        marcaEModeloMap.get("honda").add("civic");
        marcaEModeloMap.get("ford").add("ka");
        marcaEModeloMap.get("ford").add("fiesta");
        marcaEModeloMap.get("byd").add("dolphin");
    }
}
