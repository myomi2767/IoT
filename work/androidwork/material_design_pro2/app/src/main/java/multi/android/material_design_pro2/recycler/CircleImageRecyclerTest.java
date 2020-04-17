package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView list;
    int[] data = {R.drawable.lee, R.drawable.gong, R.drawable.jung, R.drawable.jang, R.drawable.so};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        list = findViewById(R.id.circleList);

        List<CircleItem> recycle_datalist = new ArrayList<CircleItem>();
        for(int i=0;i<data.length;i++){
            CircleItem item = new CircleItem(data[i]);
            recycle_datalist.add(item);
        }
        RecyclerCircleAdapter adapter = new RecyclerCircleAdapter(this,
                R.layout.circle_item,recycle_datalist);

        /*LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);*/

        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);
        list.setHasFixedSize(true);

        list.setLayoutManager(manager);
        list.setAdapter(adapter);


    }
}
