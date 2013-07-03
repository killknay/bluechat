package fr.jondav.bluechat;

/**
 * @author David et Jonathan
 * 
 * Cette classe correspond à un corps de message
 * de type texte. Implements la classe DJ_Corps.
 * Contient les informations suivante :
 *  - Content-type : text
 *  - Valeur : Du texte String
 */
public class DJ_Corps_Texte implements DJ_Corps{
	private String texte;        //< Correspond au texte contenue
	private String contentType;  //< Correspond au type des données
	
	/**
	 * Constructeur par défaut de la classe. 
	 * Initialise le contentType avec la bonne valeur.
	 */
	public DJ_Corps_Texte() {
		contentType = "texte";
		texte = "";
	}
	
	/**
	 * Permet de créer un objet de cette classe depuis une trame.
	 * Remplis tous les champs de l'objet.
	 * 
	 * @param trame La trame (complete) a partir de laquelle vous souhaitez charger l'objet.
	 * @return L'objet créer si tout s'est bien passé, null sinon.
	 */
	public DJ_Corps_Texte chargerDepuisTrame (String trame) {
		DJ_Corps_Texte c = new DJ_Corps_Texte();
		// TODO A compléter
		return c;
	}
	
	/**
	 * Permet de définir le texte que vous souhaitez mettre dans le message.
	 * 
	 * @param texte Le texte que vous souhaitez mettre dans le message.
	 */
	public void setTexte(String texte) {
		if (texte != null)
			this.texte = texte;
	}
	
	/**
	 * Permet de renvoyer l'objet sous forme de texte
	 * suivant le protocole définie sur Google Drive.
	 * Ici ne renvoie que la chaîne de caractère.
	 * 
	 * @return La chaine de caractère correspondant au corps de la requête
	 */
	@Override
    public String toProtocol() {
	    return texte;
    }

	/**
	 * Permet de savoir si deux objet de la classe DJ_Corps
	 * correspondent au même objet.
	 * 
	 * @param c L'objet avec lequel on souhaite comparer l'objet.
	 * @return True si les objets sont les mêmes, false sinon.
	 */
	@Override
    public boolean equals(DJ_Corps c) {
		if (contentType == c.getContentType() && toProtocol() == c.toProtocol())
			return true;
		else
			return false;
    }

	/**
	 * Permet de récupère le type du corps.
	 * Cette information est nécessaire dans le header de requête bluetooth.
	 * Ici renvoie toujours "texte";
	 * 
	 * @return Le type du corps, à inscrire dans l'en-tête de requête.
	 */
	@Override
    public String getContentType() {
	    return contentType;
    }
	
	/**
	 * Permet à l'objet de s'afficher dans une chaine de 
	 * caractère.
	 * 
	 * @return Une chaine représentant l'objet.
	 */
	public String toString() {
		return "Type : " + contentType + " -> " + texte;
	}
}
