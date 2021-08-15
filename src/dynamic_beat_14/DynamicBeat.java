package dynamic_beat_14;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;

	private boolean isMainScreen = false; 
	private boolean isGameScreen = false;

	ArrayList<Track> trackList = new ArrayList<Track>(); // 각각의 곡 정보를 담은 리스트생성

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("introMusic.mp3", true);
	private int nowSelected = 0;
	
	public static Game game;

	public DynamicBeat() {
		trackList.add(new Track("Answer Title Image.png", "Answer Start Image.jpg", "Answer Game Image.jpg",
				"Square_a_Saw_-_Answer.mp3", "Square_a_Saw_-_Answer.mp3", "Square_a_Saw_-_Answer"));
		trackList.add(new Track("Hold me Title Image.png", "Hold me Start Image.jpg", "Hold me Game Image.jpg",
				"Pokki_DJ_-_Hold_Me.mp3", "Pokki_DJ_-_Hold_Me.mp3", "Pokki_DJ_-_Hold_Me"));
		trackList.add(new Track("Smoking Title Image.png", "Smoking Start Image.png", "Smoking Game Image.jpg",
				"Smoking_With_Poets_-_Pain_t__On_Me.mp3", "Smoking_With_Poets_-_Pain_t__On_Me.mp3", "Smoking_With_Poets_Pain t On Me"));

		setUndecorated(true); // 기본 메뉴바 비활성화
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 화면크기를 변경 할 수 없음
		setLocationRelativeTo(null); // 화면이 정중앙에 켜지도록함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 껏을 떄 프로그램이 종료되도록 설정
		setVisible(true); // 화면이 눈에 보이게 해줌 기본값이 false이기 때문에 필수적임
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		introMusic.start();
		
		
		exitButton.setBounds(1245, 0, 30, 30); // Bounds=범위 (x,y,width,height)
		exitButton.setBorderPainted(false); // 외곽선을그린다(false)
		exitButton.setContentAreaFilled(false); // 내용영역채우기(false)
		exitButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage); // 마우스가 올라가면 이미지 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				buttonEnteredMusicPlay();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonPressedMusicPlay();
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
				startButton.setIcon(startButtonEnteredImage); // 마우스가 올라가면 이미지 변경
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				buttonEnteredMusicPlay();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonPressedMusicPlay();
				enterMain();
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
				quitButton.setIcon(quitButtonEnteredImage); // 마우스가 올라가면 이미지 변경
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				buttonEnteredMusicPlay();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonPressedMusicPlay();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);

		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60); // Bounds=범위 (x,y,width,height)
		leftButton.setBorderPainted(false); // 외곽선을그린다(false)
		leftButton.setContentAreaFilled(false); // 내용영역채우기(false)
		leftButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage); // 마우스가 올라가면 이미지 변경
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				buttonEnteredMusicPlay();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonPressedMusicPlay();
				selectLeft(); // 선택 곡을 왼쪽으로 이동
			}
		});
		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); // Bounds=범위 (x,y,width,height)
		rightButton.setBorderPainted(false); // 외곽선을그린다(false)
		rightButton.setContentAreaFilled(false); // 내용영역채우기(false)
		rightButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage); // 마우스가 올라가면 이미지 변경
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				buttonEnteredMusicPlay();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonPressedMusicPlay();
				selectRight(); // 선택 곡을 오른쪽으로 이동
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 630, 250, 67); // Bounds=범위 (x,y,width,height)
		easyButton.setBorderPainted(false); // 외곽선을그린다(false)
		easyButton.setContentAreaFilled(false); // 내용영역채우기(false)
		easyButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage); // 마우스가 올라가면 이미지 변경
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				buttonEnteredMusicPlay();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonPressedMusicPlay();
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(655, 630, 250, 67); // Bounds=범위 (x,y,width,height)
		hardButton.setBorderPainted(false); // 외곽선을그린다(false)
		hardButton.setContentAreaFilled(false); // 내용영역채우기(false)
		hardButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage); // 마우스가 올라가면 이미지 변경
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				buttonEnteredMusicPlay();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonPressedMusicPlay();
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60); // Bounds=범위 (x,y,width,height)
		backButton.setBorderPainted(false); // 외곽선을그린다(false)
		backButton.setContentAreaFilled(false); // 내용영역채우기(false)
		backButton.setFocusPainted(false); // 선택(focus)되었을때 생기는 테두리(false)
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage); // 마우스가 올라가면 이미지 변경
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // 커서를 손모양으로 변경
				buttonEnteredMusicPlay();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage); // 마우스가 나가면 원래 이미지로 변경
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // 커서를 기본값으로 변경
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttonPressedMusicPlay();
				backMain();
			}
		});
		add(backButton);

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
				setLocation(x - mouseX, y - mouseY); // 메뉴바를 마우스로 잡고 이동한위치에 화면을 나타냄
			}
		});
		add(menuBar);
		
	}

	
	
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) { // g.drawImgae() 는 '이미지'나 '움직이는 이미지' 그릴 때 사용
											// paintComponents()는 add(menuBar); 처럼 "add()" 즉 추가된 이미지를 그릴 때 사용
		g.drawImage(background, 0, 0, null); // 배경 그리기
		if (isMainScreen) {
			g.drawImage(selectedImage, 390, 110, null); // 곡 선택이미지 그리기
			g.drawImage(titleImage, 390, 300, null); // 곡 타이틀이미지 그리기
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}

	public void selectTrack(int nowSelected) { // 선택 된 곡을 변경할때 이미지와 음악을 바꾸는 함수
		if (selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImgae()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();

	}

	public void selectLeft() {
		if (nowSelected == 0) // 현재 선택된 곡이 첫곡이라면 마지막곡으로 이동
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0; // 현재 선택된 곡이 마지막곡이라면 첫곡으로 이동
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false); 
		rightButton.setVisible(false); 
		easyButton.setVisible(false); 
		hardButton.setVisible(false); 
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImgae())).getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
	}
	
	public void backMain() {
		backButton.setVisible(false);
		isGameScreen = false;
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		leftButton.setVisible(true); 
		rightButton.setVisible(true); 
		easyButton.setVisible(true); 
		hardButton.setVisible(true);
		isMainScreen = true;
		selectTrack(nowSelected);
		game.close();
	}
	
	public void enterMain() {
		startButton.setVisible(false); 
		quitButton.setVisible(false); 
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); 																												
		leftButton.setVisible(true); 
		rightButton.setVisible(true); 
		easyButton.setVisible(true); 
		hardButton.setVisible(true); 
		isMainScreen = true;
		introMusic.close(); // 메인화면에서 인트로 뮤직을 종료한다
		selectTrack(0); // 트랙리스트에서 첫번째 곡을 선택해라
	}
	
	public void buttonEnteredMusicPlay() {
		Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
		buttonEnteredMusic.start();
	}
	
	public void buttonPressedMusicPlay() {
		Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
		buttonPressedMusic.start();
	}

	
}
