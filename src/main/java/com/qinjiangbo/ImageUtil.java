package com.qinjiangbo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class ImageUtil {
	
	/**
	 * 图片转化为二进制文件
	 * @param imagePath
	 * @return
	 * @throws IOException 
	 */
	public static String convert(String imagePath, String format) throws IOException {
		File file = new File(imagePath);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
		try {
			BufferedImage source = ImageIO.read(file);
			ImageIO.write(source, format, byteArrayOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] data = byteArrayOutputStream.toByteArray();
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encodeBuffer(data).trim();
	}
	
	public static void main(String[] args) throws IOException {
		String imagePath = "C:\\Users\\Richard\\Downloads\\emailTutorial-02\\images\\right.gif";
		System.out.println(convert(imagePath, "gif"));
	}
}
