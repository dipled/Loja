import java.util.ArrayList;

import java.util.Iterator;

public class Jogo {
    private int id;
    private String titulo;
    private String descricao;
    private float preco;
    private int ano;
    private String classificacaoEtaria;
    private String requisitosMinimos;
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

    public Jogo(int id, String titulo, String descricao, float preco, int ano, String classificacaoEtaria, String requisitosMinimos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.ano = ano;
        this.classificacaoEtaria = classificacaoEtaria;
        this.requisitosMinimos = requisitosMinimos;
    }

    public Jogo(String titulo, String descricao, float preco, int ano) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
    
        this.ano = ano;
    }

    public Jogo() {

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
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
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getClassificacaoEtaria() {
        return this.classificacaoEtaria;
    }

    public void setClassificacaoEtaria(String classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public String getRequisitosMinimos() {
        return this.requisitosMinimos;
    }

    public void setRequisitosMinimos(String requisitosMinimos) {
        this.requisitosMinimos = requisitosMinimos;
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }    

    public boolean contemTermo(String titulo) {
        if (this.titulo.contains(titulo)) {
            return true;
        } else {
            return false;
        }
    }

    public float calculaMediaAvaliacoes() {
        Iterator<Avaliacao> iterator = avaliacoes.iterator();
        float media = 0;

        while(iterator.hasNext()) {
            media += iterator.next().getNota();
        }
        
        return media/this.avaliacoes.size();
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
        return this.titulo.equals(other.getTitulo());
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", preco='" + getPreco() + "'" +
            ", ano='" + getAno() + "'" +
            "}";
    }

    public boolean fazerAvaliacao(Avaliacao avaliacao) {
         if (!this.avaliacoes.contains(avaliacao)) {
            this.avaliacoes.add(avaliacao);
            return true;
        }
        return false;
    }
}
