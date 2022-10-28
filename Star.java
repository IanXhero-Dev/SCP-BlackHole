import javax.swing.text.Position;

public class Star {
    // Atributos
    private int[] posicion;
    private int fitness;

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
        float xj;
        for (int i=0; i<posicion.length; i++){
            xj=
        }
    }

    private int transform(float resultado) {

    }

    public eventHorizon(){

    }

}
