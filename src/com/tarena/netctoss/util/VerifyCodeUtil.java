package com.tarena.netctoss.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class VerifyCodeUtil {
	private String code;
	private byte[] codeArr;
	private static char[] seq = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
		'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
		'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
		'9' };
	public String getCode(){
		return code;
	}
	public byte[] getCodeArr(){
		return codeArr;
	}
	public void generate(int width,int height , int num )throws Exception{
		Random r = new Random();
		BufferedImage image = new BufferedImage(width,height,num);
		Graphics g = image.getGraphics();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillRect(0, 0, width, height);
		g.setColor(new Color(0,0,0));
		StringBuffer number = new StringBuffer();
		for(int i = 0 ; i < num ; i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			int h = (int)((height * 60 / 100) * r.nextDouble() + (height * 30 / 100));
			g.setFont(new Font(null, Font.BOLD | Font.ITALIC, h));
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			number.append(ch);
			g.drawString(ch, i * width / num * 90 / 100, h);
		}
		for (int i = 0; i <= 12; i++) {
			g
					.setColor(new Color(r.nextInt(255), r.nextInt(255), r
							.nextInt(255)));
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r
					.nextInt(height));

		}
		code = number.toString();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
		encoder.encode(image);
		codeArr = baos.toByteArray();
		
	}

}