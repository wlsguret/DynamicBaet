package dynamic_beat_07;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
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
	private ImageIcon startButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));

	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);

	private int mouseX, mouseY;

	private boolean isMainScreen = false; // ���۹�ư�� ������ Ȱ��ȭ

	ArrayList<Track> trackList = new ArrayList<Track>(); // ������ �� ������ ���� ����Ʈ����

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;

	public DynamicBeat() {
		setUndecorated(true); // �⺻ �޴��� ��Ȱ��ȭ
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ȭ��ũ�⸦ ���� �� �� ����
		setLocationRelativeTo(null); // ȭ���� ���߾ӿ� ����������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����â�� ���� �� ���α׷��� ����ǵ��� ����
		setVisible(true); // ȭ���� ���� ���̰� ���� �⺻���� false�̱� ������ �ʼ�����
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();

		trackList.add(new Track("Answer Title Image.png", "Answer Start Image.jpg", "Answer Game Image.jpg",
				"Square_a_Saw_-_Answer.mp3", "Square_a_Saw_-_Answer.mp3"));
		trackList.add(new Track("Hold me Title Image.png", "Hold me Start Image.jpg", "Hold me Game Image.jpg",
				"Pokki_DJ_-_Hold_Me.mp3", "Pokki_DJ_-_Hold_Me.mp3"));
		trackList.add(new Track("Smoking Title Image.png", "Smoking Start Image.png", "Smoking Game Image.png",
				"Smoking_With_Poets_-_Pain_t__On_Me.mp3", "Smoking_With_Poets_-_Pain_t__On_Me.mp3"));

		exitButton.setBounds(1245, 0, 30, 30); // Bounds=���� (x,y,width,height)
		exitButton.setBorderPainted(false); // �ܰ������׸���(false)
		exitButton.setContentAreaFilled(false); // ���뿵��ä���(false)
		exitButton.setFocusPainted(false); // ����(focus)�Ǿ����� ����� �׵θ�(false)
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage); // ���콺�� �ö󰡸� �̹��� ����
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Ŀ���� �ո������ ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage); // ���콺�� ������ ���� �̹����� ����
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Ŀ���� �⺻������ ����
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

		startButton.setBounds(110, 220, 400, 100); // Bounds=���� (x,y,width,height)
		startButton.setBorderPainted(false); // �ܰ������׸���(false)
		startButton.setContentAreaFilled(false); // ���뿵��ä���(false)
		startButton.setFocusPainted(false); // ����(focus)�Ǿ����� ����� �׵θ�(false)
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage); // ���콺�� �ö󰡸� �̹��� ����
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Ŀ���� �ո������ ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage); // ���콺�� ������ ���� �̹����� ����
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Ŀ���� �⺻������ ����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				introMusic.close(); // ���ȭ���� �Ǹ� ��Ʈ�� ������ �����Ѵ�
				selectTrack(0); // ù��° ���� �����ض�
				startButton.setVisible(false); // ���۹�ư�� ������ ���۹�ư�� �����
				quitButton.setVisible(false); // ���۹�ư�� ������ �����ư�� �����
				leftButton.setVisible(true); // �����̵���ư ��Ÿ��
				rightButton.setVisible(true); // �������̵���ư ��Ÿ��
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); // ȭ����
																												// ��ȯ��
				isMainScreen = true;

			}
		});
		add(startButton);

		quitButton.setBounds(110, 350, 400, 100); // Bounds=���� (x,y,width,height)
		quitButton.setBorderPainted(false); // �ܰ������׸���(false)
		quitButton.setContentAreaFilled(false); // ���뿵��ä���(false)
		quitButton.setFocusPainted(false); // ����(focus)�Ǿ����� ����� �׵θ�(false)
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage); // ���콺�� �ö󰡸� �̹��� ����
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Ŀ���� �ո������ ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage); // ���콺�� ������ ���� �̹����� ����
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Ŀ���� �⺻������ ����
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

		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60); // Bounds=���� (x,y,width,height)
		leftButton.setBorderPainted(false); // �ܰ������׸���(false)
		leftButton.setContentAreaFilled(false); // ���뿵��ä���(false)
		leftButton.setFocusPainted(false); // ����(focus)�Ǿ����� ����� �׵θ�(false)
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage); // ���콺�� �ö󰡸� �̹��� ����
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Ŀ���� �ո������ ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage); // ���콺�� ������ ���� �̹����� ����
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Ŀ���� �⺻������ ����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectLeft(); // ���� ���� �������� �̵�
			}
		});
		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); // Bounds=���� (x,y,width,height)
		rightButton.setBorderPainted(false); // �ܰ������׸���(false)
		rightButton.setContentAreaFilled(false); // ���뿵��ä���(false)
		rightButton.setFocusPainted(false); // ����(focus)�Ǿ����� ����� �׵θ�(false)
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage); // ���콺�� �ö󰡸� �̹��� ����
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Ŀ���� �ո������ ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage); // ���콺�� ������ ���� �̹����� ����
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Ŀ���� �⺻������ ����
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectRight(); // ���� ���� ���������� �̵�
			}
		});
		add(rightButton);

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
				setLocation(x - mouseX, y - mouseY); // �޴��ٸ� ���콺�� ���� �����ΰŸ��� ȭ���� ��ġ��Ŵ
			}
		});
		add(menuBar);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) { // g.drawImgae() �� '�̹���'�� '�����̴� �̹���' �׸� �� ���
											// paintComponents()�� add(menuBar); ó�� "add()" �� �߰��� �̹����� �׸� �� ���
		g.drawImage(background, 0, 0, null); // ��� �׸���
		if (isMainScreen) {
			g.drawImage(selectedImage, 390, 110, null); // �� �����̹��� �׸���
			g.drawImage(titleImage, 390, 300, null); // �� Ÿ��Ʋ�̹��� �׸���
		}
		paintComponents(g);
		this.repaint();
	}

	public void selectTrack(int nowSelected) { // ���� �� ���� �����Ҷ� �̹����� ������ �ٲٴ� �Լ�
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
		if (nowSelected == 0) // ���� ���õ� ���� ù���̶�� ������������ �̵�
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0; // ���� ���õ� ���� ���������̶�� ù������ �̵�
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

}
