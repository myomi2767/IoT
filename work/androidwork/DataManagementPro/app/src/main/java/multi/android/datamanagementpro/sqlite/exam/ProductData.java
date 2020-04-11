package multi.android.datamanagementpro.sqlite.exam;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductData  implements Parcelable{
    String _id;
    String name;
    int price;

    protected ProductData(Parcel in) {
        _id = in.readString();
        name = in.readString();
        price = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(name);
        dest.writeInt(price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductData> CREATOR = new Creator<ProductData>() {
        @Override
        public ProductData createFromParcel(Parcel in) {
            return new ProductData(in);
        }

        @Override
        public ProductData[] newArray(int size) {
            return new ProductData[size];
        }
    };

    public ProductData(){

    }

    public ProductData(String _id, String name, int price) {
        this._id = _id;
        this.name = name;
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
