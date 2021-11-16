package northwind;

import northwind.business.abstracts.CategoryService;
import northwind.business.abstracts.ProductService;
import northwind.business.concretes.CategoryManager;
import northwind.business.concretes.ProductManager;
import northwind.dataAccess.concretes.CategoryDao;
import northwind.dataAccess.concretes.ProductDao;
import northwind.entities.concretes.Category;
import northwind.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		ProductService productService=new ProductManager(new ProductDao());
		productService.add(new Product(1, 1, "Elma", 10));
		productService.add(new Product(8, 1, "a", 10));
		productService.add(new Product(9, 1, "b", 10));
		productService.add(new Product(10, 1, "c", 10));
		productService.add(new Product(11, 1, "d", 10));
		productService.add(new Product(12, 1, "e", 10));
		productService.add(new Product(13, 1, "f", 10));
		productService.add(new Product(2, 2, "Armut", 20));
		productService.add(new Product(3, 3, "Karpuz", 30));
		productService.add(new Product(4, 4, "Üzüm", 40));
		productService.add(new Product(5, 5, "İncir", 50));
		productService.add(new Product(7, 6, "Kavun", 60));
		productService.add(new Product(1, 1, "Elma", 10));
		productService.add(new Product(14,3,"test",5));
		productService.add(new Product(15,2,"test2",-2));
		
		for (Product product : productService.getAll()) {
			System.out.println(product.getProductName());
		}
		
		CategoryService categoryService= new CategoryManager(new CategoryDao());
		categoryService.add(new Category(1,"yiyecek"));
		categoryService .add(new Category(2,"içecek"));
		categoryService.add(new Category(3,"beyaz eşya"));
		categoryService.add(new Category(4,"elektronik"));
		categoryService.add(new Category(5,"mobilya"));
		categoryService.add(new Category(6,"spor"));
		
		for (Product category : productService.getAll()) {
			System.out.println(category.getCategoryId());
		}
		

	}

}

//Ioc container
