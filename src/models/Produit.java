package models;

public class Produit {
	private String nom_et_prenom;
	private String dateNai;
	private String lieuNai;
	private String mention;
	private String filiere;
	private String niveau;
	private String commune;
	private String adresse;
	private int phone;
	private String image;
	private int id;
	
	public Produit() {}
	
	public Produit(int id, String nom_et_prenom, String dateNai, String lieuNai, String mention, String niveau, String adresse, int phone, String commune, String image) {
		this.id = id;
		this.nom_et_prenom = nom_et_prenom;
		this.dateNai = dateNai;
		this.lieuNai = lieuNai;
		this.mention = mention;
		this.niveau = niveau;
		this.commune = commune;
		this.adresse = adresse;
		this.phone = phone;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom_et_prenom;
	}

	public void setNom(String nom) {
		this.nom_et_prenom = nom;
	}
	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDateNai() {
		return dateNai;
	}

	public void setDateNai(String dateNai) {
		this.dateNai = dateNai;
	}

	public String getLieuNai() {
		return lieuNai;
	}

	public void setLieuNai(String lieuNai) {
		this.lieuNai = lieuNai;
	}

	public String getMention() {
		return mention;
	}

	public void setMention(String mention) {
		this.mention = mention;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	

}
