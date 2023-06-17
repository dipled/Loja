public class Post {
  
  private int id;
  private String titulo;
  private String descricao;
  private Grupo grupo;

  public Post(int id, String titulo, String descricao, Grupo grupo) {
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.grupo = grupo;
  }

  public int getId() {
    return this.id;
  }

  public Grupo getGrupo() {
    return this.grupo;
  }

  public void setGrupo(Grupo grupo) {
    this.grupo = grupo;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


  @Override
  public String toString() {
      return "{" +
          " id='" + getId() + "'" +
          ", titulo='" + getTitulo() + "'" +
          ", descricao='" + getDescricao() + "'" +
          "}";
  }
}
