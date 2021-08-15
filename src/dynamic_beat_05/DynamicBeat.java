package dynamic_beat_05;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	private int mouseX, mouseY;

	public DynamicBeat() {
		setUndecorated(true); // 기본 메뉴바 비활성화
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 화면크기를 변경 할 수 없음
		setLocationRelativeTo(null); // 화면이 정중앙에 켜지도록함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 껏을 떄 프로그램이 종료되도록 설정
		setVisible(true); // 화면이 눈에 보이게 해줌 기본값이 false이기 때문에 필수적임
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		exitButton.setBounds(1245, 0, 30, 30); // Bounds=범위 (x,y,width,height)
		exitButton.setBorderPainted(false); // 외곽선을그린다(false)
		exitButton.setContentAreaFilled(false); // 내용영역채우기(false) 
		exitButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);	// 마우스가 올라가면 이미지 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(110, 220, 400, 100); // Bounds=범위 (x,y,width,height)
		startButton.setBorderPainted(false); // 외곽선을그린다(false)
		startButton.setContentAreaFilled(false); // 내용영역채우기(false) 
		startButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);	// 마우스가 올라가면 이미지 변경
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				startButton.setVisible(false); // 시작버튼을 누르면 시작버튼이 사라짐
				quitButton.setVisible(false); // 시작버튼을 누르면 종료버튼이 사라짐
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); // 화면이 전환됨
				
				
			}
		});
		add(startButton);
		
		quitButton.setBounds(110, 350, 400, 100); // Bounds=범위 (x,y,width,height)
		quitButton.setBorderPainted(false); // 외곽선을그린다(false)
		quitButton.setContentAreaFilled(false); // 내용영역채우기(false) 
		quitButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);	// 마우스가 올라가면 이미지 변경
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}			
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY); // 메뉴바를 마우스로 집고 움직인거리로 화면을 위치시킴
			}
		});
		add(menuBar);

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}
