package cn.com.fubon.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;

import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ImageUtils {

    /** 
     * 旋转图像
     */
    public static void autoRotateImage(final String src, String dest) throws Exception {
        try {
            File srcFile = new File(src);
            File destFile = new File(dest);
            BufferedImage originalImage = ImageIO.read(srcFile);

            Metadata metadata = ImageMetadataReader.readMetadata(srcFile);
            Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);

            if (directory == null || !directory.containsTag(ExifIFD0Directory.TAG_ORIENTATION)) {
                return;
            }

            int orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);

            int width = originalImage.getWidth();
            int height = originalImage.getHeight();

            AffineTransform affineTransform = new AffineTransform();

            switch (orientation) {
            case 1:
                return;
            case 2: // Flip X
                affineTransform.scale(-1.0, 1.0);
                affineTransform.translate(-width, 0);
                break;
            case 3: // PI rotation
                affineTransform.translate(width, height);
                affineTransform.rotate(Math.PI);
                break;
            case 4: // Flip Y
                affineTransform.scale(1.0, -1.0);
                affineTransform.translate(0, -height);
                break;
            case 5: // - PI/2 and Flip X
                affineTransform.rotate(-Math.PI / 2);
                affineTransform.scale(-1.0, 1.0);
                break;
            case 6: // -PI/2 and -width
                affineTransform.translate(height, 0);
                affineTransform.rotate(Math.PI / 2);
                break;
            case 7: // PI/2 and Flip
                affineTransform.scale(-1.0, 1.0);
                affineTransform.translate(-height, 0);
                affineTransform.translate(0, width);
                affineTransform.rotate(3 * Math.PI / 2);
                break;
            case 8: // PI / 2
                affineTransform.translate(0, width);
                affineTransform.rotate(3 * Math.PI / 2);
                break;
            default:
                break;
            }

            AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage destinationImage = new BufferedImage(originalImage.getHeight(), originalImage.getWidth(), originalImage.getType());
            destinationImage = affineTransformOp.filter(originalImage, destinationImage);
            ImageIO.write(destinationImage, dest.substring(dest.lastIndexOf(".") + 1), destFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * 根据尺寸图片居中裁剪 
     */
    public static void cutCenterImage(String src, String dest, int w, int h) throws IOException {
        String format = StringUtils.substringAfterLast(src, ".");
        Iterator iterator = ImageIO.getImageReadersByFormatName(format);
        ImageReader reader = (ImageReader) iterator.next();
        InputStream in = new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int imageIndex = 0;
        Rectangle rect = new Rectangle((reader.getWidth(imageIndex) - w) / 2, (reader.getHeight(imageIndex) - h) / 2, w, h);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0, param);
        ImageIO.write(bi, format, new File(dest));

    }

    /** 
     * 图片裁剪二分之一 
     */
    public static void cutHalfImage(String src, String dest) throws IOException {
        String format = StringUtils.substringAfterLast(src, ".");
        Iterator iterator = ImageIO.getImageReadersByFormatName(format);
        ImageReader reader = (ImageReader) iterator.next();
        InputStream in = new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        int imageIndex = 0;
        int width = reader.getWidth(imageIndex) / 2;
        int height = reader.getHeight(imageIndex) / 2;
        Rectangle rect = new Rectangle(width / 2, height / 2, width, height);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0, param);
        ImageIO.write(bi, format, new File(dest));
    }

    /** 
     * 图片裁剪通用接口 
     */

    public static void cutImage(String src, String dest, int x, int y, int w, int h) throws IOException {
        String format = StringUtils.substringAfterLast(src, ".");
        Iterator iterator = ImageIO.getImageReadersByFormatName(format);
        ImageReader reader = (ImageReader) iterator.next();
        InputStream in = new FileInputStream(src);
        ImageInputStream iis = ImageIO.createImageInputStream(in);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        Rectangle rect = new Rectangle(x, y, w, h);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0, param);
        ImageIO.write(bi, format, new File(dest));

    }

    /** 
     * 图片缩放 
     */
    public static void zoomImage(String src, String dest, int w, int h) throws IOException {
        double wr = 0, hr = 0;
        File srcFile = new File(src);
        File destFile = new File(dest);
        BufferedImage bufImg = ImageIO.read(srcFile);
        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);
        wr = w * 1.0 / bufImg.getWidth();
        hr = h * 1.0 / bufImg.getHeight();
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bufImg, null);
        ImageIO.write((BufferedImage) Itemp, dest.substring(dest.lastIndexOf(".") + 1), destFile);
    }
    
    
    
    public static  void zoomImageByWidth(String src, String dest, int width){    	
	    InputStream is = null; 
        BufferedImage bi = null; 
        int srcHeight = 1; //原图高度 
        int srcWidth = 1; //原图宽度
        int srcRealityWidth = 1; //原图实际宽度，考虑图片倒置问题
        int scaling=1;  //缩放比例
        try { 
            is = new FileInputStream(src); 
            bi = javax.imageio.ImageIO.read(is); 
            srcHeight=bi.getHeight();  // 得到源图高 
            srcWidth=bi.getWidth();  // 得到源图高          
            is.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
      if(srcWidth>srcHeight){ //图片是倒置的，宽、高对换一下
    	  srcRealityWidth= srcHeight;
      }	else{
    	  srcRealityWidth= srcWidth;  
      }	        
      scaling=srcRealityWidth/width; //计算比例 		        
      try {
		 	ImageUtils.zoomImage(src, dest, srcWidth/scaling, srcHeight/scaling);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
 
  }
    
    public static  int getImageWidth(String src){    	
    	InputStream is = null; 
        BufferedImage bi = null; 
        int srcHeight = 1; //原图高度 
        int srcWidth = 1; //原图宽度
        int srcRealityWidth = 1; //原图实际宽度，考虑图片倒置问题
        int scaling=1;  //缩放比例
        try { 
            is = new FileInputStream(src); 
            bi = javax.imageio.ImageIO.read(is); 
            srcHeight=bi.getHeight();  // 得到源图高 
            srcWidth=bi.getWidth();  // 得到源图高          
            is.close(); 
          } catch (Exception e) { 
            e.printStackTrace(); 
         } 
        if(srcWidth>srcHeight){ //图片是倒置的，宽、高对换一下
    	    srcRealityWidth= srcHeight;
         }else{
    	   srcRealityWidth= srcWidth; 
         }
		  return srcRealityWidth;
       }

    public static byte[] File2byte(String filePath)  
    {  
        byte[] buffer = null;  
        try  
        {  
            File file = new File(filePath);  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            byte[] b = new byte[1024];  
            int n;  
            while ((n = fis.read(b)) != -1)  
            {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        }  
        catch (FileNotFoundException e)  
        {  
            e.printStackTrace();  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
        return buffer;  
    } 
    
    
}
