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
		setUndecorated(true); // �⺻ �޴��� ��Ȱ��ȭ
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ȭ��ũ�⸦ ���� �� �� ����
		setLocationRelativeTo(null); // ȭ���� ���߾ӿ� ����������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����â�� ���� �� ���α׷��� ����ǵ��� ����
		setVisible(true); // ȭ���� ���� ���̰� ���� �⺻���� false�̱� ������ �ʼ�����
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		exitButton.setBounds(1245, 0, 30, 30); // Bounds=���� (x,y,width,height)
		exitButton.setBorderPainted(false); // �ܰ������׸���(false)
		exitButton.setContentAreaFilled(false); // ���뿵��ä���(false) 
		exitButton.setFocusPainted(false); // ����(focus)�Ǿ����� ����� �׵θ�(false)
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);	// ���콺�� �ö󰡸� �̹��� ����
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
				startButton.setIcon(startButtonEnteredImage);	// ���콺�� �ö󰡸� �̹��� ����
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
				startButton.setVisible(false); // ���۹�ư�� ������ ���۹�ư�� �����
				quitButton.setVisible(false); // ���۹�ư�� ������ �����ư�� �����
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage(); // ȭ���� ��ȯ��
				
				
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
				quitButton.setIcon(quitButtonEnteredImage);	// ���콺�� �ö󰡸� �̹��� ����
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
