package dynamic_beat_08;

public class Track {
	
	private String titleImage; // ���� �κ� �̹���
	private String startImgae; // ���� ���� â ǥ�� �̹���
	private String gameImgae; // �ش� ���� �������� �� ǥ�� �̹���
	private String startMusic; // ���� ���� â ����
	private String gameMusic; // �ش� ���� �������� �� ����
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImgae() {
		return startImgae;
	}
	public void setStartImgae(String startImgae) {
		this.startImgae = startImgae;
	}
	public String getGameImgae() {
		return gameImgae;
	}
	public void setGameImgae(String gameImgae) {
		this.gameImgae = gameImgae;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
	public Track(String titleImage, String startImgae, String gameImgae, String startMusic, String gameMusic) {
		super();
		this.titleImage = titleImage;
		this.startImgae = startImgae;
		this.gameImgae = gameImgae;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
	}
	
	
}
