package dao;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;





public class CreateImg {
	public static final int width = 100; 
	public static final int height = 30;
	public static final int length = 4;
	public static final int linecount = 20;
	public static final String str = "23456789" + 
	"ABCDEFGHJKLMNPQRSTUVWXYZ" + "abcdefghigklmnpqrstuvwxyz";
	public static Random random = new Random();
	
	public String CreateCode(){
		String code = "";
		for(int i = 0;i < length;i++)
		{
			char c = str.charAt(random.nextInt(str.length()));
			code += c;
		}	
		return code;
	}
	
	public BufferedImage createImage(String vcode){
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = image.getGraphics();//获取画笔
		
		
		g.setColor(Color.white);//设置图片背景
		g.fillRect(0, 0, width, height);//设置图片尺寸
		drawChar(g,vcode);//图片上画上字符
		for(int i = 0; i < length; i ++)//图片上画上随机线条
		{
			drawLine(g);
		}
		g.dispose();
		return image;
	}
	
	//获取不同的颜色
	public Color getColor(){
		return new Color(random.nextInt(255),random.nextInt(255),
				random.nextInt(255));
	}
	//获取字体
	public Font getFont(){
		return new Font("Fixedsys",Font.CENTER_BASELINE,22);
	}
	//绘制字符
	public void drawChar(Graphics g,String code){
		g.setFont(getFont());
		for(int i = 0;i < length;i++)
		{
			char c = code.charAt(i);
			g.setColor(getColor());
			g.drawString(c + "", 20*i+10, 20);
		}
	}
	//绘制随机线
	public void drawLine(Graphics g){
		int x1 = random.nextInt(width);
		int y1 = random.nextInt(height);
		int x2 = random.nextInt(15);
		int y2 = random.nextInt(15);
		g.setColor(getColor());
		g.drawLine(x1, y1, x1+x2, y1+y2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
