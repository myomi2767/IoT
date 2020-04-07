package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ViewHolder {
    ImageView examImg;
    TextView nameView;
    TextView dateView;
    TextView contentView;
    CheckBox chkView;

    //객체가 생성될 때 targetView(parentView)를 전달받는다
    public ViewHolder(View parentView) {
        this.examImg = parentView.findViewById(R.id.img_exam);
        this.nameView = parentView.findViewById(R.id.txtexam1);
        this.dateView = parentView.findViewById(R.id.txtexam2);
        this.contentView = parentView.findViewById(R.id.txtexam3);
        this.chkView = parentView.findViewById(R.id.chkexam);
    }
}
