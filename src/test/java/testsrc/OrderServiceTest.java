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

import answer.king.model.Item;
import answer.king.model.Order;
import answer.king.repo.OrderRepository;
import answer.king.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {
	
	Item testItem = new Item();
	Order order = new Order();
	BigDecimal BigDec1 = new BigDecimal("1238126387123");
	
	
	@Mock
	private OrderRepository orderRepository;
	
	@InjectMocks
	private OrderService orderService;
		
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
	public void pay() {
		System.out.println("OrderServiceTest -TestingStarted");
		assertTrue(testItem.getName().equals("firstName"));
		assertTrue(testItem.getPrice()==BigDec1);
		System.out.println("OrderServiceTest -assert validations passed");
		orderService.pay(order.getId(),order.getItems().get(0).getPrice());
		System.out.println("OrderServiceTest -TestingEnded");
	}
	
	
}