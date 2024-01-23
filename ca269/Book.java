/**
 * Book.java - Assignment 01
 * @author Shane Whelan
 */


enum BookMedium {
    PhysicalBook,
    EBook,
    AudioBook
}

enum BookGenre {
    Fiction,
    NonFiction
}

enum BookRating {
    Rating1(1),
    Rating2(2),
    Rating3(3),
    Rating4(4),
    Rating5(5);

    private int value;

    BookRating(int value){

            this.value = value;

    }

    protected int getValue(){
        return value;
    }
}

class Book {
    private String title ;
    private String author;
    private BookGenre genre;
    private int PublishedDate;
    private int ReadDate;
    private BookMedium Medium;
    private BookRating rating;

    // getters
    protected String getTitle(){
        return this.title;
    }
    protected String getAuthor(){
        return this.author;
    }
    protected BookGenre getGenre(){
        return this.genre;
    }
    protected int getPublishedDate(){
        return this.PublishedDate;
    }
    protected int getReadDate(){
        return this.ReadDate;
    }
    protected BookMedium getMedium(){
        return this.Medium;
    }
    protected BookRating getRating(){
        return this.rating;
    }

    // constructors
    protected Book(String title, String author, BookGenre genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    protected Book(String title, String author, BookGenre genre, int PublishedDate ){
        this.title = title;
        this.author = author;
        this.PublishedDate = PublishedDate;
        this.genre = genre;
    }
    protected Book(String title, String author,BookGenre genre, int PublishedDate,int ReadDate, BookMedium Medium, BookRating rating){
        this.title = title;
        this.author = author;
        this.ReadDate = ReadDate;
        this.Medium = Medium;
        this.PublishedDate = PublishedDate;
        this.genre = genre;
        this.rating = rating;
    }

    /**
     * toString implementation
     * Depends on available information
     * For title, an author, and a genre - Title by Author
     * If PublishedDate date is present - Title by Author (Year of PublishedDate)
     * If read date, read medium, and rating is present -
     * Title by Author (Year of PublishedDate) - read in Year of Reading, rated rating/5
     */
    public String toString(){
        if (this.getPublishedDate() == 0){
            return this.getTitle() + " by " + this.getAuthor() ;
        }
        else if (this.getReadDate() == 0){
            return this.getTitle() + " by " + this.getAuthor() + " (" + this.getPublishedDate() + ")";
        }
        else{
            return this.getTitle() + " by " + this.getAuthor() + " (" + this.getPublishedDate() + ") - read in " + this.getReadDate() + ", rated " + this.getRating().getValue() + "/5";
        }
    }


    public static void main(String[] args) {
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);
        Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        Book b3 = new Book("Perdido Street Station", "China Mieville",
            BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);

        System.out.println(b1.getTitle());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getGenre());
        System.out.println(b2.getPublishedDate());
        System.out.println(b3.getReadDate());
        System.out.println(b3.getMedium());
        System.out.println(b3.getRating());
    }
}