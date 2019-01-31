import java.util.Arrays;

/**
 * En esta solución: Trata los circulos como segmentos lineares con un limite inferior (apertura) y un limite superior (cierre)
 * Para calcular las intersecciones, una ver ordenados los segmentos sobre el eje X, qué segmentos están abiertos antes de cada cierre.
 * Es decir para el cierre Y comprobar cuantos segmentos están abiertos y restarle el número de cierres hasta ese punto.
 * <p>
 * Visto desde los circulos, una vez dibujados, y observando su lado derecho. Hallaríamos las intersecciones,
 * para cada limite superior de un círculo contando cuantos círculos hay abiertos hasta el momento menos el número
 * de círculos cerrados hasta ese punto
 */
class SolutionS {
    static int solution(int[] A) {
        final int numeroCirculos = A.length;

        if (numeroCirculos < 2) {
            return 0;
        }

        long[] aperturas = new long[numeroCirculos];
        long[] cierres = new long[numeroCirculos];

        for (int i = 0; i < numeroCirculos; i++) {
            long radio = (long) A[i];
            //centro - radio
            long aperturaCirculo = i - radio;
            aperturas[i] = aperturaCirculo;
            //centro + radio
            long cierreCirculo = i + radio;
            cierres[i] = cierreCirculo;
        }
        Arrays.sort(aperturas);
        Arrays.sort(cierres);
        int intersecciones = 0;
        int j = 0;
        int aperturasTotales = 0;
        for (int i = 0; i < cierres.length; i++) {
            while (j < aperturas.length && aperturas[j] <= cierres[i]) {
                j++;
                aperturasTotales++;
            }

            intersecciones += aperturasTotales - (i + 1);
        }
        return intersecciones;
    }

}