
public class ProductManager implements ProductService {
	private LoggerService[] loggers;
	
	public ProductManager(LoggerService[] loggers) {
		this.loggers=loggers;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		System.out.println("product eklendi: " + product.getProductName());
		
		//bu metodu Utils nesnesine taşıyalım.
		/*for (LoggerService logger : loggers) {
			logger.log();
		}
		*/
		Utils.runLoggers(loggers);
		
		
	}
	

}
