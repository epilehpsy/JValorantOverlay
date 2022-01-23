package felpud0.controller;

import java.awt.EventQueue;

import felpud0.view.SetupWin;

public class Launcher {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupWin window = new SetupWin();
					window.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
