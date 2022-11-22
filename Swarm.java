import java.util.ArrayList;
import java.util.List;

public class Swarm {
    // Atributos
    public List<Star> constelacion = new ArrayList<>();
    public Star blackhole = new Star(0);
    public int iterations;

    // Constructor
    public Swarm(int cantidad, int n, SetCovering scp, int iter) {
        // Cantidad indica la cantidad de estrellas en la constelacion
        // n indica el largo de la estrella
        int x = 0;
        this.iterations = iter; // Cantidad de iteraciones
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
    private Star generateNewStar(int n) {
        return new Star(n);
    }

    public boolean eventHorizon() {
        int suma = 0;
        boolean absorbido = false;
        for (Star l : constelacion) {
            suma = suma + l.getFitness();
        }
        int R = blackhole.getFitness() / suma;

        absorbido = (R > 0.50) ? true : false;

        return absorbido;
    }

    public void beginAlgorithm(SetCovering scp, int n) {
        // Determinar el blackhole inicial
        for (Star star : constelacion) {
            if (blackhole.getFitness() == 0) {// Caso inicial, el blackhole toma los valores de la primera estrella
                blackhole = star;
            } else if (star.getFitness() < blackhole.getFitness() && blackhole.getFitness() != 0) {
                blackhole = star;
                // Caso normal, si la estrella tiene un fitness mas bajo que el blackhole, lo
                // reemplaza
            }
            System.out.println("El fitness inicial de la estrella es: " + star.getFitness());
        }
        System.out.println("El fitness inicial del BlackHole es: " + blackhole.getFitness());

        // Iniciamos el algoritmo
        int T = 0;
        while (T < iterations) {
            System.out.println("-----------------------------------------------------------------");
            for (Star star : constelacion) {
                // Movimiento y seteo fitness
                star.movement(blackhole, scp);
                star.setFitness(scp);
                // Comparar con el blackhole
                if (star.getFitness() < blackhole.getFitness()) {
                    blackhole = star;
                }
                // Verificar si es absorbida
                if (eventHorizon() == true) {
                    // Si es absorbida, se usa un bucle mientras se genera una nueva estrella
                    // valida.
                    while (true) {
                        System.out.println("La estrella fue absorbida");
                        star = generateNewStar(n);
                        if (scp.validate(star) == true) {
                            System.out.println("Se ha generado unanueva estrella");
                            break; // Se genero una estrella valida.
                        }
                    }
                }
                System.out.println("El fitness actual de la estrella es: " + star.getFitness());
            }
            System.out.println("El fitness del BlackHole es: " + blackhole.getFitness());
            T = T + 1;
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Fin del algoritmo: ");
        for (Star star : constelacion) {
            System.out.println("El fitness actual de la estrella es: " + star.getFitness());
        }
        System.out.println("El fitness del BlackHole es: " + blackhole.getFitness());
    }
}