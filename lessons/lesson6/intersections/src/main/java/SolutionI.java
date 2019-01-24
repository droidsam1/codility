import java.util.Arrays;

class SolutionI {
    static int solution(int[] A) {
        final int numeroCirculos = A.length;

        if (numeroCirculos < 2) {
            return 0;
        }

        long[] aperturasCirculos = new long[numeroCirculos];
        long[] cierresCirculos = new long[numeroCirculos];

        for (int i = 0; i < numeroCirculos; i++) {
            long radio = (long) A[i];
            //centro - radio
            long aperturaCirculo = i - radio;
            aperturasCirculos[i] = aperturaCirculo;

            //centro + radio
            long cierreCirculo = i + radio;
            cierresCirculos[i] = cierreCirculo;
        }

        Arrays.sort(aperturasCirculos);
        Arrays.sort(cierresCirculos);

        int intersecciones = 0;
        int circulosAbiertos = 0;
        int index = 0;


        for (long cierre : cierresCirculos) {
            //Para el cierre X cuantos circulos abiertos (aperturas) son menores al cierre
            while (index < numeroCirculos && aperturasCirculos[index] <= cierre) {
                circulosAbiertos++;
                index++;
            }

            //resto el propio circulo, no interseca consigo mismo
            circulosAbiertos = circulosAbiertos - 1;

            intersecciones += circulosAbiertos;

            //condicion
            if (intersecciones > 10000000) {
                return -1;
            }
        }
        return intersecciones;
    }

}