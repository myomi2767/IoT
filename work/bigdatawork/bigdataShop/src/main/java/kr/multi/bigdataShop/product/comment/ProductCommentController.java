package kr.multi.bigdataShop.product.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductCommentController {
	@Autowired
	ProductCommentService service;
	
	@RequestMapping(value="/comment/write.do", method = RequestMethod.POST)
	public String commentinsert(ProductCommentDTO pdcm) {
		System.out.println(pdcm);
		service.commentinsert(pdcm);
		return "redirect:/product/read.do?prd_no="+pdcm.getPrd_no();
	}
	
	@RequestMapping("/comment/result.do")
	public ModelAndView commentresult() {
		ModelAndView mav = new ModelAndView();
		List<ProductCommentResultDTO> commentlist = service.commentresult();
		mav.addObject("commentlist", commentlist);
		mav.setViewName("comment/result");
		return mav;
	}
}
