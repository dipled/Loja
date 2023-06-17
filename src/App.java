import java.util.*;

//
public class App {
    private ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<Desenvolvedor>();
    private ArrayList<Grupo> grupos = new ArrayList<Grupo>();
    private ArrayList<Jogo> jogos = new ArrayList<Jogo>();
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static App instance = null;

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }

        return instance;
    }

    public ArrayList<Desenvolvedor> getDesenvolvedores() {
        return this.desenvolvedores;
    }

    public void setDesenvolvedores(ArrayList<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public ArrayList<Grupo> getGrupos() {
        return this.grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Jogo> getJogos() {
        return this.jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUser(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void addGrupo(Grupo grupo) {
        this.grupos.add(grupo);
    }

    public void addJogo(Jogo jogo) {
        this.jogos.add(jogo);
    }

    public void addDev(Desenvolvedor desenvolvedor) {
        this.desenvolvedores.add(desenvolvedor);
    }
}
