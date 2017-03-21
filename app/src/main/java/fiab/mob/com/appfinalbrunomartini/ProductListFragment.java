package fiab.mob.com.appfinalbrunomartini;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 *
 * create an instance of this fragment.
 */
public class ProductListFragment extends Fragment {
    private List<Product> products= new ArrayList<>();

    private RecyclerView rv;

    private ProductsAdapter productsAdapter;

    public ProductListFragment() {

    }





    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        Button btnDelete;

        View view =inflater.inflate(R.layout.fragment_product_list, container, false);



        rv=(RecyclerView)view.findViewById(R.id.rvProducts);

        rv.addItemDecoration(new Divider(ApplicationContext.getContext(), LinearLayoutManager.VERTICAL));
        LoadProducts();

        productsAdapter= new ProductsAdapter(products,this.getContext());





        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT));



        RecyclerView.LayoutManager manager= new LinearLayoutManager(ApplicationContext.getContext());



        rv.setLayoutManager(manager);

        rv.setItemAnimator(new DefaultItemAnimator());

        rv.setAdapter(productsAdapter);

        rv.addOnItemTouchListener(new RecyclerTouchListener(getContext(), rv, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Product product = products.get(position);
                Toast.makeText(getContext(), product.getProduct(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        return view;



    }

    public void DeleteProduct(View v){

        Toast.makeText(getContext(),"DELETOU", Toast.LENGTH_LONG).show();

    }



    /*private void LoadProducts() {


        Product product;
        product = new Product("Escova","Escova de Cabelo");
        products.add(product);
        productsAdapter.notifyDataSetChanged();



    }*/

    private void LoadProducts(){

        ProductDAO productDAO =new ProductDAO();
        products = productDAO.searchProducts();
        //productsAdapter.notifyDataSetChanged();
    }

}
