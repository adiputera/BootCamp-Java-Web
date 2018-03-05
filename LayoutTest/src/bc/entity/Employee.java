package bc.entity;

public class Employee {
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String nama, String alamat, String email) {
		super();
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
		this.email = email;
	}

	private int id;
	private String nama;
	private String alamat;
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
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
