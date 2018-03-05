package bc.entity;

public class Department {
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(int id, String namaDepartemen, String alamat, String telepon) {
		super();
		this.id = id;
		this.namaDepartemen = namaDepartemen;
		this.alamat = alamat;
		this.telepon = telepon;
	}

	private int id;
	private String namaDepartemen;
	private String alamat;
	private String telepon;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaDepartemen() {
		return namaDepartemen;
	}

	public void setNamaDepartemen(String namaDepartemen) {
		this.namaDepartemen = namaDepartemen;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}
}
