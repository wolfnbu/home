package com.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * this is for read image automaticly
 * @author allandeng
 *
 */
public class ImageFileReadUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
	}
	
	@SuppressWarnings("finally")
	public static List<String> getBroadCastImageFiles(String realPath) {
		List<String> imageFilesMap = new ArrayList<String>();
		try {
			String imagePath  = PropertiesUtil.getProperties(PropertiesUtil.PATH_BROADCAST_IMAGE);
			System.out.println("imagePath: " + imagePath);
			File fileImagePath = new File(realPath + imagePath);
			if (!fileImagePath.isDirectory()) {
				throw new Exception("Configured image path is not exists!");
			}
			File[] imageFiles = fileImagePath.listFiles();
			for (File imageFile:imageFiles) {
				String fileName = imageFile.getName();
				String filePath = imageFile.getPath();
				System.out.println(fileName + " : " + filePath);
				imageFilesMap.add(imagePath + fileName);
			}
		} catch (Exception e) {
			System.out.println("Error when read broadcast images");
			e.printStackTrace();
		} finally {
			return imageFilesMap;
		}
	}
}
