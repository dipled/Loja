


import java.util.ArrayList;
import java.util.List;

public class Carrinho 
{
    private List<Jogo> jogos = new ArrayList<>();
    private float valorTotal;

    
    public Carrinho()
    {
        this.valorTotal = 0;
    }

    public void adicionaJogo(Jogo j)
    {
        this.jogos.add(j);
        this.valorTotal += j.getPreco();
    }
    
    public List<Jogo> getJogos() {
        return this.jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public float getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void limparCarrinho()
    {
        this.valorTotal = 0;
        this.jogos = new ArrayList<>();
    }

        
}
