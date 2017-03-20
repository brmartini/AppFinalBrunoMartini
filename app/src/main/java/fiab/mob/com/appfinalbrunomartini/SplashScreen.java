package fiab.mob.com.appfinalbrunomartini;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by doido on 19/03/2017.
 */

public class SplashScreen extends AppCompatActivity {

    private static final String TAG = "ERRO" ;
    private final int SPLASH_DISPLAY_LENGTH = 3500;


    Animation animacao;
    private ImageView ivImagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        Log.i("TESTE","COMECOU O APP");
        ivImagem = (ImageView) findViewById(R.id.ivImagem);
        // load the animation
        animacao =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.animacao);
        ivImagem.startAnimation(animacao);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UsersAPI.USERS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsersAPI service = retrofit.create(UsersAPI.class);
        Call<User> requestUser = service.getUser();

        requestUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(!response.isSuccessful()){

                    Log.i("TAG","Erro: "+response.code());
                }else{

                    User user = response.body();
                        Log.i("RETROFIT USUARIO",String.format("%s", user.getUsuario()));
                        Log.i("RETROFIT SENHA",String.format("%s", user.getSenha()));
                    salvarUsuario(user);



                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Log.e(TAG,"Erro" + t.getMessage());
            }
        });



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this,
                        LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    public void salvarUsuario(User user){

        UserDAO userDAO= new UserDAO();
        userDAO.insert(user);
    }


}
