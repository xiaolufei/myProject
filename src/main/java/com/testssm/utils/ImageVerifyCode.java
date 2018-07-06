package com.testssm.utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;

/**
 * 图形验证码
 */
public class ImageVerifyCode {
	static Random random = new Random();
	static String ssource = "1234567890";
	static char[] src = ssource.toCharArray();

	// 根据长度获取随机字符串
	private static String randString(int length) {
		char[] buf = new char[length];
		int rnd;
		for (int i = 0; i < length; i++) {
			rnd = Math.abs(random.nextInt()) % src.length;
			buf[i] = src[rnd];
		}
		return new String(buf);
	}

	// 根据指定的长度，获取指定长度的随机字符串
	public static String getVerifyCode(int length) {
		String VerifyCode = randString(length);
		return VerifyCode;
	}
	
	public static String flushVerifyCode(HttpServletResponse response,
			String sCode) {
		try {
			OutputStream out = response.getOutputStream();
			outputImage(200, 80, out, sCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Font getRandomFont() {
		String[] fonts = { "Georgia", "Verdana", "Arial", "Tahoma",
				"Time News Roman", "Courier New", "华文新魏", "华文隶书", "方正舒体",
				"方正姚体", "华文行楷", "Arial Black", "Quantzite" };
		int fontIndex = random.nextInt(fonts.length - 1);
		int fontSize = 76;
		return new Font(fonts[fontIndex], Font.ITALIC, fontSize);
	}


	
	   /** 
	     * 输出指定验证码图片流 
	     * @param w 
	     * @param h 
	     * @param os 
	     * @param code 
	     * @throws IOException 
	     */  
	    public static void outputImage(int w, int h, OutputStream os, String code) throws IOException{  
	        int verifySize = code.length();  
	        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
	        Random rand = new Random();  
	        Graphics2D g2 = image.createGraphics();  
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
	        Color[] colors = new Color[5];  
	        Color[] colorSpaces = new Color[] { Color.WHITE, Color.CYAN,  
	                Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,  
	                Color.PINK, Color.YELLOW };  
	        float[] fractions = new float[colors.length];  
	        for(int i = 0; i < colors.length; i++){  
	            colors[i] = colorSpaces[rand.nextInt(colorSpaces.length)];  
	            fractions[i] = rand.nextFloat();  
	        }  
	        Arrays.sort(fractions);  
	          
	        g2.setColor(Color.GRAY);// 设置边框色  
	        g2.fillRect(0, 0, w, h);  
	          
	        Color c = getRandColor(200, 250);  
	        g2.setColor(c);// 设置背景色  
	        g2.fillRect(0, 2, w, h-4);  
	          
	        //绘制干扰线  
	        Random random = new Random();  
	        g2.setColor(getRandColor(160, 200));// 设置线条的颜色  
	        for (int i = 0; i < 40; i++) {  
	            int x = random.nextInt(w - 1);  
	            int y = random.nextInt(h - 1);  
	            int xl = random.nextInt(6) + 1;  
	            int yl = random.nextInt(12) + 1;  
	            g2.drawLine(x, y, x + xl + 40, y + yl + 20);  
	        }  
	          
	        // 添加噪点  
	        float yawpRate = 0.05f;// 噪声率  
	        int area = (int) (yawpRate * w * h);  
	        for (int i = 0; i < area; i++) {  
	            int x = random.nextInt(w);  
	            int y = random.nextInt(h);  
	            int rgb = getRandomIntColor();  
	            image.setRGB(x, y, rgb);  
	        }  
	          
	        shear(g2, w, h, c);// 使图片扭曲  
	  
	        g2.setColor(getRandColor(100, 160));  
	        int fontSize = h-4;  
	        //Font font = new Font("Algerian", Font.ITALIC, fontSize);  
	        g2.setFont(getRandomFont());  
	        char[] chars = code.toCharArray();  
	        for(int i = 0; i < verifySize; i++){  
	            AffineTransform affine = new AffineTransform();  
	            affine.setToRotation(Math.PI / 4 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1), (w / verifySize) * i + fontSize/2, h/2);  
	            g2.setTransform(affine);  
	            g2.drawChars(chars, i, 1, ((w-10) / verifySize) * i + 5, h/2 + fontSize/2 - 10);  
	        }  
	          
	        g2.dispose();  
	        ImageIO.write(image, "jpg", os);  
	    } 

	    
	    
	    private static int getRandomIntColor() {  
	        int[] rgb = getRandomRgb();  
	        int color = 0;  
	        for (int c : rgb) {  
	            color = color << 8;  
	            color = color | c;  
	        }  
	        return color;  
	    }  
	    private static int[] getRandomRgb() {  
	        int[] rgb = new int[3];  
	        for (int i = 0; i < 3; i++) {  
	            rgb[i] = random.nextInt(255);  
	        }  
	        return rgb;  
	    }  
	    
	    private static void shear(Graphics g, int w1, int h1, Color color) {  
	        shearX(g, w1, h1, color);  
	        shearY(g, w1, h1, color);  
	    }  

	    
	    private static void shearX(Graphics g, int w1, int h1, Color color) {  
		  
	        int period = random.nextInt(2);  
	  
	        boolean borderGap = true;  
	        int frames = 1;  
	        int phase = random.nextInt(2);  
	  
	        for (int i = 0; i < h1; i++) {  
	            double d = (double) (period >> 1)  
	                    * Math.sin((double) i / (double) period  
	                            + (6.2831853071795862D * (double) phase)  
	                            / (double) frames);  
	            g.copyArea(0, i, w1, 1, (int) d, 0);  
	            if (borderGap) {  
	                g.setColor(color);  
	                g.drawLine((int) d, i, 0, i);  
	                g.drawLine((int) d + w1, i, w1, i);  
	            }  
	        }  
	  
	    }  
	  
	    private static void shearY(Graphics g, int w1, int h1, Color color) {  
	  
	        int period = random.nextInt(40) + 10; // 50;  
	  
	        boolean borderGap = true;  
	        int frames = 20;  
	        int phase = 7;  
	        for (int i = 0; i < w1; i++) {  
	            double d = (double) (period >> 1)  
	                    * Math.sin((double) i / (double) period  
	                            + (6.2831853071795862D * (double) phase)  
	                            / (double) frames);  
	            g.copyArea(i, 0, 1, h1, 0, (int) d);  
	            if (borderGap) {  
	                g.setColor(color);  
	                g.drawLine(i, (int) d, i, 0);  
	                g.drawLine(i, (int) d + h1, i, h1);  
	            }  
	  
	        }  
	  
	    }  
		// 获取随机颜色
	    private static Color getRandColor(int fc, int bc) {  
	        if (fc > 255)  
	            fc = 255;  
	        if (bc > 255)  
	            bc = 255;  
	        int r = fc + random.nextInt(bc - fc);  
	        int g = fc + random.nextInt(bc - fc);  
	        int b = fc + random.nextInt(bc - fc);  
	        return new Color(r, g, b);  
	    }  

}


