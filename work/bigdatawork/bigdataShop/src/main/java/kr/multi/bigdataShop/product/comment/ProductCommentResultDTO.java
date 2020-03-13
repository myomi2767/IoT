package kr.multi.bigdataShop.product.comment;

public class ProductCommentResultDTO {
	private String pro_comment;
	private int count;
	
	public ProductCommentResultDTO() {
		
	}

	public ProductCommentResultDTO(String pro_comment, int count) {
		super();
		this.pro_comment = pro_comment;
		this.count = count;
	}

	public String getPro_comment() {
		return pro_comment;
	}

	public void setPro_comment(String pro_comment) {
		this.pro_comment = pro_comment;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ProductCommentResultDTO [pro_comment=" + pro_comment + ", count=" + count + "]";
	}
	
}
