package multi.android.material_design_pro2.recycler;

public class CardViewItem {
    int data;
    String content;

    public CardViewItem(int data, String content) {
        this.data = data;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "CardViewItem{" +
                "content='" + content + '\'' +
                ", data=" + data +
                '}';
    }
}
