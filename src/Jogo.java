import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jogo
{
    private int id;
    private int desenvolvedor;
    private String titulo;
    private String descricao;
    private float preco;
    private float desconto;
    private float nota;
    private int ano;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Jogo(int id, int desenvolvedor, String titulo, String descricao, float preco, float desconto,float nota, int ano) 
    {    
        this.id = id;
        this.desenvolvedor = desenvolvedor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.desconto = desconto;
        this.nota = nota;
        this.ano = ano;
    }
    
        public Jogo(int desenvolvedor, String titulo, String descricao, float preco, float desconto,float nota, int ano) {
            this.desenvolvedor = desenvolvedor;
            this.titulo = titulo;
            this.descricao = descricao;
            this.preco = preco;
            this.desconto = desconto;
            this.nota = nota;
            this.ano = ano;
        }
    public Jogo()
    {

    }
    
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void adicionaAvaliacao(Avaliacao a)
    {
        this.avaliacoes.add(a);
        this.calculaNota();
    

    }
    public void calculaNota()
    {
        float nota = 0;
        int numAv = avaliacoes.size();
        for(int i = 0; i < numAv; i += 1)
        {
            nota += avaliacoes.get(i).getNota();
        }
        this.setNota(nota/numAv);
    }
    public List<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int dia, int mes, int ano) {
        this.ano = ano;
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

    public float getPreco() {
        return this.preco - (this.preco * this.desconto/100);
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getDesenvolvedor() {
        return this.desenvolvedor;
    }

    public void setDesenvolvedor(int desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public float getNota() {
        return this.nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getDesconto() {
        return this.desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public Jogo getJogo(String titulo)
    {
        if(this.titulo == titulo)
        {
            Jogo nJogo = new Jogo();
            nJogo.titulo = this.titulo;
            nJogo.descricao = this.descricao;
            nJogo.preco = this.preco;
            nJogo.desenvolvedor = this.desenvolvedor;
            nJogo.desconto = this.desconto;
            nJogo.nota = this.nota;
            return nJogo;
        }
        else
        {
            return null;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Jogo other = (Jogo) obj;
        return Objects.equals(this.titulo, other.titulo);
    }
    }

