package bc.entity;

public class Mahasiswa {
	public Mahasiswa() {
		// TODO Auto-generated constructor stub
	}
	
	public Mahasiswa(String nim, String nama, String alamat, String univ) {
		super();
		this.nim = nim;
		this.nama = nama;
		this.alamat = alamat;
		this.univ = univ;
	}

	private String nim;
	private String nama;
	private String alamat;
	private String univ;
	
	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
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

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}
	
}
