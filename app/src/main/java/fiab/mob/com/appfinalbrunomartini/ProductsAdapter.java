package fiab.mob.com.appfinalbrunomartini;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by doido on 20/03/2017.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    Context adapterContext;



    private List<Product> products;

    public ProductsAdapter(List<Product> products, Context productListFragment) {
        this.products = products;
        this.adapterContext = productListFragment;
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProd, tvDesc, tvPrice;
        public Button btnDelete;
        public Context context;

        public ProductViewHolder(View view) {
            super(view);
            tvProd = (TextView) view.findViewById(R.id.tvProd);
            tvDesc = (TextView) view.findViewById(R.id.tvDesc);
            tvPrice = (TextView) view.findViewById(R.id.tvPrice);
            btnDelete = (Button) view.findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    ProductDAO productDAO = new ProductDAO();
                    Product product = new Product();
                    product.setProduct(tvProd.getText().toString());
                    productDAO.DeleteProducts(product);
                    ProductListFragment productListFragmentFragment = new ProductListFragment();

                    FragmentManager manager = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
                    manager
                            .beginTransaction()
                            .replace(R.id.content_main,productListFragmentFragment, productListFragmentFragment.getTag())
                            .commit();
                }
            });


        }
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_item, parent, false);

        return new ProductViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Product product = products.get(position);
        holder.tvProd.setText(product.getProduct());
        holder.tvDesc.setText(product.getDescription());
        holder.context = adapterContext;



    }


    @Override
    public int getItemCount() {
        return products.size();
    }
}
