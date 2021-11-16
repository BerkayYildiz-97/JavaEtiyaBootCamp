package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.ProductService;
import northwind.dataAccess.abstracts.ProductRepository;
import northwind.dataAccess.concretes.ProductDao;
import northwind.entities.concretes.Product;

public class ProductManager implements ProductService {
	private ProductRepository productRepository;

	public ProductManager(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAll() {

		return this.productRepository.getAll();
	}
	
	private boolean isExist(Product product) {
		for (Product p : productRepository.getAll()) {
			if (p.getProductName().equals(product.getProductName())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean categoryChecker(Product product) {
		int count=0;
		for (Product p : productRepository.getAll()) {
			if (p.getCategoryId()==product.getCategoryId()) {
				count++;
			}
		}
		if (count<5) {
			return false;
		}
		return true;
	}
	private boolean unitPriceChecker(Product product) {
		if (product.getUnitPrice()<0) {
			return true;
		}		
		return false;
	}
	private boolean categoryId3Checker(Product product) {
		if (product.getCategoryId()==3) {
			if (product.getUnitPrice()<10) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(Product product) {
		if (isExist(product)) {
			System.out.println("sistemde böyle bir ürün zaten mevcut");
			
		}
		else if (categoryChecker(product)) {
			System.out.println("5 den fazla ekleme yapılamaz");
		}
		else if (unitPriceChecker(product)) {
			System.out.println("ürün fiyatı eksi olamaz");
		}
		else if (categoryId3Checker(product)) {
			System.out.println("3 numaralı ürün fiyatı en az 10 olabilir");
		}
		else {
			this.productRepository.add(product);
		}
		
	}

}
