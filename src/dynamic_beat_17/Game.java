package dynamic_beat_17;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();

	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image flare_circleImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	private int score;
	private int combo;
	
	// gameMaker is true = create Beat Mode [keyPress-> consoleLog{new Beat(18630,"J"),....}] consoleLog copy used by dropNote()
	public boolean gameMaker =false;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(gameMaker) { 
				note.setGameMaker(gameMaker);
				}
			if(note.getY() > 620 && !gameMaker) {
				combo = 0;
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);	
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(String.valueOf(score), 565, 702);
		
		if(true) { //판정이 뜰 때만 잠깐 나왔으면 좋겠음
			g.drawString(String.valueOf(combo), 565, 250);
		}
		g.drawImage(flare_circleImage, 490, 250, null);
		g.drawImage(judgeImage, 460, 360, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
	}

	public void pressS() {
		if(gameMaker) System.out.println("new Beat("+gameMusic.getTime()+",\"S\"),");	 
		else judge("S"); 
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("Temporary use Sound.mp3", false).start();
	}

	public void ReleaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressD() {
		if(gameMaker) System.out.println("new Beat("+gameMusic.getTime()+",\"D\"),");	 
		else judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("Temporary use Sound.mp3", false).start();
	}

	public void ReleaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressF() {
		if(gameMaker) System.out.println("new Beat("+gameMusic.getTime()+",\"F\"),");	 
		else judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("Temporary use Sound.mp3", false).start();
	}

	public void ReleaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressSpace() {
		if(gameMaker) System.out.println("new Beat("+gameMusic.getTime()+",\"Space\"),");	 
		else judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("Temporary use Sound.mp3", false).start();
	}

	public void ReleaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();		
	}

	public void pressJ() {
		if(gameMaker) System.out.println("new Beat("+gameMusic.getTime()+",\"J\"),");	 
		else judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("Temporary use Sound.mp3", false).start();
	}

	public void ReleaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressK() {
		if(gameMaker) System.out.println("new Beat("+gameMusic.getTime()+",\"K\"),");	 
		else judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("Temporary use Sound.mp3", false).start();
	}

	public void ReleaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressL() {
		if(gameMaker) System.out.println("new Beat("+gameMusic.getTime()+",\"L\"),");	 
		else judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("Temporary use Sound.mp3", false).start();
	}

	public void ReleaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt(); // interrupt(일시정지) 실행중인 쓰레드를 종료시킴.
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if (titleName.equals("Smoking_With_Poets_Pain t On Me") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 2, "S"),
					new Beat(startTime + gap * 4, "D"),
					new Beat(startTime + gap * 6, "S"),
					new Beat(startTime + gap * 8, "D"),
					new Beat(startTime + gap * 10, "F"),
					new Beat(startTime + gap * 12, "S"),
					
			};
		} else if (titleName.equals("Smoking_With_Poets_Pain t On Me") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(3090,"J"),
					new Beat(3440,"K"),
					new Beat(3800,"L"),
					new Beat(4550,"J"),
					new Beat(4840,"K"),
					new Beat(5200,"L"),
					new Beat(6040,"J"),
					new Beat(6360,"K"),
					new Beat(6740,"L"),
					new Beat(7580,"J"),
					new Beat(7890,"K"),
					new Beat(8220,"L"),
					new Beat(9040,"J"),
					new Beat(9300,"K"),
					new Beat(9670,"L"),
					new Beat(10480,"J"),
					new Beat(10790,"K"),
					new Beat(11080,"L"),
					new Beat(12020,"Space"),
					new Beat(12890,"S"),
					new Beat(13230,"D"),
					new Beat(13500,"F"),
					new Beat(14300,"J"),
					new Beat(14560,"K"),
					new Beat(14760,"L"),
					new Beat(14930,"J"),
					new Beat(15400,"K"),
					new Beat(15570,"K"),
					new Beat(18890,"J"),
					new Beat(19200,"K"),
					new Beat(19350,"L"),
					new Beat(20020,"J"),
					new Beat(20360,"K"),
					new Beat(20650,"J"),
					new Beat(21160,"F"),
					new Beat(21660,"D"),
					new Beat(22050,"S"),
					new Beat(22530,"Space"),
					new Beat(23320,"J"),
					new Beat(24540,"K"),
					new Beat(24850,"L"),
					new Beat(25160,"J"),
					new Beat(25500,"F"),
					new Beat(25910,"D"),
					new Beat(26260,"S"),
					new Beat(26690,"Space"),
					new Beat(27040,"Space"),
					new Beat(27640,"J"),
					new Beat(28070,"K"),
					new Beat(28400,"J"),
					new Beat(28530,"K"),
					new Beat(29330,"J"),
					new Beat(29730,"K"),
					new Beat(30870,"J"),
					new Beat(31190,"K"),
					new Beat(31400,"J"),
					new Beat(31620,"K"),
					new Beat(32070,"J"),
					new Beat(32240,"K"),
					new Beat(32740,"D"),
					new Beat(32850,"S"),
					new Beat(33560,"L"),
					new Beat(33770,"J"),
					new Beat(34100,"K"),
					new Beat(34470,"D"),
			};
		}else if (titleName.equals("BLACKPINK - Kill This Love")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(1940,"J"),
					new Beat(2350,"J"),
					new Beat(2800,"J"),
					new Beat(3300,"J"),
					new Beat(3730,"J"),
					new Beat(5140,"K"),
					new Beat(5150,"D"),
					new Beat(8790,"F"),
					new Beat(8790,"J"),
					new Beat(12400,"L"),
					new Beat(12400,"S"),
					new Beat(16120,"J"),
					new Beat(16579,"F"),
					new Beat(16980,"J"),
					new Beat(17400,"F"),
					new Beat(17850,"J"),
					new Beat(18320,"F"),
					new Beat(18770,"K"),
					new Beat(19260,"D"),
					new Beat(19670,"L"),
					new Beat(20160,"S"),
					new Beat(20600,"J"),
					new Beat(21080,"D"),
					new Beat(21510,"K"),
					new Beat(21910,"F"),
					new Beat(22370,"L"),
					new Beat(22850,"S"),
					new Beat(23310,"S"),
					new Beat(23310,"J"),
					new Beat(23730,"S"),
					new Beat(23730,"J"),
					new Beat(24200,"K"),
					new Beat(24220,"D"),
					new Beat(24670,"K"),
					new Beat(24690,"D"),
					new Beat(25140,"F"),
					new Beat(25140,"L"),
					new Beat(25590,"L"),
					new Beat(25610,"F"),
					new Beat(26030,"K"),
					new Beat(26070,"D"),
					new Beat(26460,"S"),
					new Beat(26460,"L"),
					new Beat(26940,"J"),
					new Beat(26960,"F"),
					new Beat(27410,"J"),
					new Beat(27850,"K"),
					new Beat(28390,"F"),
					new Beat(28810,"D"),
					new Beat(29190,"L"),
					new Beat(29490,"J"),
					new Beat(29630,"S"),
					new Beat(29800,"K"),
					new Beat(30240,"D"),
					new Beat(30610,"F"),

					
			};
		}else if (titleName.equals("Pokki_DJ_-_Hold_Me")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		} else if (titleName.equals("Square_a_Saw_-_Answer")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e){
//					Exception e 	e.printStackTrace();
				}
			}
		}
		try {
			gameMusic.join();
			System.out.println("음악끝");
			close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void judge(String input) {
		for(int i = 0; i< noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			flare_circleImage = new ImageIcon(Main.class.getResource("../images/Flare_BuleCircle.png")).getImage();
		}
		if(judge.equals("Miss")) { // 실행될 수 없는 코드
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage(); 
		}
		else if(judge.equals("Late")) {
			score += 50;
			combo ++;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
		}
		else if(judge.equals("Good")) {
			score += 80;
			combo ++;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
		}
		else if(judge.equals("Great")) {
			score += 100;
			combo ++;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
		}
		else if(judge.equals("Perfect")) {
			score += 150;
			combo ++;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
		}
		else if(judge.equals("Early")) {
			score += 50;
			combo ++;
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
		}
	}
	
	public void setGameMaker(boolean gameMaker) {
		this.gameMaker = gameMaker;
		Note note = new Note("A");
		note.setGameMaker(gameMaker);	
	}
}
