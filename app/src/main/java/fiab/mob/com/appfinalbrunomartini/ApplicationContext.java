package fiab.mob.com.appfinalbrunomartini;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

/**
 * Created by doido on 20/03/2017.
 */

public class ApplicationContext extends Application {

    private static ApplicationContext instance;



    @Override

    public void onCreate() {

        super.onCreate();

        Stetho.initializeWithDefaults(this);

        DatabaseManager.initializeInstance(new DBHelper());

    }



    public  static Context getContext(){

        return  instance;

    }



    public  ApplicationContext(){

        instance = this;

    }
}
