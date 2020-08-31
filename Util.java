package com.deepsingh44.blogspot.utility;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Util {
	public static final String[] COURSE = { "Course", "Java", "Python", "Php", "Android", "C/C++", "Others" };
	public static final String[] TYPE = { "Type", "w/e", "w/d" };
	public static final String[] HOUR = { "Hour", "1", "2", "3", "4", "5", "6", "9", "10", "11", "12" };
	public static final String[] MIN = { "Min", "00", "30" };

	public static void log(Class c, String msg) {
		System.out.println(c.getCanonicalName() + ":" + msg);
	}

	public static ImageIcon resize(ImageIcon im, int w, int h) {
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D gd = (Graphics2D) bi.createGraphics();
		gd.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		gd.drawImage(im.getImage(), 0, 0, w, h, null);
		gd.dispose();
		return new ImageIcon(bi);
	}

	public static void showWarning(Component cmp, String msg) {
		JOptionPane.showMessageDialog(cmp, msg, "Warning-Message", JOptionPane.WARNING_MESSAGE);
	}

	public static void showError(Component cmp, String msg) {
		JOptionPane.showMessageDialog(cmp, msg, "Error-Message", JOptionPane.ERROR_MESSAGE);
	}

	public static void showMessage(Component cmp, String msg) {
		JOptionPane.showMessageDialog(cmp, msg);
	}

	public static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static Properties properties = new Properties();

	public static Properties getMyDatabaseProperty() {
		try {
			URL u = Thread.currentThread().getContextClassLoader()
					.getResource("com/deepsingh44/blogspot/properties/database.properties");
			properties.load(new FileInputStream(new File(u.toURI())));
		} catch (Exception e) {
			Util.log(Util.class, e.toString());
		}
		return properties;
	}

}
