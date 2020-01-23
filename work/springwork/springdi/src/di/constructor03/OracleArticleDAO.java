package di.constructor03;

public class OracleArticleDAO implements IArticleDAO{

	@Override
	public void insert(ArticleDTO article) {
		System.out.println("Oracle");
	}
	
}
