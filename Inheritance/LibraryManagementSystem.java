package Inheritance;

class Book{
    String name;
    int PublicatioYear;

    Book(String name,int PublicatioYear){
        this.name=name;
        this.PublicatioYear=PublicatioYear;
    }
    void displayinfo(){
        System.out.println("Book Name: " + name);
        System.out.println("Publication Year: " + PublicatioYear);
    }
}
class Author extends Book{
    String authorname;
    String bio;
    Author(String name, int PublicatioYear, String authorname, String bio) {
        super(name, PublicatioYear);
        this.authorname = authorname;
        this.bio = bio;
    }
    void displayinfo() {
        super.displayinfo();
        System.out.println("Author Name: " + authorname);
        System.out.println("Author Bio: " + bio);
    }   
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Author author = new Author("Effective Java", 2018, "Joshua Bloch", "Joshua Bloch is a software engineer and a technology author.");
        author.displayinfo();
        
    }
}   