package multi.android.material_design_pro2.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import multi.android.material_design_pro2.R;

public class CardViewRecyclerAdapter extends RecyclerView.Adapter<CardViewRecyclerAdapter.ViewHolder> {
    Context context;
    int row_res_id;
    List<CardViewItem> data;

    public CardViewRecyclerAdapter(Context context, int row_res_id, List<CardViewItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("circle","onBindViewHolder:"+position);
        ImageView img = holder.img;
        TextView content = holder.txt;
        CardView card = holder.cardView;
        img.setImageResource(data.get(position).getData());
        content.setText(data.get(position).getContent());
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"데이터연결완료",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView img;
        TextView txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            txt = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
