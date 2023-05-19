import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Enumération pour le régime alimentaire des animaux
enum RegimeAlimentaire {
    HERBIVORE,
    CARNIVORE,
    OMNIVORE
}

// Enumération pour la taille des enclos
enum TailleEnclos {
    PETIT,
    MOYEN,
    GRAND
}

// Enumération pour les espèces d'animaux
enum EspeceAnimal {
    TIGRE,
    LION,
    JAGUAR,
    PANTHERE,
    LEOPARD,
    BISON,
    GUEPARD,
    LYNX,
    COUGAR,
    CARACAL,
    CHIEN,
    CHAT,
    COCHON_DINDE,
    HAMSTER,
    LAPIN,
    PERROQUET,
    CANARI,
    POISSON_ROUGE,
    TORTUE,
    PONEY
}

// Classe Animal
class Animal {
    private String nom;
    private Employe employeResponsable;
    private EspeceAnimal espece;
    private TailleEnclos tailleEnclos;
    private RegimeAlimentaire regimeAlimentaire;

    // Constructeur de la classe Animal
    public Animal(String nom, EspeceAnimal espece) {
        this.nom = nom;
        this.espece = espece;
        this.employeResponsable = null;
        this.tailleEnclos = null;
        this.regimeAlimentaire = null;
    }

    // Méthode pour obtenir le nom de l'animal
    public String getNom() {
        return nom;
    }

    // Méthode pour définir le nom de l'animal
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir l'employé responsable de l'animal
    public Employe getEmployeResponsable() {
        return employeResponsable;
    }

    // Méthode pour définir l'employé responsable de l'animal
    public void setEmployeResponsable(Employe employeResponsable) {
        this.employeResponsable = employeResponsable;
    }

    // Méthode pour obtenir l'espèce de l'animal
    public EspeceAnimal getEspece() {
        return espece;
    }

    // Méthode pour définir l'espèce de l'animal
    public void setEspece(EspeceAnimal espece) {
        this.espece = espece;
    }

    // Méthode pour obtenir la taille de l'enclos de l'animal
    public TailleEnclos getTailleEnclos() {
        return tailleEnclos;
    }

    // Méthode pour définir la taille de l'enclos de l'animal
    public void setTailleEnclos(TailleEnclos tailleEnclos) {
        this.tailleEnclos = tailleEnclos;
    }

    // Méthode pour obtenir le régime alimentaire de l'animal
    public RegimeAlimentaire getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    // Méthode pour définir le régime alimentaire de l'animal
    public void setRegimeAlimentaire(RegimeAlimentaire regimeAlimentaire) {
        this.regimeAlimentaire = regimeAlimentaire;
    }
}

// Classe Employe
class Employe {
    private int badge;
    private String nom;

    // Constructeur de la classe Employe
    public Employe(int badge, String nom) {
        this.badge = badge;
        this.nom = nom;
    }

    // Méthode pour obtenir le badge de l'employé
    public int getBadge() {
        return badge;
    }

    // Méthode pour définir le badge de l'employé
    public void setBadge(int badge) {
        this.badge = badge;
    }

    // Méthode pour obtenir le nom de l'employé
    public String getNom() {
        return nom;
    }

    // Méthode pour définir le nom de l'employé
    public void setNom(String nom) {
        this.nom = nom;
    }
}

// Classe Inventaire
class Inventaire {
    private String aliment;

    // Constructeur de la classe Inventaire
    public Inventaire(String aliment) {
        this.aliment = aliment;
    }

    // Méthode pour obtenir l'aliment
    public String getAliment() {
        return aliment;
    }

    // Méthode pour définir l'aliment
    public void setAliment(String aliment) {
        this.aliment = aliment;
    }
}

// Classe utilitaire pour la validation
class ValidationUtil {
    // Méthode pour valider si une chaîne peut être convertie en entier
    public static boolean isValidInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

// Classe utilitaire pour les menus
class MenuUtil {
    // Méthode pour afficher le menu principal
    public static void afficherMenuPrincipal() {
        System.out.println("1. Ajouter un animal");
        System.out.println("2. Afficher tous les animaux de chaque enclos");
        System.out.println("3. Afficher les animaux pré-établis");
        System.out.println("4. Ajouter un employé");
        System.out.println("5. Afficher les animaux dont un employé est responsable");
        System.out.println("6. Ajouter des aliments dans l'inventaire");
        System.out.println("7. Assigner un employé à un animal");
        System.out.println("8. Modifier un animal");
        System.out.println("9. Enregistrer les animaux dans un fichier");
        System.out.println("10. Charger les animaux depuis un fichier");
        System.out.println("11. Afficher les données chargées pour animaux");
        System.out.println("12. Charger les employés depuis un fichier");
        System.out.println("13. Afficher les données chargées pour employés");
        System.out.println("14. Charger les aliments depuis un fichier");
        System.out.println("15. Afficher les données chargées pour aliments");
        System.out.println("16. Quitter");
    }

