package verifycode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCodeServlet extends HttpServlet{
	
	
	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String uuid = UUID.randomUUID().toString().substring(0,5);
		
		//把随机数放在session中
		request.getSession().setAttribute("VERIFY_IN_SESSION", uuid);
		
		int width = 200;
		int height = 60;
		Random random = new Random();
		
		//定义图像Buffer
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		//获取图片的上下文
		Graphics graphic = image.getGraphics();
		
		//给图片背景设置颜色(白色)
		graphic.setColor(Color.white);
		//背景填充该图片
		graphic.fillRect(0,0,width,height);
		
		//设定图片边框
		graphic.setColor(Color.gray);
		graphic.drawRect(0,0,width -1,height - 1);
		
		
		//画干扰线
		
		for(int i=0;i<10;i++){
			
			//产生的随机整数
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width);
			int y2 = random.nextInt(height);
			
			//设置线的颜色
			graphic.setColor(randomColor());
			
			//两点确定直线
			graphic.drawLine(x1,y1,x2,y2);
			
		}
		
		graphic.setColor(randomColor());
		graphic.setFont(randomFont());
		
		//把随机字母画上去
		
		for(int i=0;i<uuid.length();i++){
			
			graphic.drawString(uuid.charAt(i)+"",(i)*15+r.nextInt(8)+40,r.nextInt(20)+30);
		}
		
		System.out.println(uuid);
		
		//图像生效
		graphic.dispose();
		// 禁止图像缓存。     
		response.setHeader("Pragma","no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires",0);
		
		ImageIO.write(image,"JPEG",response.getOutputStream());
	}
	
	
	private Random r = new Random();
	private String[] fontNames = new String[]{"宋体", "华文楷体", "黑体", "微软雅黑","Castellar"};
    // 生成随机的颜色
    private Color randomColor() {
    	
    	
    	
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int blue = r.nextInt(150);
        return new Color(red, green, blue);
    }
	
    
    private Font randomFont(){
    	
    	int index = r.nextInt(fontNames.length);
    	//获取字体
    	String fontName = fontNames[index];
    	System.out.println(fontName);
    	//风格:一共3种
    	int style = 1;
    	
    	//字号
    	int size = r.nextInt(3)+40;
    	
    	return new Font(fontName,style,size);
    }
	
	
}