package fiab.mob.com.appfinalbrunomartini;

/**
 * Created by doido on 20/03/2017.
 */

public class Product {


    public final static String NOME_TABELA = "produtos";
    public final static String ID = "_id";
    public final static String PRODUTO = "produto";
    public final static String DESCRICAO = "descricao";
    public final static String PRECO = "preco";


    private String product;
    private String description;
    private String price;

    public Product(String product, String description, String price) {
        this.product = product;
        this.description = description;
        this.price = price;
    }

    public Product(){


    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }
}
