package fiab.mob.com.appfinalbrunomartini;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by doido on 20/03/2017.
 */

public interface UsersAPI {

    public static final String USERS_URL = "http://www.mocky.io/v2/58b9b1740f0000b614f09d2f/";

    @GET("usuario")
    Call<User> getUser();


}
