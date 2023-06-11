public class Avaliacao {
    private String avaliacoes;
    private float nota;
//
    public Avaliacao(String avaliacoes, float nota) {
        this.avaliacoes = avaliacoes;
        this.nota = nota;
    }

    public String getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(String avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public float getNota() {
        return this.nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Avaliacao() {
    }

}
