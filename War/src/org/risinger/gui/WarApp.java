package org.risinger.gui;

import javax.swing.SwingUtilities;

public class WarApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new WarGame();
			}
		});
	}

}
