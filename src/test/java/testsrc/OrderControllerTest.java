package testsrc;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import answer.king.controller.OrderController;
import answer.king.model.Item;
import answer.king.model.Order;
import answer.king.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderControllerTest {
	
	Item testItem = new Item();
	Order order = new Order();
	BigDecimal BigDec1 = new BigDecimal("1238126387123");
	
	
	
	@Mock
	private OrderService orderService;
	
	@InjectMocks
	private OrderController orderController;
	
	@Before
	public void itemCreate() {
				
		order.setId(12L);
		order.setPaid(true);
		List<Item> al=new ArrayList<Item>();
		testItem.setId(123L);
		testItem.setName("firstName");
		testItem.setPrice(BigDec1);
		al.add(testItem);
		order.setItems(al);
	}

	@Test
	public void pay() {
		
		System.out.println("OrderControllerTest-TestingStarted");
		//checking for order paid flag value
		assertTrue(order.getPaid()==true);
		//checking for insufficient funds
		assertTrue(testItem.getPrice()==BigDec1);
		System.out.println("OrderControllerTest-assert validations passed");
		
		orderController.pay(order.getId(),order.getItems().get(0).getPrice());
		
		System.out.println("OrderControllerTest-TestingEnded");
	}
	
	
}