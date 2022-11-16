public class Main {

    public static void main(String[] args) {
        int coste[] = { 65, 55, 60, 45, 40, 50 };
        int restricciones[][] = {
                { 1, 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 1 },
                { 0, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 0, 1 },
                { 0, 1, 0, 0, 1, 1 }
        };
        /*
         * Estos datos son de prueba para el algoritmo, posteriormente se vera un metodo
         * para diferentes instancias.
         */
        SetCovering problema = new SetCovering(coste, restricciones);
        Swarm inicio = new Swarm(4, coste.length, problema);
        inicio.beginAlgorithm(problema);

    }
}
