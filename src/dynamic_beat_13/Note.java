package dynamic_beat_13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

		private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
		private int x, y = 580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED; 
		// (y좌표) 노트가 생성되면 -120에서 1초에 700 만큼 떨어져 1초뒤에 판정라인(580)에 도착한다.
		private String noteType;
		
		public Note(int x, String noteType) {
			this.x = x;
			this.noteType = noteType;
		}
		
		public void screenDraw(Graphics2D g) {
			if(noteType.equals("short"))
			{
				g.drawImage(noteBasicImage, x, y, null);
			}
			else if(noteType.equals("long")) 
			{
				g.drawImage(noteBasicImage, x, y, null);
				g.drawImage(noteBasicImage, x + 100, y, null);				
			}
		}
		
		public void drop() {
			y += Main.NOTE_SPEED;
		}
		
		@Override
		public void run() {
			try {
				while (true) { // 1초에 700픽셀만큼 y좌표가 아래로 내려간다.
					drop();
					Thread.sleep(Main.SLEEP_TIME);
				}
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		
}
