package cinema;
import java.util.Collections;
import java.util.Comparator;

public class Film {
    private String imdb_title_id;
    private String title;
    private String original_title;
    private String year;
    private String date_published;
    private String genre;
    private String duration;
    private String country;
    private String language;
    private String director;
    private String writer;
    private String production_company;
    private String actors;
    private String description;
    private String avg_vote;
    private String votes;
    private String budget;
    private String usa_gross_income;
    private String worlwide_gross_income;
    private String metascore;
    private String reviews_from_users;
    private String reviews_from_critics;

    public void setAttribut(int index, String valeur) {
        switch (index) {
            case 0 : imdb_title_id = valeur;
            case 1 : title = valeur;
            case 2 : original_title = valeur;
            case 3 : year = valeur;
            case 4 : date_published = valeur;
            case 5 : genre = valeur;
            case 6 : duration = valeur;
            case 7 : country = valeur;
            case 8 : language = valeur;
            case 9 : director = valeur;
            case 10 : writer = valeur;
            case 11 : production_company = valeur;
            case 12 : actors = valeur;
            case 13 : description = valeur;
            case 14 : avg_vote = valeur;
            case 15 : votes = valeur;
            case 16 : budget = valeur;
            case 17 : usa_gross_income = valeur;
            case 18 : worlwide_gross_income = valeur;
            case 19 : metascore = valeur;
            case 20 : reviews_from_users = valeur;
            case 21 : reviews_from_critics = valeur;
        }
    }

    public String getAttribut(int index) {
        switch (index) {
            case 0: return imdb_title_id;
            case 1: return title;
            case 2: return original_title;
            case 3: return year;
            case 4: return date_published;
            case 5: return genre;
            case 6: return duration;
            case 7: return country;
            case 8: return language;
            case 9: return director;
            case 10: return writer;
            case 11: return production_company;
            case 12: return actors;
            case 13: return description;
            case 14: return avg_vote;
            case 15: return votes;
            case 16: return budget;
            case 17: return usa_gross_income;
            case 18: return worlwide_gross_income;
            case 19: return metascore;
            case 20: return reviews_from_users;
            case 21: return reviews_from_critics;
            default: return null;
        }
    }

    public void printAttributs() {
    	System.out.print(String.format(
    			"Titre_id: %s Titre: %-70s Original Titre: %-60s Année: %-4s Date de Publication: %-10s Genre: %-35s Durée: %-10s " +
			        "Pays: %-50s Langue: %-40s Director: %-70s Writer: %-50s Production Company: %-40s, Actors: %-300s Description: %-250s " +
			        "Average Vote: %-10s Votes: %-10s Budget: %-15s USA Gross Income: %-15s Worldwide Gross Income: %-15s Metascore: %-10s " +
			        "Reviews from Users: %-15s Reviews from Critics: %-15s\t",
    	        imdb_title_id, title, original_title, year, date_published, genre, duration, country, language, 
    	        director, writer, production_company, actors, description, avg_vote, votes, budget, usa_gross_income, 
    	        worlwide_gross_income, metascore, reviews_from_users, reviews_from_critics
    	    ));
        System.out.println("");

    }


    static public Comparator<Film> compareTitleID = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.imdb_title_id.compareTo(f2.imdb_title_id);
        }
    };

    static public Comparator<Film> compareTitre = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.title.compareTo(f2.title);
        }
    };

    static public Comparator<Film> compareYear = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.year.compareTo(f2.year);
        }
    };

    static public Comparator<Film> compareDatePublished = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.date_published.compareTo(f2.date_published);
        }
    };

    static public Comparator<Film> compareGenre = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.genre.compareTo(f2.genre);
        }
    };

    static public Comparator<Film> compareDuration = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.duration.compareTo(f2.duration);
        }
    };

    static public Comparator<Film> compareCountry = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.country.compareTo(f2.country);
        }
    };

    static public Comparator<Film> compareLanguage = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.language.compareTo(f2.language);
        }
    };

    static public Comparator<Film> compareDirector = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.director.compareTo(f2.director);
        }
    };

    static public Comparator<Film> compareWriter = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.writer.compareTo(f2.writer);
        }
    };

    static public Comparator<Film> compareProductionCompany = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.production_company.compareTo(f2.production_company);
        }
    };

    static public Comparator<Film> compareActors = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.actors.compareTo(f2.actors);
        }
    };

    static public Comparator<Film> compareDescription = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.description.compareTo(f2.description);
        }
    };

    static public Comparator<Film> compareAvgVote = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.avg_vote.compareTo(f2.avg_vote);
        }
    };

    static public Comparator<Film> compareVotes = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.votes.compareTo(f2.votes);
        }
    };

    static public Comparator<Film> compareBudget = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.budget.compareTo(f2.budget);
        }
    };

    static public Comparator<Film> compareUSAGrossIncome = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.usa_gross_income.compareTo(f2.usa_gross_income);
        }
    };

    static public Comparator<Film> compareWorlwideGrossIncome = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.worlwide_gross_income.compareTo(f2.worlwide_gross_income);
        }
    };

    static public Comparator<Film> compareMetascore = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.metascore.compareTo(f2.metascore);
        }
    };

    static public Comparator<Film> compareReviewsFromUsers = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.reviews_from_users.compareTo(f2.reviews_from_users);
        }
    };

    static public Comparator<Film> compareReviewsFromCritics = new Comparator<Film>() {
        public int compare(Film f1, Film f2) {
            return f1.reviews_from_critics.compareTo(f2.reviews_from_critics);
        }
    };
}
