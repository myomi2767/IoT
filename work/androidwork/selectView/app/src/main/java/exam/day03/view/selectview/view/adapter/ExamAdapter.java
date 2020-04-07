package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamAdapter extends ArrayAdapter<ActorItem> {
    private Context context;
    private int resId;
    private ArrayList<ActorItem> actorlist;
    HashMap<Integer, Boolean> saveData = new HashMap<Integer, Boolean>();

    public ExamAdapter(Context context, int resId, ArrayList<ActorItem> actorlist) {
        super(context, resId, actorlist);
        this.context = context;
        this.resId = resId;
        this.actorlist = actorlist;
    }

    @Override
    public int getCount() {
        return actorlist.size();
    }

    @Override
    public ActorItem getItem(int position) {
        return actorlist.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        ActorItem actor = actorlist.get(position);
        if(actor!=null){
            ImageView imageView = holder.examImg;
            TextView nameView = holder.nameView;
            TextView dateView = holder.dateView;
            TextView contentView = holder.contentView;
            final CheckBox chkView = holder.chkView;

            imageView.setImageResource(actor.examImg);
            nameView.setText(actor.examName);
            dateView.setText(actor.examDate);
            contentView.setText(actor.examContent);
            Boolean chk = saveData.get(position);

            if(chk==null){
                chkView.setChecked(false);
            }else{
                chkView.setChecked(chk);
            }

            /*chkView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(buttonView.isChecked()){
                        Boolean chk2 = isChecked;
                        saveData.put(position,chk2);
                    }
                }
            });*/

            chkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveData.put(position,chkView.isChecked());
                }
            });
        }

        return convertView;
    }
}
