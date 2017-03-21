package fiab.mob.com.appfinalbrunomartini;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by doido on 20/03/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static String NOME_BANCO = "appfinal.db";
    public static int VERSAO_BANCO = 2;
    public DBHelper(){

        super(ApplicationContext.getContext(), NOME_BANCO, null,VERSAO_BANCO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ProductDAO.createTable());
        db.execSQL(UserDAO.createTable());


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+User.NOME_TABELA +";");
        onCreate(db);

    }


}
