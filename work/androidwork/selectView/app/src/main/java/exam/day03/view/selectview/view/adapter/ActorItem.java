package exam.day03.view.selectview.view.adapter;

public class ActorItem {
    int examImg;
    String examName;
    String examDate;
    String examContent;

    public ActorItem(int examImg, String examName, String examDate, String examContent) {
        this.examImg = examImg;
        this.examName = examName;
        this.examDate = examDate;
        this.examContent = examContent;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "examImg=" + examImg +
                ", examName='" + examName + '\'' +
                ", examDate='" + examDate + '\'' +
                ", examContent='" + examContent + '\'' +
                '}';
    }
}
