package com.muhib.springdata.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.muhib.springdata.product.entites.Product;
import com.muhib.springdata.product.repository.ProductPageRepository;
import com.muhib.springdata.product.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

	@Autowired
	ProductRepository repo;
	
	@Autowired
	EntityManager entityManager;

	@Autowired
	ProductPageRepository pageRepo;

	// Create/Insert Operation
	@Test
	public void testCreateRow() {

		Product product = new Product();
		product.setId(1);
		product.setName("nokia");
		product.setDesc("cool");
		product.setPrice(10000d);

		repo.save(product);
	}

	// Read Operation
	@Test
	public void testReadRow() {

		Optional<Product> pro = repo.findById(1);
		if (pro.isPresent()) {
			Product product = pro.get();
			assertNotNull(pro);
			System.out.println(pro);
			assertEquals("nokia", product.getName());
		}
	}

	// Update Operation
	@Test
	public void testUpdateRow() {

		Optional<Product> pro = repo.findById(1);

		Product product = pro.get();
		product.setName("Samsung");
		repo.save(product);
		System.out.println(product);

		assertEquals("Samsung", product.getName());
	}

	// Delete Operation
	@Test
	public void testDeleteRow() {

		repo.deleteById(1);
	}

	// Exists Method
	@Test
	public void testCheckDeleteRow() {

		if (repo.existsById(1)) {
			System.out.println("inside If");
			repo.deleteById(1);
		}
	}

	// Count
	@Test
	public void testCheckRecords() {
		long count = repo.count();
		System.out.println("Total records -->" + count);
	}

	// Finder Method
	@Test
	public void testFindProductByName() {

		List<Product> repo2 = repo.findByName("samsung");

		repo2.forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getDesc());
			System.out.println(p.getPrice());

		});

	}

	// Finder Method
	@Test
	public void testFindAllProduct() {
		List<Product> repo2 = (List<Product>) repo.findAll();
		repo2.forEach(p -> {
			System.out.println(p.getName());
		});

	}

	// Finder Method MultipleField
	@Test
	public void tesFindProductUsingMultipleField() {

		List<Product> repo2 = repo.findByNameAndId("samsung", 2);

		repo2.forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getDesc());
			System.out.println(p.getPrice());

		});

	}

	// Finder Method Greater Than
	@Test
	public void testFindProductGreaterThan() {

		List<Product> repo2 = repo.findByPriceGreaterThan(2000.00d);

		repo2.forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getDesc());
			System.out.println(p.getPrice());

		});
	}

	// Finder Method Contains
	@Test
	public void testFindProductContains() {

		List<Product> repo2 = repo.findByDescContains("phone");

		repo2.forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getDesc());
			System.out.println(p.getPrice());

		});
	}

	// Finder Method keyword Between
	@Test
	public void testFindProductBetweenRange() {

		List<Product> repo2 = repo.findByPriceBetween(3000d, 30000d);

		repo2.forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getDesc());
			System.out.println(p.getPrice());

		});
	}

	// Finder Method keyword Like
	@Test
	public void testFindProductLike() {

		List<Product> repo2 = repo.findByNameLike("%re%");

		repo2.forEach(p -> {
			System.out.println(p.getName());

		});
	}

	// Finder Method keyword In
	@Test
	public void testFindProductIn() {

		List<Product> repo2 = repo.findByIdIn(Arrays.asList(1, 2, 3, 4, 5, 6));
		System.out.println(repo2);
		repo2.forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getId());

		});
	}

	// Paging
	@Test
	public void testFindAllPaging() {

		Pageable pageable = new PageRequest(2, 2);

		Page<Product> repo2 = pageRepo.findAll(pageable);
		System.out.println(repo2);
		repo2.forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getId());
		});
	}

	// Sorting by single property ascending
	@Test
	public void testFindAllSoring() {

		pageRepo.findAll(new Sort("price")).forEach(p -> System.out.println(p));

	}

	// Sorting by single property descending
	@Test
	public void testFindAllSorting2() {
		pageRepo.findAll(new Sort(Direction.DESC, "price")).forEach(p -> System.out.println(p));
	}

	// Sorting by multiple property
	@Test
	public void testFindAllSorting3() {
		pageRepo.findAll(new Sort("name", "price")).forEach(p -> System.out.println(p));
	}

	// Sorting by multiple property with direction
	@Test
	public void testFindAllSorting4() {
		pageRepo.findAll(new Sort(Direction.DESC, "name", "price")).forEach(p -> System.out.println(p));
	}

	// Sorting by multiple property with each direction
	@Test
	public void testFindAllSorting5() {
		Iterable<Product> findAll = pageRepo.findAll(new Sort(new Sort.Order(Direction.DESC,"name"),new Sort.Order("price")));
		
		findAll.forEach(p->{
			System.out.println(p);
		});
		
	}
	
	// Paging and sorting
		@Test
		public void testFindAllPagingAndSorting() {

			Pageable pageable = new PageRequest(0, 2,Direction.DESC,"price");

			Page<Product> repo2 = pageRepo.findAll(pageable);
			System.out.println(repo2);
			repo2.forEach(p -> {
				System.out.println(p.getName());
				System.out.println(p.getPrice());
			});
		}
		
		// Paging and sorting for custom finder method
		@Test
		public void testFindAllPagingAndSortingForCustom() {

			Pageable pageable = new PageRequest(0, 2,Direction.DESC,"price");

		 List<Product> repo2 = pageRepo.findByIdIn(Arrays.asList(0,1,2,3,4,5,8), pageable);
		 
			repo2.iterator().forEachRemaining(p -> {
				System.out.println(p.getName());
				System.out.println(p.getPrice());
			});
		}
	
	
		// L1 cache Operation
		@Test
		@Transactional
		public void testFirstLvlCache() {
			
			/*multiple select if evicted from l1 cache*/
			Session session = entityManager.unwrap(Session.class);
			
			Product pro = repo.findById(2).get(); //hit query to db and store object in cache L1 (In absence of L2C)
			
			repo.findById(2); //first search cache for requested object if present loads from cache (In absence of L2C)
			//System.out.println(pro);
			session.evict(pro);// evict object from cache
			repo.findById(2);// hit query to db and fetch and store in cache L1 (In absence of L2C)
			repo.findById(2);// first search cache for requested object if present loads from cache (In absence of L2C)
			
		}
		
		// L2 cache Operation present through out application 
				@Test
				@Transactional
				public void testSecondLvlCache() {

					Session session = entityManager.unwrap(Session.class);
					
		/* one select per db */
					Product pro = repo.findById(2).get(); //hit query to db and store object in cache L2 cache
					
					repo.findById(2); //first search cache for requested object if present loads from L2 cache
					//System.out.println(pro);
					session.evict(pro);// evict object from L1 cache (loads from L2C and put in L1C and evicts that Object)
					repo.findById(2);//  retrieve from L2 Cache
					repo.findById(2);// retrieve from L2 Cache
					
				}
	

}
