package cinema;
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Film> Films;
        System.out.println("1- LinkedList");
        System.out.println("2- ArrayList");
        int func = Clavier.lireInt();
        switch (func) {
        case 1 :
            System.out.println("Vous avez choisi: LinkedList");
            Films = new LinkedList<>();
            break;
        case 2 :
            System.out.println("Vous avez choisi: ArrayList");
            Films = new ArrayList<>();
            break;
        default:
            System.out.println("Instruction incorrecte, Structure par défaut: LinkedList");
            Films = new LinkedList<>();
        }
        
        //Graphique Super super stylé !!!
        System.out.println("   _____ _                            ");
        System.out.println("  / ____(_)                           ");
        System.out.println(" | |     _ _ __   ___ _ __ ___   __ _ ");
        System.out.println(" | |    | | '_ \\ / _ \\ '_ ` _ \\ / _` |");
        System.out.println(" | |____| | | | |  __/ | | | | | (_| |");
        System.out.println("  \\_____|_|_| |_|\\___|_| |_| |_|\\__,_|");
        System.out.println("                                      ");
        System.out.println("                                      ");
        System.out.println("Bienvenue dans l'application de gestion de films ! \n");

        int fonctionnalite = -1;
        while(fonctionnalite!=0) {
            System.out.println("1- Charger les films");
            System.out.println("2- Afficher les films");
            System.out.println("3- Trier les films");
            System.out.println("4- Filtrer les films");
            System.out.println("5- Rechercher des films");
            System.out.println("6- Effacer les films");
            System.out.println("0- Quitter");
            fonctionnalite = Clavier.lireInt();
            switch (fonctionnalite) {
                case 1 :
                    charger(Films);
                    break;
                case 2 :
                    lecture(Films);
                    break;
                case 3 :
                    tri(Films);
                    break;
                case 4 :
                    filtre(Films);
                    break;
                case 5 :
                    recherche(Films);
                    break;
                case 6:
                    suppression(Films);
            }
        }
    }

    	public static void charger(List<Film> Films) {
        try {
            System.out.println("Quelle fichier doit être chargé ?");
            System.out.println("1 : IMDbmoviesCUT100.tsv");
            System.out.println("2 : IMDbmoviesCUT1000.tsv");
            System.out.println("3 : IMDbmoviesCUT10000.tsv");
            System.out.println("4 : IMDbmoviesCUT40000.tsv");
            int fichier = Clavier.lireInt();
            BufferedReader TSVFile;
            switch (fichier){
                case 1:
                    TSVFile = new BufferedReader(new FileReader("IMDbmoviesCUT100.tsv"));
                    break;
                case 2:
                    TSVFile = new BufferedReader(new FileReader("IMDbmoviesCUT1000.tsv"));
                    break;
                case 3:
                    TSVFile = new BufferedReader(new FileReader("IMDbmoviesCUT10000.tsv"));
                    break;
                case 4:
                    TSVFile = new BufferedReader(new FileReader("IMDbmoviesCUT40000.tsv"));
                    break;
                default :
                    System.out.println("Valeur incorrecte, paremêtre par défaut: IMDbmoviesCUT100.tsv");
                    TSVFile = new BufferedReader(new FileReader("IMDbmoviesCUT100.tsv"));
            }
            if (TSVFile.ready()) {
                TSVFile.readLine(); // Pour eviter de prendre la ligne avec le nom des attributs
            }
            while (TSVFile.ready()) {
                Film enregistrement = new Film();
                int i_attribut = 0;
                String ligne = TSVFile.readLine();
                String[] films = ligne.split("\t");
                while (films.length > i_attribut) {
                    enregistrement.setAttribut(i_attribut, films[i_attribut]);
                    i_attribut++;
                } 
                Films.add(enregistrement);
            }
            TSVFile.close();
            System.out.println("\n Fin du chargement des films...");
        } catch (FileNotFoundException ex) {
        } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        public static void lecture(List<Film> Films) {
            for(int i=0;i<Films.size();i++){
                Films.get(i).printAttributs();
            }
        }

        public static void tri(List<Film> Films) {
        	long startTime;
        	long endTime;
        	System.out.println("1- Tri par TitleID");
            System.out.println("2- Tri par Titre");
            System.out.println("3- Tri par Année");
            System.out.println("4- Tri par Durée");
            System.out.println("5- Tri par Note (Tri Java)");
            System.out.println("6- Tri par Note (Tri séléction)");
            System.out.println("7- Tri par Note (Tri Fusion)");

            int type_tri = Clavier.lireInt();
            switch(type_tri){
                case 1:
                	startTime = System.nanoTime();
                    Collections.sort(Films, Film.compareTitleID);
                    endTime = System.nanoTime();
                    break;
                case 2:
                	startTime = System.nanoTime();
                    Collections.sort(Films, Film.compareTitre);
                    endTime = System.nanoTime();
                    break;
                case 3:
                	startTime = System.nanoTime();
                    Collections.sort(Films, Film.compareYear);
                    endTime = System.nanoTime();
                    break;
                case 4:
                	startTime = System.nanoTime();
                    Collections.sort(Films, Film.compareDuration);
                    endTime = System.nanoTime();
                    break;
                case 5:
                	startTime = System.nanoTime();
                    Collections.sort(Films, Film.compareAvgVote);
                    endTime = System.nanoTime();
                    break;
                case 6:
                	startTime = System.nanoTime();
                    tri_selec(Films);
                    endTime = System.nanoTime();
                    break;
                case 7:
                	startTime = System.nanoTime();
                    tri_fusion(Films);
                    endTime = System.nanoTime();
                    break;
                default:
                	startTime = System.nanoTime();
                	System.out.println("Valeur incorrecte, paremêtre par défaut: Tri par Titre");
                	Collections.sort(Films, Film.compareTitre);
                	endTime = System.nanoTime();
            }
            long duration = (endTime - startTime) / 1000000;
            System.out.println("\nTemps d'éxécution: " + duration + "ms");
            
        }

        public static void tri_selec(List<Film> Films) {
            for (int i = 0; i < Films.size() - 1; i++) {
                ListIterator<Film> it = Films.listIterator(i); 
                float minAvgNote = Float.parseFloat(it.next().getAttribut(14)); 
                int tp = i;  
                
                for (int j = i + 1; j < Films.size()-2; j++) {
                    ListIterator<Film> it2 = Films.listIterator(j);
                    float t = Float.parseFloat(it2.next().getAttribut(14)); 
                    if (t < minAvgNote) {
                        minAvgNote = t; 
                        tp = j; 
                    }
                }        
                if (tp != i) {
                    ListIterator<Film> it1 = Films.listIterator(i);
                    ListIterator<Film> it2 = Films.listIterator(tp); 
                   
                    Film temp = it1.next();  
                    it1.set(it2.next());     
                    it2.set(temp);          
                }
            }
        }
        
        public static void tri_fusion(List<Film> Films) {
            if (Films.size() <= 1) {
                return;
            }
            
            int mid = Films.size() / 2;
            List<Film> gauche = Films.subList(0, mid);
            List<Film> droite = Films.subList(mid+1, Films.size());

            tri_fusion(gauche);
            tri_fusion(droite);
            fusionner(Films, gauche, droite);
        }

        private static void fusionner(List<Film> Films, List<Film> gauche, List<Film> droite) {
            int i = 0;
            int j = 0;
            int k = 0;

            while (j < gauche.size() && k < droite.size()) {
                float avgNoteGauche = Float.parseFloat(gauche.get(j).getAttribut(14));
                float avgNoteDroite = Float.parseFloat(droite.get(k).getAttribut(14));

                if (avgNoteGauche <= avgNoteDroite) {
                    Films.set(i, gauche.get(j));
                    j++;
                } else {
                    Films.set(i, droite.get(k));
                    k++;
                }
                i++;
            }

            while (j < gauche.size()) {
                Films.set(i, gauche.get(j));
                j++;
                i++;
            }

            while (k < droite.size()) {
                Films.set(i, droite.get(k));
                k++;
                i++;
            }
        }
        
        public static void filtre(List<Film> Films) {
        	System.out.println("1- Filtre Manuel");
            System.out.println("2- Filtre Java");
            int filtre = Clavier.lireInt();
            switch(filtre){
                case 1:
                	System.out.println("Selon quel critère voulez vous rechercher ?");
                    System.out.println("1 : Année");
                    System.out.println("2 : Genre");
                    System.out.println("3 : Acteurs");
                    System.out.println("4 : Pays");
                    System.out.println("5 : Note minimale");
                    filtre = Clavier.lireInt();
                    filtre_man(Films, filtre);
                    break;
                default :
                    filtre_java(Films);

            }
        }
        
        public static void filtre_man(List<Film> Films, int filtre) {
        	long startTime;
        	long endTime;
        	switch(filtre) {
                case 1:
                    System.out.println("Quel année recherchez vous ?");
                    int annee = Clavier.lireInt();
                	startTime = System.nanoTime();
                    Iterator<Film> it1 = Films.iterator();
                    while (it1.hasNext()) {
                        Film film = it1.next();
                        if (Integer.parseInt(film.getAttribut(3)) != annee) {
                            it1.remove();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Quel Genre recherchez vous ?");
                    String g = Clavier.lireLigne();
                	startTime = System.nanoTime();
                    Iterator<Film> it2 = Films.iterator();
                    while (it2.hasNext()) {
                        Film film = it2.next();
                        if (!film.getAttribut(5).contains(g)) {
                            it2.remove();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Quel Acteur recherchez vous ?");
                    String act = Clavier.lireLigne();
                	startTime = System.nanoTime();
                    Iterator<Film> it3 = Films.iterator();
                    while (it3.hasNext()) {
                        Film film = it3.next();
                        if (!film.getAttribut(12).contains(act)) {
                            it3.remove();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Quel Pays recherchez vous ?");
                    String p = Clavier.lireLigne();
                	startTime = System.nanoTime();
                    Iterator<Film> it4 = Films.iterator();
                    while (it4.hasNext()) {
                        Film film = it4.next();
                        if (!film.getAttribut(7).contains(p)) {
                            it4.remove();
                        }
                    }
                    break;
                default:
                    System.out.println("Quel Note minimale/10 recherchez vous ?");
                    double n = Clavier.lireDouble();
                	startTime = System.nanoTime();
                    Iterator<Film> it5 = Films.iterator();
                    while (it5.hasNext()) {
                        Film film = it5.next();
                        if (Double.parseDouble(film.getAttribut(14)) < n) {
                            it5.remove();
                        }
                    }
            }
            endTime = System.nanoTime();
        	long duration = (endTime - startTime) / 1000000;
            System.out.println("\nTemps d'éxécution: " + duration + "ms");
        }
        
        public static void filtre_java(List<Film> Films) {
            System.out.println("Selon quel critère voulez vous filtrer la recherche ?");
			System.out.println("1 : Année");
			System.out.println("2 : Genre");
			System.out.println("3 : Acteurs");
			System.out.println("4 : Pays");
            System.out.println("5 : Note minimale");
			int filtre = Clavier.lireInt();
        	long startTime;
        	long endTime;
			switch(filtre){
            case 1:
                System.out.println("Quel année recherchez vous ?");
			    String f = Clavier.lireString();
            	startTime = System.nanoTime();
                Films.removeIf(Film -> !Film.getAttribut(3).contains(f));
                break;
            case 2:
                System.out.println("Quel Genre recherchez vous ?");
			    String g = Clavier.lireString();
            	startTime = System.nanoTime();
                Films.removeIf(Film -> !Film.getAttribut(5).contains(g));
                break;
            case 3:
                System.out.println("Quel Acteur recherchez vous ?");
			    String a = Clavier.lireString();
            	startTime = System.nanoTime();
                Films.removeIf(Film -> !Film.getAttribut(12).contains(a));
                break;
            case 4:
                System.out.println("Quel Pays recherchez vous ?");
			    String p = Clavier.lireString();
            	startTime = System.nanoTime();
                Films.removeIf(Film -> !Film.getAttribut(7).contains(p));
                break;
            default :
                System.out.println("Quel Note minimale entière sur 10 recherchez vous ?");
			    double n = Clavier.lireDouble();
            	startTime = System.nanoTime();
                Films.removeIf(Film -> !(Integer.parseInt(Film.getAttribut(14))<n));
            }
			endTime = System.nanoTime();
        	long duration = (endTime - startTime) / 1000000;
            System.out.println("\nTemps d'éxécution: " + duration + "ms");
        }
        
        public static void recherche(List<Film> Films) {
            String titre;
            long startTime;
        	long endTime;
            System.out.println("1- Recherche Linéaire");
            System.out.println("2- Recherche Dichotomique");
            int type_rech = Clavier.lireInt();
            System.out.println("Entrer le Nom du film à rechercher :");
            switch(type_rech){
                case 1:
                    titre = Clavier.lireLigne();
                    startTime = System.nanoTime();
                    rech_lineaire(Films, titre);
                	endTime = System.nanoTime();
                    break;
                default :
                    titre = Clavier.lireLigne();
                    Collections.sort(Films, Film.compareTitre); //Tri forcé pour le bon déroulement de la rech dicho
                    startTime = System.nanoTime();
                    rech_dicho(Films, titre);
                	endTime = System.nanoTime();
            }
            long duration = (endTime - startTime) / 1000000;
            System.out.println("\nTemps d'éxécution: " + duration + "ms");
        }
        
        public static void rech_lineaire(List<Film> Films, String titre) {
            boolean trouve = false;
            for (Film Film: Films) {
                if (Film.getAttribut(1).contains(titre)) {
                    Film.printAttributs();
                    trouve = true;
                    break;
                }
            }
            if (!trouve) {
                System.out.println("Le film n'a pas été trouvé");
            }
        }
        
        public static void rech_dicho(List<Film> Films, String titre) {
            int lo = 0, hi = Films.size() - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                String temp = Films.get(mid).getAttribut(1);  
                
                if (temp.compareTo(titre) == 0) {
                    Films.get(mid).printAttributs(); 
                    break; 
                } 
                else if (temp.compareTo(titre) < 0) {
                    lo = mid + 1; 
                } 
                else {
                    hi = mid - 1;
                }
            }
            if (lo > hi) {
                System.out.println("Film non trouvé.");
            }
        }
        
        public static int suppression(List<Film> Films) {
            System.out.println("Etes-vous sûr de vouloir supprimer la liste de films ? (O/N)");
            String reponse = Clavier.lireString();
            if (reponse.equalsIgnoreCase("o")) {
                System.out.println("Etes-vous VRAIMENT sûr de vouloir supprimer la liste de films ? (O/N)");
                reponse = Clavier.lireString();
                if (reponse.equalsIgnoreCase("n")) {
                    return 1;
                }
                else {
	                Iterator<Film> it2 = Films.iterator();
	 			    while (it2.hasNext()) {
	 			        Film film = it2.next();
	 			        it2.remove();
	 			    }
	            }
            }
            else {
            	System.out.println("La suppression de la liste des films a été annulée");
            }
            return 0;
        }

}