package multi.android.material_design_pro2.recycler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CardViewRecyclerTest extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_recycler_test);
        list = findViewById(R.id.cardList);
        CardViewItem[] data = new CardViewItem[5];
        data[0] = new CardViewItem(R.drawable.lee, "이민호의 신의");
        data[1] = new CardViewItem(R.drawable.gong, "공유의 도깨비");
        data[2] = new CardViewItem(R.drawable.jung, "정우성의 비트");
        data[3] = new CardViewItem(R.drawable.jang, "검색어를 입력하세요");
        data[4] = new CardViewItem(R.drawable.so, "미안하다 사랑하다");

        List<CardViewItem> recycle_datalist = new ArrayList<CardViewItem>();
        for(int i=0;i<data.length;i++){
            recycle_datalist.add(data[i]);
        }
        CardViewRecyclerAdapter adapter = new CardViewRecyclerAdapter(this,
                R.layout.card_item,recycle_datalist);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        /*GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);
        list.setHasFixedSize(true);*/

        list.setLayoutManager(manager);
        list.setAdapter(adapter);


    }
}
