package com.sunsigne.reversedrebeccaleveleditor.system;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.sunsigne.reversedrebeccaleveleditor.Infos;

public class Window {

	public static final int WIDHT = 1920;
	public static final int HEIGHT = 1080;

	public static final float SCALE_X = (float) Toolkit.getDefaultToolkit().getScreenSize().width / WIDHT;
	public static final float SCALE_Y = (float) Toolkit.getDefaultToolkit().getScreenSize().height / HEIGHT;

	protected Window(Editor editor) {

		editor.setMinimumSize(new Dimension(WIDHT, HEIGHT));
		editor.setMaximumSize(new Dimension(WIDHT, HEIGHT));
		editor.setPreferredSize(new Dimension(WIDHT, HEIGHT));
		// editor.setFocusTraversalKeysEnabled(false); // allow TAB as valid key

		ImageIcon icon = Infos.ICON;
		JFrame frame = new JFrame(Infos.NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		frame.add(editor, BorderLayout.CENTER);
		frame.setIconImage(icon.getImage());
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

}
