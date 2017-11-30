package web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopdomain.ShopItems;
import shopdomain.ShoppingCart;

public class ShoppingServlet extends HttpServlet{

	
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		
		//获取值
		String commodity = request.getParameter("commodity");
		String quantity = request.getParameter("quantity");
		String id = request.getParameter("id");
		String cmd = request.getParameter("cmd");
		
		if("delete".equals(cmd)){
			
			System.out.println("============");
			
			this.deleteCommodity(request,Integer.valueOf(id));
			
			request.getRequestDispatcher("/showCart.jsp").forward(request, response);
			
			return;
		}
		
	
		BigDecimal price = null;
		Integer commodityId = null;
		
		if(commodity != null && !commodity.equals("")){
			
			if("iphone6".equals(commodity)){

				
				price = new BigDecimal("6000");
				
				commodityId = 1;
				
			}else if("iphone5".equals(commodity)){
				
				
				price = new BigDecimal("4000");
				
				commodityId = 2;
				
			}else if("iWatch".equals(commodity)){
				
				price = new BigDecimal("6000");
				
				commodityId = 3;
				
			}
			
		}
		
		ShopItems item = new ShopItems();
		item.setName(commodity);
		item.setQuantity(Integer.valueOf(quantity));
		item.setPrice(price);
		item.setId(Integer.valueOf(commodityId));
		
		//为避免每次请求都创建一个购物车,所以把购物车添加到Session中
		ShoppingCart receiveCart = (ShoppingCart)request.getSession().getAttribute("CART_IN_SESSION");
		
		if(receiveCart == null){
			
			//创建购物车对象
			receiveCart =  new ShoppingCart();
			
			//把购物车添加到Session中
			request.getSession().setAttribute("CART_IN_SESSION",receiveCart);
		}
		
		//给购物车添加商品
		receiveCart.addCommodity(item);
		
		
		request.getRequestDispatcher("/shoppingCart.jsp").forward(request,response);;
	}

	private void deleteCommodity(HttpServletRequest request,Integer id) {
		
		
		ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("CART_IN_SESSION");
		
	
		cart.deleteCommodity(id);
		
		
	}
	
	
}
