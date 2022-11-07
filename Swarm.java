import java.util.List;
import java.util.ArrayList;

public class Swarm {
    // Atributos
    public List<Star> constelacion;
    public Star blackhole;
    public int iterations;

    // Metodos
    private Star generateNewStar() {
        return new Star();
    }

    public void eventHorizon() {
        int suma = 0;
        for (Star l : constelacion) {
            suma = suma + l.getFitness();
        }
        int R = blackhole.getFitness() / suma;

    }

    public void beginAlgorithm() {

    }
}