    // Méthode pour afficher le menu de modification d'un animal
    public static void afficherMenuModifierAnimal() {
        System.out.println("1. Modifier le nom");
        System.out.println("2. Modifier l'espèce");
        System.out.println("3. Modifier la taille de l'enclos");
        System.out.println("4. Modifier le régime alimentaire");
    }

    // Méthode pour afficher le menu des types d'enclos
    public static void afficherMenuTypesEnclos() {
        System.out.println("1. Petit");
        System.out.println("2. Moyen");
        System.out.println("3. Grand");
    }

    // Méthode pour afficher le menu du régime alimentaire
    public static void afficherMenuRegimeAlimentaire() {
        System.out.println("1. Herbivore");
        System.out.println("2. Carnivore");
        System.out.println("3. Omnivore");
    }
}

// Classe principale du zoo
public class ZooDeGaspe {
    private List<Animal> animaux;
    private List<Employe> employes;
    private List<Inventaire> inventaire;
    private List<String> donneesChargees;
    private List<String> employesChargees;
    private List<String> alimentsChargees;

    // Constructeur de la classe ZooDeGaspe
    public ZooDeGaspe() {
        animaux = new ArrayList<>();
        employes = new ArrayList<>();
        inventaire = new ArrayList<>();
        donneesChargees = new ArrayList<>();
        employesChargees = new ArrayList<>();
        alimentsChargees = new ArrayList<>();
    }

    // Méthode pour ajouter un animal au zoo
    public void ajouterAnimal(String nom, TailleEnclos tailleEnclos, RegimeAlimentaire regimeAlimentaire) {
        EspeceAnimal espece = obtenirEspeceAnimal();
        if (espece != null) {
            Animal animal = new Animal(nom, espece);
            animal.setTailleEnclos(tailleEnclos);
            animal.setRegimeAlimentaire(regimeAlimentaire);
            animaux.add(animal);
            System.out.println("L'animal " + nom + " a été ajouté.");
        } else {
            System.out.println("Erreur : Espèce invalide.");
        }
    }

    // Méthode privée pour obtenir l'espèce de l'animal à partir de l'entrée utilisateur
    private EspeceAnimal obtenirEspeceAnimal() {
        Scanner scanner = new Scanner(System.in);
        MenuUtil.afficherMenuTypesEnclos();
        System.out.print("Entrez votre choix : ");
        int choixEspece = scanner.nextInt();
        scanner.nextLine();
        if (choixEspece >= 1 && choixEspece <= EspeceAnimal.values().length) {
            return EspeceAnimal.values()[choixEspece - 1];
        } else {
            return null;
        }
    }

    // Méthode pour afficher tous les animaux du zoo
    public void afficherAnimaux() {
        for (Animal animal : animaux) {
            System.out.println("Nom : " + animal.getNom());
            System.out.println("Espèce : " + animal.getEspece());
            System.out.println("Taille de l'enclos : " + animal.getTailleEnclos());
            System.out.println("Régime alimentaire : " + animal.getRegimeAlimentaire());
            System.out.println("-----------------------------");
        }
    }

    // Méthode pour ajouter un employé au zoo
    public void ajouterEmploye(int badge, String nom) {
        Employe employe = new Employe(badge, nom);
        employes.add(employe);
        System.out.println("L'employé " + nom + " a été ajouté.");
    }

    // Méthode pour afficher tous les employés du zoo
    public void afficherEmployes() {
        for (Employe employe : employes) {
            System.out.println("Badge : " + employe.getBadge());
            System.out.println("Nom : " + employe.getNom());
            System.out.println("-----------------------------");
        }
    }

    // Méthode pour ajouter un aliment à l'inventaire du zoo
    public void ajouterAliment(String aliment) {
        Inventaire inventaire = new Inventaire(aliment);
        this.inventaire.add(inventaire);
        System.out.println("L'aliment " + aliment + " a été ajouté à l'inventaire.");
    }

    // Méthode pour afficher l'inventaire du zoo
    public void afficherInventaire() {
        for (Inventaire inventaire : this.inventaire) {
            System.out.println("Aliment : " + inventaire.getAliment());
            System.out.println("-----------------------------");
        }
    }

    // Méthode pour assigner un employé à un animal
    public void assignerEmployeAnimal(String animalNom, int employeBadge) {
        Animal animal = trouverAnimalParNom(animalNom);
        Employe employe = trouverEmployeParBadge(employeBadge);

        if (animal != null && employe != null) {
            animal.setEmployeResponsable(employe);
            System.out.println("L'employé " + employe.getNom() + " a été assigné à l'animal " + animal.getNom() + ".");
        } else {
            System.out.println("Erreur : Animal ou employé introuvable.");
        }
    }

