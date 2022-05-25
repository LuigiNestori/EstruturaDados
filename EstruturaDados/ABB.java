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

    // public void delete(Node Tree, String Tar) {
    //     Node Min, Temp;
    //     int result = 0;
    //     if (Tree == null) { // árvore vazia
    //         return;
    //     } else {
    //         result = Tar.compareTo(Tree.elemento.getPalavra());
    //         if (result < 0) {
    //             delete(Tree.left, Tar); // buscar na esquerda
    //         } else if (result > 0) {
    //             delete(Tree.right, Tar);// buscar na direita
    //         } else {
    //             // encontrou o nó a ser deletado
    //             if (Tree.left != null && Tree.right != null) {
    //             // nó com dois filhos 
    //             Min = minimo(Tree.right);
    //             Tree.elemento = Min.elemento;
    //             delete(Tree.right, Tree.elemento.getPalavra());
    //             }
    //         } else {
    //             // nó com um ou nenhum filho
    //             if (Tree.left == null) {
    //                 if (Tree.parent == null) {
    //                     root = Tree.right; // A raiz deverá ser deletada
    //                 } else {
    //                     if (Tree.right != null) {
    //                         Tree.right.parent = Tree.parent;
    //                     }
    //                     if (Tree == Tree.parent.left) {
    //                         Tree.parent.left = Tree.right;
    //                     } else {
    //                         Tree.parent.right = Tree.right;
    //                     }
    //                 }

    //             } else if (Tree.right == null) {
    //                 if (Tree.parent == null) {
    //                     root = Tree.left; // A raiz deverá ser deletada
    //                 } else {

    //                     Tree.left.parent = Tree.parent;
    //                     if (Tree == Tree.parent.left) {
    //                         Tree.parent.left = Tree.left;
    //                     } else {
    //                         Tree.parent.right = Tree.left;
                            
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }

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

    // public Node busca(Node k) {
    //     Node y = root();
    //     while (y != null) {
    //         if (y.elemento == k.elemento) {
    //             return y;
    //         } else if (y.elemento < k.elemento) {
    //             y = y.right;
    //         } else {
    //             y = y.left;
    //         }
    //         System.out.println(y);
    //     }
    //     return null;
    // }


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
