public class Node {

    Palavra elemento;  // elemento armazenado no nó
    Node left, right, parent; // apontadores do nó

    Node(Palavra elemento) {
        this.elemento = elemento;
        left = right = parent = null;
    }

    public void mostraNo(){
        System.out.print(elemento.getPalavra() + " ");
    }   
}
