
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoggerService[] loggers= {new DatabaseLogger(),new FileLogger()};
		ProductManager productManager = new ProductManager(loggers);
		
		Product product=new Product(1,"Hamburger",30);
		productManager.save(product);

	}

}
