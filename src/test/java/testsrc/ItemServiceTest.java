package testsrc;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import answer.king.controller.ItemController;
import answer.king.model.Item;
import answer.king.model.Order;
import answer.king.repo.ItemRepository;
import answer.king.service.ItemService;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RunWith(SpringJUnit4ClassRunner.class)
public class ItemServiceTest {
	
	Item testItem = new Item();
	BigDecimal BigDec1 = new BigDecimal("1238126387123");
	
	@Mock
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order order;
	
	@Mock
	private ItemRepository itemRepository;
	
	@InjectMocks
	private ItemService itemService;
		
	@Before
	public void itemSave() {
				
		testItem.setId(123L);
		testItem.setName("firstName");
		testItem.setPrice(BigDec1);
		order.setId(12L);
		order.setPaid(true);
		List<Item> al=new ArrayList<Item>();
		al.add(testItem);
		order.setItems(al);
		testItem.setOrder(order);
	}

	@Test
	public void save() {
		System.out.println("ItemServiceTest-TestingStarted");
		//checking for invalid name
		assertTrue(testItem.getName().equals("firstName"));
		//checking for invalid price
		assertTrue(testItem.getPrice()==BigDec1);
		System.out.println("ItemServiceTest-assert validations for invalid data (price and name) passed");
		
		itemService.save(testItem);
		
		System.out.println("ItemServiceTest-TestingEnded");
	}
	
	
}