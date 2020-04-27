package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commentdao")
public class ProductCommentDAOImpl implements ProductCommentDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public int commentinsert(ProductCommentDTO pdcm) {
		int result = sqlSession.insert("kr.multi.bigdataShop.product.comment.commentinsert", pdcm);
		return result;
	}

	@Override
	public List<ProductCommentDTO> commentlist(String prd_no) {
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.commentlist", prd_no);
	}

	@Override
	public List<ProductCommentResultDTO> commentresult() {
		return sqlSession.selectList("kr.multi.bigdataShop.product.comment.commentresult");
	}

}
