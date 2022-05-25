public class ABB {

    private Node root; // raiz da árvore   

    ABB() {
        // Cria uma árvore binária vazia  
        root = null;
    }

    public boolean isEmpty() {
        // Verifica se a árvore está vazia    
        return root == null;
    }

    public Node root() {
        // Devolve a raiz da árvore.   
        return root;
    }

    public boolean isLeaf(Node n) {
        // Verifica se um nó n é uma folha
        return n.left == null && n.right == null;
    }

    public void executaPreOrdem(Node no) {
        if (no == null) {
            return;
        }
        no.mostraNo();
        executaPreOrdem(no.left);
        executaPreOrdem(no.right);
    }

    public void executaInOrdem(Node no) {
        if (no == null) {
            return;
        }
        executaInOrdem(no.left);
        no.mostraNo();
        executaInOrdem(no.right);
    }

    public void executaPosOrdem(Node no) {
        if (no == null) {
            return;
        }
        executaPosOrdem(no.left);
        executaPosOrdem(no.right);
        no.mostraNo();
    }

    public void insere(Node z) {
        Node y = null;
        Node x = root();
        int result,result2= 0;
        while (x != null) {
            y = x;
            result = x.elemento.getPalavra().compareTo(z.elemento.getPalavra());
            result2 = y.elemento.getPalavra().compareTo(z.elemento.getPalavra());
            if (result < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (result2 < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public Node busca(Node k) {
        Node y = root();
        int result2= 0;
        while (y != null) {
            result2 = y.elemento.getPalavra().compareTo(k.elemento.getPalavra());
            if (result2 == 0) {
                return y;
            } else if (result2 > 0) {
                y = y.right;
            } else {
                y = y.left;
            }
        }
        return null;
    }

    public Node maximo(Node x) {
        //Node<E> x = root();
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public Node minimo(Node n) {
        Node x = n;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

}
