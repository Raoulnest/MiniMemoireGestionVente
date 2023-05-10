package models;

public class Stock {
	String reference;
	String designation;
	int idCategorie;
	int idFournisseur;
	double prixUnitaire;
	double quantite;
	String unite;
	String image;
	public Stock() {}
	
	public Stock(String reference, String designation,  int idCategorie,  int idFournisseur, double prixUnitaire, double quantite, String unite,  String image) {
		this.reference = reference;
		this.designation = designation;
		this.idCategorie = idCategorie;
		this.idFournisseur = idFournisseur;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.unite = unite;
		this.image = image;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public int getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
