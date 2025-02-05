/**
 * Un objeto de esta clase
 * guarda una lista de n�meros enteros
 * 
 * La clase incluye una serie de m�todos de instancia
 * para hacer operaciones sobre la lista
 * y dos  m�todos est�ticos para trabajar con
 * arrays de dos dimensiones
 *
 * I�igo Camarero -
 */
import java.util.Random;
import java.util.Arrays;
public class ListaNumeros {
    public static final int DIMENSION = 10;
    public static final int ANCHO_FORMATO = 6;
    public static final char CAR_CABECERA = '-';

    private static final Random generador = new Random();
    private int lista[];
    private int pos;

    /**
     * Constructor de la clase ListaNumeros
     * Crea e inicializa adecuadamente los
     * atributos
     *
     * @param n el tama�o m�ximo de la lista
     */
    public ListaNumeros(int n) {
        pos = 0;
        lista = new int [n];

    }

    /**
     * A�ade un valor al final de la lista 
     * siempre que no est� completa
     *
     * @param numero el valor que se a�ade.  
     * @return true si se ha podido a�adir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if (estaCompleta()){
            return false;
        }
        else {
            lista [pos] = numero;
            pos++;
        }
        return true;
    }

    /**
     * @return true si la lista est� completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        return pos == lista.length;
    }

    /**
     * @return true si la lista est� vac�a, false en otro caso.
     * Hacer sin if
     */
    public boolean estaVacia() {
        return pos == 0;
    }

    /**
     * @return el n� de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;
    }

    /**
     * Vac�a la lista
     */
    public void vaciarLista() {
        pos = 0;
    }

    /**
     * @return una cadena con representaci�n textual de la lista 
     * (leer enunciado)
     * 
     * Si la lista est� vac�a devuelve ""
     */
    public String toString() {
        if (estaVacia()) {
            return "";
        }
        else {
            String salida = "";
            salida += guion(6 * pos);
            salida +="\n";
            for (int i = 0;i < pos;i++) {

                salida += Utilidades.centrarNumero(lista[i],ANCHO_FORMATO);

            }
            salida +="\n";
            salida += guion(6 * pos);
            return salida;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    private String guion(int y)
    {
        String resul ="";
        int i = 0;
        while (i < y) {
            resul += CAR_CABECERA;
            i ++;
        }
        return resul;
    }

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     *  
     * @return el segundo valor m�ximo en la lista
     * Cuando no haya un segundo m�ximo el m�todo 
     * devolver� el valor Integer.MIN_VALUE
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} se devuelve 28
     * Si lista = {21, -5, 28, -7, 77} se devuelve 28
     * Si lista = {77, 21} se devuelve 21
     * Si lista = {21} se devuelve Integer.MIN_VALUE
     * Si lista = {21, 21, 21, 21} se devuelve Integer.MIN_VALUE
     * 
     * No se puede usar ning�n otro array auxiliar ni hay que ordenar previamente
     * la lista
     */
    public int segundoMaximo() {      
        int maximo = Integer.MIN_VALUE;
        int segundomax = Integer.MIN_VALUE;
        boolean comprobar = false;
        if (pos == 1) {
            return segundomax;
        }

        
        if( comprobar) {
            segundomax = Integer.MIN_VALUE;
        }
        for(int i = 0; i < pos;i++) {
            if (lista[i] > segundomax && lista[i] < maximo) {
                segundomax = lista [i];

            }

        }
        for(int i = 0; i < pos;i++) {
            if (lista[i] > maximo) {
                maximo = lista [i];
            }

        }
        for(int i = 1; i < pos;i++) {
            if(lista[i] == lista[i - 1]) {
                comprobar = true;
            }
            else {
                comprobar = false;
                return segundomax;
            }
        }

        return segundomax;
    }

    /**
     * El m�todo coloca los valores que son segundos m�ximos al principio de
     * la lista respetando el orden de aparici�n del resto de,m elementos
     * 
     * No se puede usar ning�n otro array auxiliar ni hay que ordenar previamente
     * la lista
     * 
     * Si lista = {21, -5, 28, -7, 28, 77, 77, -17, 21, 15, 28, 28, 77} 
     * lista queda  {28, 28, 28, 28, 21, -5, -7, 77, 77, -17, 21, 15, 77} y se devuelve true
     * 
     * Si lista = {77, 21} lista queda {21, 77} y se devuelve true
     * Si lista = {21} lista queda igual y se devuelve false
     * Si lista = {21, 21, 21, 21} lista queda igual y se devuelve false
     * 
     * @return true si se han colocado los segundos m�ximos
     *   
     *  
     *  false si no se han colocado los segundos m�ximos porque no hab�a ninguno
     */
    public boolean segundosMaximosAlPrincipio() {
        if (lista.length == 1){
            return false;
        }
        
        return true;
    }

    /**
     * @param numero b�squeda binaria de  numero en lista
     * @return devuelve -1 si no se encuentra o la posici�n en la que aparece
     *  
     * El array original lista no se modifica
     * Para ello crea  previamente una copia
     * de lista y trabaja  con la copia
     *  
     * Usa exclusivamente m�todos de la clase Arrays
     */
    public int buscarBinario(int valor) {
        int [] arraycopia = Arrays.copyOf(lista,lista.length);
        Arrays.sort (arraycopia);
        int izqu = 0;
        int dcha = lista.length - 1;
        while (izqu <= dcha) {
            int mitad = (izqu + dcha) /2;
            if (arraycopia [mitad] == valor){
                return mitad;
            }
            else if (arraycopia[mitad] > valor){
                dcha = mitad -1;
            }
            else {
                izqu = mitad + 1;
            }
        }   
        return -1;
    } 

    /**
     * 
     * @return devuelve un array bidimensional de enteros de tama�o DIMENSION
     * inicializado con valores aleatorios entre 0 y 10 inclusive
     * 
     * Estos valores van a representar el brillo de una zona del espacio
     * 
     */
    public static int[][] crearBrillos() {
        int matriz [][] = new int [DIMENSION][DIMENSION];
        for (int fila = 0;fila < matriz.length;fila++){
            for(int colum = 0;colum < matriz[fila].length;colum++){
                matriz[fila][colum]= generador.nextInt(11);
            }
        }
        return matriz;
    }

    /**
     * @param  un array bidimensional brillos 
     * @return un nuevo array bidimensional de valores booleanos
     *          de las mismas dimensiones que el array brillos con
     *          valores true en las posiciones donde hay estrellas
     * 
     * Una posici�n f,c del array brillos es una estrella 
     * si la suma del valor de los brillos de sus cuatro vecinos 
     * (arriba, abajo, derecha e izquierda) es mayor que 30
     * 
     * Nota -  No hay estrellas en los bordes del array brillos
     */
    public static boolean[][] detectarEstrellas(int [][] matriz) {
        boolean [][] resultado = new boolean[DIMENSION][DIMENSION];
        matriz = crearBrillos();
        for(int fila = 1; fila < matriz.length -1;fila++) {
            for(int colum = 1;colum < matriz[fila].length - 1;colum++) {
                int conjunto = matriz[fila][colum + 1] + matriz[fila + 1][colum] + matriz[fila - 1][colum]+ matriz[fila][colum];
                if(30 < conjunto) {
                    resultado[fila][colum] = true;
                }
            }
        }
        return resultado;
    }
}

