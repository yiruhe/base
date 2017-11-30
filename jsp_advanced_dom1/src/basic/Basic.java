package basic;

public class Basic{
	
	//netstat -ano | findstr "80"
	
	//使用 WHERE 1=1后,就不能使用索引了,mysql5.7后  会自动取消第一个为true的条件
	
	
	//分页:
	//假分页/逻辑分页/内存:
		//一次性把所有数据全部查询出来存放到内存中,每次翻页都从存储中去截取指定数量的数据
		//优点:每次翻页比较快     缺点:数据庞大,可能内存溢出
	
	//真分页/物理分页/数据库分页:
		//每次翻页的时候都会从数据库中取出指定数量的数据
		//优点:数据庞大,不会内存溢出    缺点:复杂,每次翻页比较慢
	
	//分页的原理:
		//1):查询结果集
//			SELECT * FROM 表名 [WHERE 条件1 AND 条件2] LIMIT ?,?;
		
		//第一个 ? : 当前页从哪个索引开始截取数据
		//第二个 ? : 截取多少条数据: pageSize
		
	
		//查询结果总数:
			
	
	//用户传入的数据:
	
//	当前页: currentPage =1;
//	一页的数据数量: pageSize;
	
//	程序员计算三个值
//	总页数/末页: totalPage := totalPage % pageSize == 0 ? totalPage/pageSize : titalPage/pageSize + 1;

//	上一页: previous:= currentPage - 1 >= 1 ? currentPage - 1 : 1 ;
	
//	下一页: next 	:= currentPage +1 <= totalPage ? currentPage + 1 : totalPage;
	
	//先算总页数
	
	
} 