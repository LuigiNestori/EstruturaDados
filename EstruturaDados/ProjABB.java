import java.io.*;
import java.util.Scanner;

public class ProjABB {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        int cont = 0;
        int cont2 = 0;
        ABB tree = new ABB();

        do{
            System.out.println("\n-----------------------------\n1- Carregar texto\n2- Contador de palavras\n3- Buscar por palavra\n4- Exibicão do texto\n5- encerrar");
            opt = scanner.nextInt();
            switch(opt){
                case 1:
                    FileReader data;
                    try {
                        data = new FileReader("texto.txt");
                        BufferedReader linha = new BufferedReader(data);
                        String aux = linha.readLine();
                        while(aux != null) {
                            String[] result = aux.split(" ");
                            for(int i = 0; i < result.length; i++){
                                Palavra palavra = new Palavra(result[i], 1);
                                Node no = new Node(palavra);
                                Node aux1 = tree.busca(new Node(palavra));
                                cont++;
                            if (aux1==null){
                                tree.insere(no);
                                cont2++;
                            }
                             else
                                aux1.elemento.setOcorrencias(aux1.elemento.getOcorrencias()+1);
                            }
                        aux = linha.readLine();
                    }
                        data.close();
                    }
                    catch (FileNotFoundException e) {
                    System.out.println("Arquivo de dados não encontrado!!");
                    System.exit(0);
                    }
                    System.out.println("TEXTO CARREGADO");
                    break;
                    
                case 2:
                    System.out.println("Quantidade de palavras na árvore: "+ cont);
                    System.out.println("Quantidade de palavras na música: "+ cont2);
                    break;

                case 3:
                    System.out.println("Palavra a ser pesquisada");
                    String word = scanner.next();
                    Palavra palavrinha = new Palavra(word, 0);
                    Node aux = tree.busca(new Node(palavrinha));
                    if (aux==null)
                        System.out.println("\nNão existe a palavra procurada na árvore");
                    else
                        System.out.println("\nA palavra " + aux.elemento.getPalavra() + " está na árvore e aparece "+ aux.elemento.getOcorrencias()+" vezes");
                        break;
                case 4:
                    System.out.println("\n\nPercurso In-Ordem");
                    tree.executaInOrdem(tree.root());
                    System.out.println("\n\nPercurso Pré-Ordem");
                    tree.executaPreOrdem(tree.root());
                    System.out.println("\n\nPercurso Pós-Ordem");
                    tree.executaPosOrdem(tree.root());
                    break;  
            }    
        }while(opt != 5);
        System.out.println("Programa encerrado");      
        scanner.close();  
    }    
}
