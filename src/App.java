import java.sql.*;
import java.text.*;
import java.util.*;
//
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ParseException, ClassNotFoundException {
        int mode = 0;
        System.out.println("Digite 1 para modo de adm ou 2 para modo de usuario");
        mode = Integer.parseInt(in.nextLine());
        if (mode == 1)
            adm();
        else
            usr();
    }

    public static void usr() throws SQLException, ParseException, ClassNotFoundException {
        Usuario u = new Usuario();
        Connection connection = new Connect().getConnection();
        int escolha = -1;
        JogoController jg = new JogoController();
        DesenvolvedorController dv = new DesenvolvedorController();
        UsuarioController us = new UsuarioController();
        while (true) {
            u = us.login(connection);
            if (u == null)
                {System.out.println("Erro ao fazer login");
                System.out.println();}
            else {
                while (true) {
                    System.out.println("Digite:\n0 para sair\t1 para listar os jogos do catalogo\n"
                            + "2 para listar os jogos de um desenvolvedor\t3 para comprar um jogo\n"
                            + "4 para mostrar sua biblioteca\t5 para escrever uma avaliacao\n"
                            + "6 para mostrar todas as avaliacoes e a nota media de um jogo\n"
                            +"7 para mostrar o jogo mais antigo\n");
                    escolha = Integer.parseInt(in.nextLine());
                    switch (escolha) {
                        case 0:
                            return;
                        case 1:
                            jg.listarJogos(connection);
                            System.out.println();
                            break;
                        case 2:
                            dv.listarItens(connection);
                            System.out.println();
                            jg.listarDosDesenvolvedores(connection);
                            System.out.println();
                            break;
                        case 3:
                            jg.listarJogos(connection);
                            System.out.println();
                            try {
                                us.comprar(connection, u.getId());
                            } catch (SQLException e) {
                                System.out.println("Erro ao comprar o jogo");
                                System.out.println();
                            }break;
                        case 4:
                            jg.listarDoUsuario(connection, u.getId());
                            System.out.println();
                            break;
                        case 5:
                            jg.listarDoUsuario(connection, u.getId());
                            System.out.println();
                            try{us.avaliar(connection, u.getId());}
                            catch(SQLException e)
                            {
                                System.out.println("Erro ao avaliar");
                                System.out.println();
                            }
                            break;
                        case 6:
                            jg.listarJogos(connection);
                            System.out.println();
                            us.mostrarAvaliacoes(connection);
                            System.out.println();
                            break;
                        case 7:
                            System.out.println();
                            us.maisAntigo(connection);
                            System.out.println();
                            break;
                        default:
                            System.out.println();
                            System.out.println("Opcao invalida");
                    }
                }
            }

        }

    }

    public static void adm() throws SQLException, ParseException, ClassNotFoundException {
        Connection connection = new Connect().getConnection();
        int escolha = -1;
        JogoController jg = new JogoController();
        DesenvolvedorController dv = new DesenvolvedorController();
        UsuarioController us = new UsuarioController();
        while (true) {
            System.out.println("Digite:\n0 para sair\t1 para cadastrar um desenvolvedor\n"
                    + "2 para cadastrar um jogo\t3 para cadastrar um Usuario\n"
                    + "4 para listar todos os desenvolvedores\t5 para listar todos os jogos\n"
                    + "6 para listar todos os usuarios");
            escolha = Integer.parseInt(in.nextLine());
            switch (escolha) {
                case 0:
                    return;
                case 1:
                    try {
                        dv.createDesenvolvedor(connection);
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar desenvolvedor");
                    }
                    break;
                case 2:
                    dv.listarItens(connection);
                    try {
                        jg.createjogo(connection);
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar jogo");
                    }
                    break;
                case 3:
                    try {
                        us.createUsuario(connection);
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar usuario");
                    }

                    break;
                case 4:
                    dv.listarItens(connection);
                    break;
                case 5:
                    jg.listarJogos(connection);
                    break;
                case 6:
                    us.listarItens(connection);
                    break;
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        }
    }
}
