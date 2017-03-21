package fiab.mob.com.appfinalbrunomartini;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.facebook.stetho.Stetho;

/**
 * Created by doido on 20/03/2017.
 */

public class UserDAO {

    private SQLiteDatabase db;

    public UserDAO(){

        db = DatabaseManager.getInstance().openDatabase(true);
    }

    public static String createTable(){

        return "CREATE TABLE " + User.NOME_TABELA + " ( " + User.ID + " integer primary key autoincrement, " +
                User.USUARIO + " text, " + User.SENHA + " text);";
    }



    public void insert(User user){

        db = DatabaseManager.getInstance().openDatabase(true);
        ContentValues values = new ContentValues();

        values.put("usuario", user.getUsuario());
        values.put("senha", user.getSenha());

        db.insert(user.NOME_TABELA, null, values);
        DatabaseManager.getInstance().closeDatabase();
    }

    public int searchUser(User user){

        int i = 0;
        //Log.i("USER",user.getUsuario() + user.getSenha());

        Cursor c = db.query(User.NOME_TABELA, new String[]{user.USUARIO,user.SENHA}, user.USUARIO + "= ? AND " + user.SENHA + "= ?" ,
                new String[]{user.getUsuario(),user.getSenha()},null, null,null,null);

        c.moveToFirst();
        i = c.getCount();

        return i;
    }


}
