package dynamic_beat_16;

public class Track {

	private String titleImage; // ���� �κ� �̹���
	private String startImgae; // ���� ���� â ǥ�� �̹���
	private String gameImgae; // �ش� ���� �������� �� ǥ�� �̹���
	private String startMusic; // ���� ���� â ����
	private String gameMusic; // �ش� ���� �������� �� ����
	private String titleName; // �� ����

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
	
	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Track(String titleImage, String startImgae, String gameImgae, String startMusic, String gameMusic,
			String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImgae = startImgae;
		this.gameImgae = gameImgae;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}

}
