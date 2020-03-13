package kr.multi.bigdataShop.product.comment;

import java.util.List;

public interface ProductCommentDAO {
	int commentinsert(ProductCommentDTO pdcm);
	List<ProductCommentDTO> commentlist(String prd_no);
	List<ProductCommentResultDTO> commentresult();
}
