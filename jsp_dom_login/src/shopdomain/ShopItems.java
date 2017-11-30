package shopdomain;

import java.math.BigDecimal;

import lombok.Data;


@Data
public class ShopItems{
	
	private Integer id;
	private String name;
	private BigDecimal price;
	private Integer quantity;
	
	
}