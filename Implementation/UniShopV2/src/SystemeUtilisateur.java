import java.util.ArrayList;

public class SystemeUtilisateur extends Systeme {
	public ArrayList<Acheteur> listeAcheteurs=new ArrayList<Acheteur>();
	public ArrayList<Revendeur> listeRevendeurs=new ArrayList<Revendeur>();

	public void connexion(Menu menu) {
		System.out.println("\n");
		System.out.println("-----------------------------------------------");
		System.out.println("\n");
		System.out.println("1. Connexion en tant qu'acheteur");
		System.out.println("2. Connexion en tant que revendeur");
		System.out.print("\nVeuillez choisir une option : ");
		int choix = menu.prompt();
		switch (choix) {
		case 1:
				connexionAcheteur(menu);
		
		case 2:
				connexionRevendeur(menu);
		default:
			System.out.println("Choix invalide veuillez reessayer:");
			connexion(menu);
		}
	}

	public void connexionAcheteur(Menu menu) {
		System.out.println("Pseudo : ");
		String pseudo = menu.promptS();
		System.out.println("Mot de passe : ");
		String mdp = menu.promptS();
		for (Acheteur acheteur : listeAcheteurs) {
			if (acheteur.getPseudo().equals(pseudo) && acheteur.getMotDePasse().equals(mdp)) {
				menu.setUtilisateurConnecte(acheteur);
				menu.afficherPageAcheteur();
				return;
			} 
		} 
		System.out.println("Cet utilisateur n'existe pas veuillez reessayer");
		connexion(menu);
		
	}

	public void connexionRevendeur(Menu menu) {
		System.out.println("Nom : ");
		String nom = menu.promptS();
		System.out.println("Mot de passe : ");
		String mdp =menu.promptS();
		for (Revendeur revendeur : listeRevendeurs) {
			if (revendeur.getNom().equals(nom) && revendeur.getMotDePasse().equals(mdp)) {
				menu.setUtilisateurConnecte(revendeur);
				menu.afficherPageRevendeur();
				return;
			}
		} 
		System.out.println("Cet utilisateur n'existe pas veuillez reessayer");
		connexion(menu);
	}

	public void inscription(Menu menu) {
		System.out.println("1. Inscription en tant qu'acheteur");
		System.out.println("2. Inscription en tant que revendeur");
		int choix = menu.prompt();
		switch (choix) {
		case 1:
			Acheteur acheteur = inscrireAcheteur(menu);
			menu.systemeUtilisateur.listeAcheteurs.add(acheteur);
			menu.setUtilisateurConnecte(acheteur);
			menu.afficherPageAcheteur();
			break;
		case 2:
			Revendeur revendeur = inscrireRevendeur(menu);
			menu.systemeUtilisateur.listeRevendeurs.add(revendeur);
			menu.setUtilisateurConnecte(revendeur);
			menu.afficherPageRevendeur();
			break;
		default:
			System.out.println("Choix invalide veuillez reessayer:");
			inscription(menu);
			break;
		}
	}

	public Acheteur inscrireAcheteur(Menu menu) {
		System.out.println("Pseudo : ");
		String pseudo = menu.promptS();
		System.out.println("Nom : ");
		String prenom = menu.promptS();
		System.out.println("Prenom : ");
		String nom =menu.promptS();
		System.out.println("Email : ");
		String email = menu.promptS();
		System.out.println("Mot de passe : ");
		String mdp =menu.promptS();
		System.out.println("Adresse : ");
		String adresse = menu.promptS();
		System.out.println("Telephone : ");
		String telephone = menu.promptS();
		Acheteur acheteurnew=new Acheteur(pseudo, nom, prenom, email, mdp, adresse, telephone);
		listeAcheteurs.add(acheteurnew);
		return acheteurnew;

	}

	public Revendeur inscrireRevendeur(Menu menu) {
		System.out.println("Nom : ");
		String nom = menu.promptS();
		System.out.println("Email : ");
		String email = menu.promptS();
		System.out.println("Mot de passe : ");
		String mdp = menu.promptS();
		System.out.println("Adresse : ");
		String adresse = menu.promptS();
		System.out.println("Telephone : ");
		String telephone = menu.promptS();
		Revendeur revendeurnew=new Revendeur(nom, email, mdp, adresse, telephone);
		listeRevendeurs.add(revendeurnew);
		return revendeurnew;}

	public Revendeur[] rechercherRevendeur(String aMotcle, FiltresRevendeur[] aFiltres) {
		throw new UnsupportedOperationException();
	}

	public void mettreJourQuantitees(Commande aCom) {
		throw new UnsupportedOperationException();
	}
}