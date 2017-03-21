package fiab.mob.com.appfinalbrunomartini;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

        return "CREATE TABLE " + Product.NOME_TABELA + " ( " + Product.ID + " integer primary key autoincrement, " +
                Product.PRODUTO + " text, " + Product.DESCRICAO + " text);";
    }



    public void insert(Product product){


        ContentValues values = new ContentValues();

        values.put("produto", product.getProduct());
        values.put("descricao", product.getDescription());


        db.insert(Product.NOME_TABELA, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }

    public void UpdateProducts(Product product){
        ContentValues cv = new ContentValues();
        cv.put(product.PRODUTO, product.getProduct());
        db.update(product.NOME_TABELA,cv , product.ID + " = " + product.getId() ,null );
    }

    public void DeleteProducts(Product product){

        db.delete(product.NOME_TABELA, product.PRODUTO + " = '" + product.getProduct() + "'",null);
        DatabaseManager.getInstance().closeDatabase();
    }

    public List<Product> searchProducts(){

        List<Product> productsList = new ArrayList<>();

        Cursor cursor;
        db = DatabaseManager.getInstance().openDatabase(true);
        cursor = db.query(Product.NOME_TABELA, null, null, null, null, null, null, null);
        Log.i("CURSOR",Integer.toString(cursor.getCount()));
        if (cursor != null) {
            if(cursor.moveToFirst()){
                do {
                    Product product = new Product();
                    product.setId(cursor.getInt(cursor.getColumnIndex(Product.ID)));
                    product.setProduct(cursor.getString(cursor.getColumnIndex(Product.PRODUTO)));
                    //Log.i("PRODUTO",String.format("%s", product.getProduct()));
                    product.setDescription(cursor.getString(cursor.getColumnIndex(Product.DESCRICAO)));
                    //Log.i("PRODUTO",String.format("%s", product.getDescription()));
                    productsList.add(product);
                } while(cursor.moveToNext());
            }
        }
        DatabaseManager.getInstance().closeDatabase();
        return productsList;
    }


}
