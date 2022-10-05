package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccsess.HibernateProductDao;
import oopWithNLayeredApp.dataAccsess.ProductDao;
import oopWithNLayeredApp.entities.Product;

public class ProductManager {
	
	private ProductDao productDao;
	//private List<Logger> loggers;
	private Logger[] loggers;
	
	public ProductManager(ProductDao productDao,Logger[] loggers) {
		this.productDao=productDao;
		this.loggers=loggers;
	}
	
	public ProductManager(HibernateProductDao hibernateProductDao, java.util.logging.Logger[] loggers2) {
		// TODO Auto-generated constructor stub
	}

	public void add(Product product) throws Exception {
		
		if(product.getUnitPrice()<10) {
			throw new Exception("Ürün fiyatý 10 dan küçük olamaz");
			
		}
		
		
		this.productDao.add(product);
		
		for(Logger logger:this.loggers) {
			logger.log(product.getName());
		}
		
	}
}