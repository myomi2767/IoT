package multi.android.material_design_pro2.recycler;

public class CircleItem {
    int data;

    public CircleItem(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CircleItem{" +
                "data=" + data +
                '}';
    }
}
