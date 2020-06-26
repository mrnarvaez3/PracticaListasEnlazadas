import java.util.Scanner;

class Nodo{
    public int valor;
    public Nodo sgt;
    public Nodo(int valor){
        this.valor = valor;
        this.sgt = null;
    }
    public Nodo(int valor, Nodo sgt){
        this.valor = valor;
        this.sgt = sgt;
    }
}

public class PruebaNodos {
    public static Nodo np;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        int valorAgregar;
        int valorEliminar;
        do {
            System.out.println("--------------------------");
            System.out.println("Digite una opcion:");
            System.out.println("1. Agregar Nodo ");
            System.out.println("2. Eliminar Nodo");
            System.out.println("3. Visualizar lista");
            System.out.println("4. Salir");
            System.out.println("--------------------------");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor del nodo Agregado");
                    valorAgregar = teclado.nextInt();
                    np = insertar(np,valorAgregar); // se envia el primer nodo y el nodo del valor a agregar
                    break;
                case 2:
                    System.out.println("Ingrese el valor del nodo a eliminar: ");
                    valorEliminar = teclado.nextInt();
                    EliminarNodo(valorEliminar); // se envia el valor del nodo a eliminar
                    break;
                case 3:
                    PresentarLista(np); // se envia el primer nodo para recorrerlo y presentar
                    break;
            }
        }while (opcion != 4); // sale del programa
    }

    /**
     * Metodo recursivo para la insercion de nodos
     * @param np
     * @param valorAg
     * @return
     */
    public static Nodo insertar(Nodo np, int valorAg){
        if (np == null)
            return new Nodo(valorAg);
        else
            np.sgt = insertar(np.sgt, valorAg);
        return np;
    }

    /**
     * Metodo para la presentacion de los nodos
     * @param np
     */
    public static void PresentarLista(Nodo np) {
        Nodo aux = np;
        System.out.println("-------------------------------------");
        System.out.println("\n|PRESENTANDO LISTA DE NODOS|\n");
        while (aux != null) {
            System.out.format("Valor = %d \tNodo = %s\n", aux.valor, aux.sgt);
            aux = aux.sgt;
        }
    }

    /**
     * Metodo para eliminar un nodo segun su valor
     * @param val
     * @param val
     */
     public static void EliminarNodo(int val){
         Nodo actual;
         Nodo anterior;
         actual = np;
         anterior = null;
         while (actual != null){// ciclo para recorrer el nodo
             if (actual.valor == val){ // preguntamos si el valor del nodo coincide con el valor del nodo a eliminar
                if (actual == np) { // si el nodo a eliminar es el primero
                    np = np.sgt; // el segundo nodo sera la cabeza de la lista
                }else{
                    anterior.sgt = actual.sgt; // nodo anterior va a apuntar al nodo siguiente de actual
                                                // por lo tanto el nodo que constaba en actual sera eliminado
                }
             }
             anterior = actual; // anterior va ocupando la casilla que va dejando actual
             actual = actual.sgt; // apuntamos al siguiente nodo para recorrerlo
         }
    }
}