    // Méthode privée pour trouver un animal par son nom
    private Animal trouverAnimalParNom(String nom) {
        for (Animal animal : animaux) {
            if (animal.getNom().equalsIgnoreCase(nom)) {
                return animal;
            }
        }
        return null;
    }

    // Méthode privée pour trouver un employé par son badge
    private Employe trouverEmployeParBadge(int badge) {
        for (Employe employe : employes) {
            if (employe.getBadge() == badge) {
                return employe;
            }
        }
        return null;
    }

    // Méthode pour modifier les attributs d'un animal
    public void modifierAnimal(String nom) {
        Animal animal = trouverAnimalParNom(nom);
        if (animal != null) {
            Scanner scanner = new Scanner(System.in);
            MenuUtil.afficherMenuModifierAnimal();
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nouveau nom : ");
                    String nouveauNom = scanner.nextLine();
                    animal.setNom(nouveauNom);
                    System.out.println("Le nom de l'animal a été modifié avec succès.");
                    break;
                case 2:
                    EspeceAnimal nouvelleEspece = obtenirEspeceAnimal();
                    if (nouvelleEspece != null) {
                        animal.setEspece(nouvelleEspece);
                        System.out.println("L'espèce de l'animal a été modifiée avec succès.");
                    } else {
                        System.out.println("Erreur : Espèce invalide.");
                    }
                    break;
                case 3:
                    MenuUtil.afficherMenuTypesEnclos();
                    System.out.print("Entrez votre choix : ");
                    int choixTailleEnclos = scanner.nextInt();
                    scanner.nextLine();
                    if (choixTailleEnclos >= 1 && choixTailleEnclos <= TailleEnclos.values().length) {
                        animal.setTailleEnclos(TailleEnclos.values()[choixTailleEnclos - 1]);
                        System.out.println("La taille de l'enclos de l'animal a été modifiée avec succès.");
                    } else {
                        System.out.println("Erreur : Choix de taille d'enclos invalide.");
                    }
                    break;
                case 4:
                    MenuUtil.afficherMenuRegimeAlimentaire();
                    System.out.print("Entrez votre choix : ");
                    int choixRegimeAlimentaire = scanner.nextInt();
                    scanner.nextLine();
                    if (choixRegimeAlimentaire >= 1 && choixRegimeAlimentaire <= RegimeAlimentaire.values().length) {
                        animal.setRegimeAlimentaire(RegimeAlimentaire.values()[choixRegimeAlimentaire - 1]);
                        System.out.println("Le régime alimentaire de l'animal a été modifié avec succès.");
                    } else {
                        System.out.println("Erreur : Choix de régime alimentaire invalide.");
                    }
                    break;
                default:
                    System.out.println("Erreur : Choix invalide.");
            }
        } else {
            System.out.println("Erreur : Animal introuvable.");
        }
    }

