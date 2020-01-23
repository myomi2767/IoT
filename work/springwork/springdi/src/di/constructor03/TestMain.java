package di.constructor03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("config/bean.xml");
		IWriteArticleMgr mgr = factory.getBean("mgr",IWriteArticleMgr.class);
		mgr.write(new ArticleDTO());
	}

}
