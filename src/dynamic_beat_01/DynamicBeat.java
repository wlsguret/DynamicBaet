package dynamic_beat_01;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 화면크기를 변경 할 수 없음
		setLocationRelativeTo(null); // 화면이 정중앙에 켜지도록함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 껏을 떄 프로그램이 종료되도록 설정
		setVisible(true); // 화면이 눈에 보이게 해줌 기본값이 false이기 때문에 필수적임
		
	}

}