    // Méthode pour enregistrer les animaux dans un fichier
    public void enregistrerAnimauxDansFichier(String nomFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
            for (Animal animal : animaux) {
                writer.write(animal.getNom() + "," + animal.getEspece() + "," + animal.getTailleEnclos() + "," + animal.getRegimeAlimentaire());
                writer.newLine();
            }
            System.out.println("Les animaux ont été enregistrés dans le fichier avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement des animaux dans le fichier.");
        }
    }

    // Méthode pour charger les animaux depuis un fichier
    public void chargerAnimauxDepuisFichier(String nomFichier) {
        File file = new File(nomFichier);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 4) {
                    String nom = data[0];
                    EspeceAnimal espece = EspeceAnimal.valueOf(data[1]);
                    TailleEnclos tailleEnclos = TailleEnclos.valueOf(data[2]);
                    RegimeAlimentaire regimeAlimentaire = RegimeAlimentaire.valueOf(data[3]);
                    Animal animal = new Animal(nom, espece);
                    animal.setTailleEnclos(tailleEnclos);
                    animal.setRegimeAlimentaire(regimeAlimentaire);
                    animaux.add(animal);
                    donneesChargees.add(line);
                }
            }
            System.out.println("Les animaux ont été chargés depuis le fichier avec succès.");
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier spécifié n'a pas été trouvé.");
        }
    }

    // Méthode pour afficher les données chargées pour les animaux
    public void afficherDonneesChargeesAnimaux() {
        for (String donnee : donneesChargees) {
            System.out.println(donnee);
        }
    }

    // Méthode pour charger les employés depuis un fichier
    public void chargerEmployesDepuisFichier(String nomFichier) {
        File file = new File(nomFichier);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 2 && ValidationUtil.isValidInt(data[0])) {
                    int badge = Integer.parseInt(data[0]);
                    String nom = data[1];
                    Employe employe = new Employe(badge, nom);
                    employes.add(employe);
                    employesChargees.add(line);
                }
            }
            System.out.println("Les employés ont été chargés depuis le fichier avec succès.");
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier spécifié n'a pas été trouvé.");
        }
    }

    // Méthode pour afficher les données chargées pour les employés
    public void afficherDonneesChargeesEmployes() {
        for (String donnee : employesChargees) {
            System.out.println(donnee);
        }
    }

    // Méthode pour charger les aliments depuis un fichier
    public void chargerAlimentsDepuisFichier(String nomFichier) {
        File file = new File(nomFichier);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 1) {
                    String aliment = data[0];
                    Inventaire inventaire = new Inventaire(aliment);
                    this.inventaire.add(inventaire);
                    alimentsChargees.add(line);
                }
            }
            System.out.println("Les aliments ont été chargés depuis le fichier avec succès.");
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier spécifié n'a pas été trouvé.");
        }
    }

    // Méthode pour afficher les données chargées pour les aliments
    public void afficherDonneesChargeesAliments() {
        for (String donnee : alimentsChargees) {
            System.out.println(donnee);
        }
    }

    // Méthode principale du programme
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooDeGaspe zoo = new ZooDeGaspe();

        while (true) {
            MenuUtil.afficherMenuPrincipal();
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom de l'animal : ");
                    String nomAnimal = scanner.nextLine();
                    MenuUtil.afficherMenuTypesEnclos();
                    System.out.print("Entrez la taille de l'enclos : ");
                    int choixTailleEnclos = scanner.nextInt();
                    scanner.nextLine();
                    MenuUtil.afficherMenuRegimeAlimentaire();
                    System.out.print("Entrez le régime alimentaire : ");
                    int choixRegimeAlimentaire = scanner.nextInt();
                    scanner.nextLine();
                    TailleEnclos tailleEnclos = TailleEnclos.values()[choixTailleEnclos - 1];
                    RegimeAlimentaire regimeAlimentaire = RegimeAlimentaire.values()[choixRegimeAlimentaire - 1];
                    zoo.ajouterAnimal(nomAnimal, tailleEnclos, regimeAlimentaire);
                    break;
                case 2:
                    zoo.afficherAnimaux();
                    break;
                case 3:
                    // Afficher les animaux pré-établis
                    break;
                case 4:
                    System.out.print("Entrez le badge de l'employé : ");
                    int badgeEmploye = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le nom de l'employé : ");
                    String nomEmploye = scanner.nextLine();
                    zoo.ajouterEmploye(badgeEmploye, nomEmploye);
                    break;
                case 5:
                    zoo.afficherEmployes();
                    break;
                case 6:
                    System.out.print("Entrez le nom de l'aliment : ");
                    String aliment = scanner.nextLine();
                    zoo.ajouterAliment(aliment);
                    break;
                case 7:
                    System.out.print("Entrez le nom de l'animal : ");
                    String nomAnimalAssignation = scanner.nextLine();
                    System.out.print("Entrez le badge de l'employé : ");
                    int badgeEmployeAssignation = scanner.nextInt();
                    scanner.nextLine();
                    zoo.assignerEmployeAnimal(nomAnimalAssignation, badgeEmployeAssignation);
                    break;
                case 8:
                    System.out.print("Entrez le nom de l'animal à modifier : ");
                    String nomAnimalModification = scanner.nextLine();
                    zoo.modifierAnimal(nomAnimalModification);
                    break;
                case 9:
                    System.out.print("Entrez le nom du fichier : ");
                    String nomFichierEnregistrement = scanner.nextLine();
                    zoo.enregistrerAnimauxDansFichier(nomFichierEnregistrement);
                    break;
                case 10:
                    System.out.print("Entrez le nom du fichier : ");
                    String nomFichierChargementAnimaux = scanner.nextLine();
                    zoo.chargerAnimauxDepuisFichier(nomFichierChargementAnimaux);
                    break;
                case 11:
                    zoo.afficherDonneesChargeesAnimaux();
                    break;
                case 12:
                    System.out.print("Entrez le nom du fichier : ");
                    String nomFichierChargementEmployes = scanner.nextLine();
                    zoo.chargerEmployesDepuisFichier(nomFichierChargementEmployes);
                    break;
                case 13:
                    zoo.afficherDonneesChargeesEmployes();
                    break;
                case 14:
                    System.out.print("Entrez le nom du fichier : ");
                    String nomFichierChargementAliments = scanner.nextLine();
                    zoo.chargerAlimentsDepuisFichier(nomFichierChargementAliments);
                    break;
                case 15:
                    zoo.afficherDonneesChargeesAliments();
                    break;
                case 16:
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Erreur : Choix invalide.");
            }
        }
    }
}
