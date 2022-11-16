public class SetCovering {
    // Atributos
    private int[] cost;
    private int[][] restriction;

    // Constructor
    public SetCovering(int[] cost, int[][] restriction) {
        this.cost = cost;
        this.restriction = restriction;
    }

    // Metodos
    public void setCost(int[] cost) {
        this.cost = cost;
    }

    public int getCost(int s) {
        return cost[s];
    }

    public boolean validate(Star star) {
        boolean validated;
        int cont = 0; // Suma 1 por cada linea de restriccion que es cubierta
        for (int i = 0; i < restriction.length; i++) {
            int suma = 0; // Suma de star por la restriccion i
            for (int j = 0; j < restriction[0].length; j++) {
                suma = suma + (star.getPosicion(j) * restriction[i][j]);
            }
            if (suma >= 1) {
                cont = cont + 1; // restriccion i cubierta
            }
        }
        validated = (cont == restriction.length) ? true : false; // Si cont es igual a "m", todas las restricciones
                                                                 // del problema estan cubiertas.

        return validated;
    }
}