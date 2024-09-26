
import java.util.ArrayList;

public class AssignJava2 {
    private String name;
    private int age;
    

    //Getter and Setter for name
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //Getter and Setter for age
    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

public static void main(String[] args) {
    ArrayList<String> borrowedBooks = new ArrayList<>();

    //ADD to the list
    borrowedBooks.add(
        "Abu"
    );
    borrowedBooks.add(
        "Abuyah"
    );
    borrowedBooks.add(
        "Abuyah yang teliti"
    );
    System.err.println("Initial List: " + borrowedBooks);

    //Remove
    borrowedBooks.remove("Abu");
    System.out.println("The borrowed book: " + borrowedBooks.remove(1));
    System.out.println("Book left: " + borrowedBooks);



}

}
