/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
/**
 *
 * @author dell
 */
public class Clock extends Thread{
	JLabel clock;
	
	public Clock(JLabel clock) {
		super();
		this.clock = clock;
	}

	public Clock() {
		super();
	}



	public void run() {
		SimpleDateFormat fm = new SimpleDateFormat("hh:mm:ss aa");
		while (true) {
			Date now = new Date();
			clock.setText(fm.format(now));
		}
	}
        public static void main(String[] args) {
        Clock a = new Clock();
            a.run();
    }
}
