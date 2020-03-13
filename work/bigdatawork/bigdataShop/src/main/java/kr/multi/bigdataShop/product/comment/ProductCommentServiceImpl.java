package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentServiceImpl implements ProductCommentService{
	@Autowired
	@Qualifier("commentdao")
	ProductCommentDAO dao;
	
	@Override
	public int commentinsert(ProductCommentDTO pdcm) {
		return dao.commentinsert(pdcm);
	}

	@Override
	public List<ProductCommentDTO> commentlist(String prd_no) {
		return dao.commentlist(prd_no);
	}

	@Override
	public List<ProductCommentResultDTO> commentresult() {
		return dao.commentresult();
	}

}
