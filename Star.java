import java.lang.Math;

public class Star {
    // Atributos
    private int[] posicion;
    private int fitness = 0;

    // Constructor
    public Star(int n) {
        this.posicion = new int[n];
        for (int i = 0; i < n; i++) {
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

    public int[] getFullPosition() {
        return posicion;
    }

    public void setFitness(SetCovering scp) {
        for (int i = 0; i < posicion.length; i++) {
            fitness = fitness + (scp.getCost(i) * posicion[i]);
        }
    }

    public int getFitness() {
        return fitness;
    }

    public void movement(Star bh, SetCovering scp) {
        double xj;
        for (int i = 0; i < posicion.length; i++) {
            System.out.println(posicion[i] + Math.random() * (bh.getPosicion(i) - posicion[i]));
            xj = posicion[i] + Math.random() * (bh.getPosicion(i) - posicion[i]);
            posicion[i] = transform(xj);
        }
        /*
         * Validacion. En caso de que no sea valido se llama a la misma funcion de forma
         * recursiva hasta que lo sea segun el SCP
         */
        if (scp.validate(this) == false) {
            // movement(bh, scp);
        }

    }

    private int transform(double resultado) {
        int posicion_final;
        resultado = 1 / (1 + Math.pow(Math.E, resultado));
        posicion_final = (resultado >= 0.70) ? 1 : 0;
        return posicion_final;
    }
}
