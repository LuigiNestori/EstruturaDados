public class Palavra {
    
    private String palavra;
    private int ocorrencias;

    public Palavra(String palavra, int ocorrencias) {
        this.palavra = palavra;
        this.ocorrencias = ocorrencias;
    }

    public String getPalavra() {
        return palavra;
    }
    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
    public int getOcorrencias() {
        return ocorrencias;
    }
    public void setOcorrencias(int ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    
}
