import java.util.List;
import java.util.ArrayList;

public class Swarm {
    // Atributos
    public List<Star> constelacion;
    public Star blackhole;
    public int iterations;

    // Constructor
    public Swarm(int cantidad, int n, SetCovering scp) {
        // Cantidad indica la cantidad de estrellas en la constelacion
        // n indica el largo de la estrella
        int x = 0;
        while (x < cantidad) {
            Star star = new Star(n);
            if (scp.validate(star) == true) {
                constelacion.add(star);
                star.setFitness(scp);
                x = x + 1;
            }
        }
    }

    // Metodos
    private Star generateNewStar() {
        return new Star(6);
    }

    public void eventHorizon() {
        int suma = 0;
        for (Star l : constelacion) {
            suma = suma + l.getFitness();
        }
        int R = blackhole.getFitness() / suma;

    }

    public void beginAlgorithm(SetCovering scp) {
        //
    }
}