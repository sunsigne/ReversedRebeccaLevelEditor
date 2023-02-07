package com.sunsigne.reversedrebeccaleveleditor.object.characteristics;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import com.sunsigne.reversedrebeccaleveleditor.system.Editor;
import com.sunsigne.reversedrebeccaleveleditor.system.Window;
import com.sunsigne.reversedrebeccaleveleditor.system.controllers.mouse.MouseUserEvent;

public interface UpdateCursor extends MouseUserEvent {

	////////// CURSOR ////////////
	
	Cursor getCursor();

	default Cursor buildCursor(BufferedImage image) {
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(rescaleImage(image), new Point(0, 0),
				"custom_cursor");
		return cursor;
	}

	default void updateCursor(Cursor cursor) {
		if (cursor != null)
			Editor.getInstance().setCursor(cursor);
	}

	private static BufferedImage rescaleImage(BufferedImage image) {
		int x = (int) (image.getWidth() / Window.SCALE_X);
		int y = (int) (image.getHeight() / Window.SCALE_Y);

		BufferedImage img = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = img.createGraphics();

		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return img;
	}

	////////// MOUSE ////////////

	@Override
	public default void mousePressed(MouseEvent e) {
		if (isSelected())
			updateCursor(getCursor());
	}

}
