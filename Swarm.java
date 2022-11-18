import java.util.List;

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
                blackhole = star; // Caso normal, si la estrella tiene un fitness mas bajo que el blackhole, lo
                                  // reemplaza
            }
        }

        // Iniciamos el algoritmo
        int T = 0;
        while (T < iterations) {
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
                        star = generateNewStar(n);
                        if (scp.validate(star) == true) {
                            break; // Se genero una estrella valida.
                        }
                    }

                }
            }
            T = T + 1;
        }

    }
}