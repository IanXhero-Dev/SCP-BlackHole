import java.lang.Math;

public class Star {
    // Atributos
    private int[] posicion;
    private int fitness;

    // Constructor
    public Star() {
        for (int i = 0; i < 6; i++) {
            posicion[i] = (Math.random() > 0.5) ? 1 : 0;
        }
    }

    // Metodos
    public void setPosicion(int[] position) {
        posicion = position;
    }

    public int getPosicion(int index) {
        return posicion[index];
    }

    public void setFitness(SetCovering scp) {
        for (int i = 0; i < 6; i++) {
            fitness = fitness + scp.getCost(i) * posicion[i];
        }
    }

    public int getFitness() {
        return fitness;
    }

    public void movement(Star bh) {
        double xj;
        for (int i = 0; i < posicion.length; i++) {
            xj = posicion[i] + Math.random() * (bh.getPosicion(i) - posicion[i]);
            posicion[i] = transform(xj);
        }
    }

    private int transform(double resultado) {
        int posicion_final;
        resultado = 1 / (1 + Math.pow(Math.E, resultado));
        posicion_final = (resultado >= 0.70) ? 1 : 0;
        return posicion_final;
    }
}
