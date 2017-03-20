package fiab.mob.com.appfinalbrunomartini;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doido on 20/03/2017.
 */

public class ProductDAO {

    private SQLiteDatabase db;

    public ProductDAO(){

        db = DatabaseManager.getInstance().openDatabase(true);
    }



    public static String createTable(){

        return "CREATE TABLE " + User.NOME_TABELA + " ( " + Product.ID + " integer primary key autoincrement, " +
                Product.PRODUTO + " text, " + Product.DESCRICAO + " text" + Product.PRECO +" text);";
    }



    public void insert(Product product){

        db = DatabaseManager.getInstance().openDatabase(true);
        ContentValues values = new ContentValues();

        values.put("produto", product.getProduct());
        values.put("descricao", product.getDescription());
        values.put("preco", product.getPrice());

        db.insert(product.NOME_TABELA, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<Product> searchProducts(){

        List<Product> products = new ArrayList<>();

        Cursor cursor;

        cursor = db.query(Product.NOME_TABELA, null, null, null, null, null, null, null);

        if (cursor != null) {
            if(cursor.moveToFirst()){
                do {
                    Product product = new Product();
                    product.setProduct(cursor.getString(cursor.getColumnIndex(Product.PRODUTO)));
                    product.setDescription(cursor.getString(cursor.getColumnIndex(Product.DESCRICAO)));
                    product.setPrice(cursor.getString(cursor.getColumnIndex(Product.PRECO)));
                    products.add(product);
                } while(cursor.moveToNext());
            }
        }

        return products;
    }
}
