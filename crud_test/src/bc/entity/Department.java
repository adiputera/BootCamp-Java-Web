package bc.entity;

public class Department {
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(int id, String namaDepartemen, String alamat, String email) {
		super();
		this.id = id;
		this.namaDepartemen = namaDepartemen;
		this.alamat = alamat;
		this.email = email;
	}

	private int id;
	private String namaDepartemen;
	private String alamat;
	private String email;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
