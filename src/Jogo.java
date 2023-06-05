import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jogo {
    private int id;
    private int desenvolvedor;
    private String titulo;
    private String descricao;
    private float preco;
    private int ano;

    public Jogo(int id, int desenvolvedor, String titulo, String descricao, float preco, 
            int ano) {
        this.id = id;
        this.desenvolvedor = desenvolvedor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
    
        this.ano = ano;
    }

    public Jogo(int desenvolvedor, String titulo, String descricao, float preco, int ano) {
        this.desenvolvedor = desenvolvedor;
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

    public int getDesenvolvedor() {
        return this.desenvolvedor;
    }

    public void setDesenvolvedor(int desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }


    public boolean contemTermo(String titulo) {
        if (this.titulo.contains(titulo)) {
            return true;
        } else {
            return false;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", desenvolvedor='" + getDesenvolvedor() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", preco='" + getPreco() + "'" +
            ", ano='" + getAno() + "'" +
            "}";
    }

}
