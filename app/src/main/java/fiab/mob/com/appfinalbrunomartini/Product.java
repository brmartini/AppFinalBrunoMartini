package fiab.mob.com.appfinalbrunomartini;

/**
 * Created by doido on 20/03/2017.
 */

public class Product {


    public final static String NOME_TABELA = "produtos";
    public final static String ID = "_id";
    public final static String PRODUTO = "produto";
    public final static String DESCRICAO = "descricao";


    private long id;
    private String product;
    private String description;

    public Product(long id, String product, String description) {
        this.id = id;
        this.product = product;
        this.description = description;
    }


    public Product(){


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }


    public String getProduct() {
        return product;
    }
}
