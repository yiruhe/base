package shopdomain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;




@Getter
public class ShoppingCart {

	private List<ShopItems> commodity = new ArrayList<>();

	
	
	
	//增
	public void addCommodity(ShopItems commodity){
		
		
		for(ShopItems items:this.commodity){
			
			
			//判断购车是否该商品
			if(items.getName().equals(commodity.getName())){
				
				//让相同的商品数量相加
				items.setQuantity(items.getQuantity()+commodity.getQuantity());
		
				return;
			}
			
			
			
		}
		
		//否则就添加这个商品
		this.commodity.add(commodity);
		
	}
	
	//移除某个商品
	public void deleteCommodity(int id){
		
		Iterator<ShopItems> iterator = this.commodity.iterator();
		
		if(iterator.hasNext()){
			
			
			//比较对象id和指定的id是否相等
			if(iterator.next().getId().equals(id)){
				

				//相等就删除
				iterator.remove();
				
			}
			
		}
		
		
	}
	
	
	
	//计算商品总价
	public BigDecimal  getCountTotalPrice(){
		
		BigDecimal totalPrive = BigDecimal.ZERO;
		
		
		for(ShopItems item:this.commodity){
		
			//单个商品的总价格
			totalPrive = item.getPrice().multiply(new BigDecimal(item.getQuantity()));
			
			//添加到中的价格中
			totalPrive.add(totalPrive);
		}
		
		
		return totalPrive;
	} 
	
}
