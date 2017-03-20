package fiab.mob.com.appfinalbrunomartini;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by doido on 20/03/2017.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    //Lista de filmes que serão mostrados na lista
    private List<Product> products;

    public ProductsAdapter(List<Product> products) {
        this.products = products;
    }

    //O design pattern chamado ViewHolder que irá segurar as informações da view.
    //Aqui fazemos o bind dos atributos com os campos do nosso layout que representara
    //as linhas
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProd, tvDesc, tvPrice;

        public ProductViewHolder(View view) {
            super(view);
            tvProd = (TextView) view.findViewById(R.id.tvProd);
            tvDesc = (TextView) view.findViewById(R.id.tvDesc);
            tvPrice = (TextView) view.findViewById(R.id.tvPrice);
        }
    }

    // Aqui criamos o nosso ViewHolder, observe que nesse método
    // informamos qual o layout que devera ser utilizado
    // Ou seja podemos trabalhar com layouts diferentes de acordo
    // com uma determinada condição por exemplo
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_item, parent, false);

        return new ProductViewHolder(itemView);
    }

    //Adicionamos os valores dos objetos na view
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.tvProd.setText(product.getProduct());
        holder.tvDesc.setText(product.getDescription());
        holder.tvPrice.setText(product.getPrice());

    }

    //Total de itens na nossa lista
    @Override
    public int getItemCount() {
        return products.size();
    }
}
