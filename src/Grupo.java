import java.util.ArrayList;

public class Grupo {

  private int id;
  private String nome;
  private String descricao;
  private ArrayList<Usuario> participantes = new ArrayList<Usuario>();
  private ArrayList<Post> posts = new ArrayList<Post>();

  public Grupo(int id, String nome, String descricao) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
  }

  public Grupo(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
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

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public ArrayList<Usuario> getParticipantes() {
    return this.participantes;
  }

  public void setParticipantes(ArrayList<Usuario> participantes) {
    this.participantes = participantes;
  }

  public ArrayList<Post> getPosts() {
    return this.posts;
  }

  public void setPosts(ArrayList<Post> posts) {
    this.posts = posts;
  }

  public void fazerPost(Post post) {
    this.posts.add(post);
  }

  public boolean adicionarUsuario(Usuario usuario) {
    if (!this.participantes.contains(usuario)) {
      this.participantes.add(usuario);
      return true;
    }
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Grupo)) {
      return false;
    }
    Grupo grupo = (Grupo) o;
    return this.nome.equals(grupo.getNome());
  }

}
