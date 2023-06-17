import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
    public ArrayList<Jogo> biblioteca = new ArrayList<Jogo>();
    public ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
    public ArrayList<Grupo> grupos = new ArrayList<Grupo>();
    public ArrayList<Post> posts = new ArrayList<Post>();
    public ArrayList<Usuario> amigos = new ArrayList<Usuario>();

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String senha, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Usuario(String nome, String email, String senha, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Jogo> getBiblioteca() {
        return this.biblioteca;
    }

    public void setBiblioteca(ArrayList<Jogo> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public ArrayList<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Post> getPosts() {
        return this.posts;
    }

    public void setPosts(ArrayList<Post> post) {
        this.posts = post;
    }

    public ArrayList<Usuario> getAmigos() {
        return this.amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        return this.email.equals(other.getEmail());
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", email='" + getEmail() + "'" +
                ", senha='" + getSenha() + "'" +
                ", telefone='" + getTelefone() + "'" +
                ", endereco='" + getEndereco() + "'" +
                "}";
    }

    public boolean comprarJogo(Jogo jogo) {
        if (!this.biblioteca.contains(jogo)) {
            this.biblioteca.add(jogo);
            return true;
        }
        return false;

    }

    public boolean adicionarAmigo(Usuario usuario) {
        if(!this.amigos.contains(usuario))
        {
            this.amigos.add(usuario);
            usuario.getAmigos().add(this);
            return true;
        }
        return false;
    }

    public boolean fazerAvaliacao(Avaliacao avaliacao) {
        if (!this.avaliacoes.contains(avaliacao)) {
            this.avaliacoes.add(avaliacao);
            return true;
        }
        return false;
    }

    public void fazerPost(Post post) {
        this.posts.add(post);
    }

    public boolean participarGrupo(Grupo grupo) {
        if(this.grupos.contains(grupo))
        {
            this.grupos.add(grupo);
            return true;
        }
        return false;
    }

    public Usuario fazerLogin(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            return this;
        }

        return null;
    }
}
