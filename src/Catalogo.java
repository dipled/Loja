


import java.util.ArrayList;
import java.util.List;

public class Catalogo 
{
    private List<Jogo> jogos = new ArrayList<>();

    public List<Jogo> getJogos() {
        return this.jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }    

    public Jogo selecionaJogo(String titulo)
    {
        Jogo jogo = new Jogo();
        jogo = jogo.getJogo(titulo);
        if(jogo == null)
        {
            System.out.println("Jogo nao cadastrado");
            return null;
        }
        else if(jogos.contains(jogo))
        {
            return jogo;
        }
        else
        {
            System.out.println("Jogo nao esta no catalogo");
            return null;
        }
    }
}
