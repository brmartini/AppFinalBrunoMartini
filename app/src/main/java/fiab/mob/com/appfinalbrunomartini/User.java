package fiab.mob.com.appfinalbrunomartini;

/**
 * Created by doido on 20/03/2017.
 */

public class User {

    public final static String NOME_TABELA = "usuarios";
    public final static String ID = "_id";
    public final static String USUARIO = "usuario";
    public final static String SENHA = "senha";


    private String usuario;
    private String senha;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(){

    }

    public User(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
