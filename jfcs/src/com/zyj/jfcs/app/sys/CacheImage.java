package com.zyj.jfcs.app.sys;
/**
 * 	图片缓存类，负责创建、缓存、销毁图片资源
 * @author zhouyj
 *
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.zyj.jfcs.constants.AppConst;
/**
 * 	图像缓存工具类：负责图像的创建、缓存、销毁等工作
 * @author zhouyj
 *
 */
public class CacheImage {
	
	/**
	 * 	缓存容器
	 */
	private static final Map<String, Image> imageMap = new HashMap<String, Image>();
	
	/**
	 * 	构造私有化，使用单例模式
	 */
	private CacheImage() {
		super();
	}
	
	/**
	 * 	获取图像资源
	 * @param applicationId  	应用ID
	 * @param imagePath			图片路径
	 * @return
	 */
	public static Image getImage(String applicationId, String imagePath) {
		if(StringUtils.isBlank(imagePath)) {
			return null;
		}
		Image image = imageMap.get(imagePath);
		if(image == null) {
			//创建图片资源并缓存
			image = AbstractUIPlugin.imageDescriptorFromPlugin(applicationId, imagePath).createImage();
			imageMap.put(imagePath, image);
		}
		return image;
	}
	
	/**
	 * 获取应用图片
	 * @param imagePath
	 * @return
	 */
	public static Image getAppImage(String imagePath) {
		return getImage(AppConst.APPLICATION_ID, imagePath);
	}
	
	/**
	 * 	清理图像缓存资源
	 */
	public static void dispose() {
		Iterator<Image> iterator = imageMap.values().iterator();
		while(iterator.hasNext()) {
			//逐个清理
			iterator.next().dispose();
		}
		//清理容器
		imageMap.clear();
	}
	
}
