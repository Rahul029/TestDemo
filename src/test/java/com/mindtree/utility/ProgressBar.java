package com.mindtree.utility;


import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBar extends JFrame {


		static JProgressBar b;
		static int i = 0, num = 0;

		public ProgressBar() {
			b = new JProgressBar(0,40);
			b.setUI(new CircularProgressBar());
			b.setBounds(0,0,160,160);
			b.setValue(0);
			b.setStringPainted(true);
			add(b);
			setSize(200, 200);
			
			setLayout(null);
		}

		public static void setProgress() {
			b.setValue(i+=10);
		}

}
