
package models;

import java.util.Date;


public class testliste {
    
    String prenom,nom,cin,resultat,gouvernorat,date,nom_labo;
     

    public testliste(String prenom, String nom, String cin, String resultat, String date, String gouvernorat,String nom_labo) {
        this.prenom = prenom;
        this.nom = nom;
        this.cin = cin;
        this.resultat = resultat;
        this.date = date;
        this.gouvernorat=gouvernorat;
       this.nom_labo=nom_labo;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getNom_labo() {
        return nom_labo;
    }

    public void setNom_labo(String nom_labo) {
        this.nom_labo = nom_labo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
