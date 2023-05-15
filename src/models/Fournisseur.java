package models;

public class Fournisseur {
	private String reference;
	private String nom_entreprise;
	private String adresseF;
	private String nom_et_prenom;
	private int telephone;
	private String emailF;
	
	public Fournisseur() {
		
	}
	public Fournisseur(String reference, String nom_entreprise, String adresseF, String nom_et_prenom, int telephone, String emailF) {
		this.reference = reference;
		this.nom_entreprise = nom_entreprise;
		this.adresseF = adresseF;
		this.nom_et_prenom = nom_et_prenom;
		this.telephone = telephone;
		this.emailF = emailF;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNom_entreprise() {
		return nom_entreprise;
	}
	public void setNom_entreprise(String nom_entreprise) {
		this.nom_entreprise = nom_entreprise;
	}
	public String getAdresseF() {
		return adresseF;
	}
	public void setAdresseF(String adresseF) {
		this.adresseF = adresseF;
	}
	public String getNom_et_prenom() {
		return nom_et_prenom;
	}
	public void setNom_et_prenom(String nom_et_prenom) {
		this.nom_et_prenom = nom_et_prenom;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getEmailF() {
		return emailF;
	}
	public void setEmailF(String emailF) {
		this.emailF = emailF;
	}
	
}
