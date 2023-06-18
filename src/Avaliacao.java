public class Avaliacao {
    private String texto;
    private float nota;
    private Usuario autor;
    private Jogo jogoRelacionado;

    public Avaliacao() {
    }

    public Avaliacao(String texto, float nota, Usuario autor, Jogo jogoRelacionado) {
        this.texto = texto;
        this.nota = nota;
        this.autor = autor;
        this.jogoRelacionado = jogoRelacionado;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public float getNota() {
        return this.nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Jogo getJogoRelacionado() {
        return this.jogoRelacionado;
    }

    public void setJogoRelacionado(Jogo jogoRelacionado) {
        this.jogoRelacionado = jogoRelacionado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Avaliacao other = (Avaliacao) obj;
        return this.autor.equals(other.getAutor()) && this.jogoRelacionado.equals(other.getJogoRelacionado());
    }

}
