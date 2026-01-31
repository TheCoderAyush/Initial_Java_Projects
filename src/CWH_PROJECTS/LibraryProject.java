package CWH_PROJECTS;

class Library{
      int [] storeAvalaibleBook = new int [10];
      int [] storeIssueBook = new int [0];
      int issuedBook;
      int returnBook;
      int NoOfBooksAdded;


    public void setNoOfBooksAdded(int NoOfBooksAdded){
        this.NoOfBooksAdded=NoOfBooksAdded;
    }
      public void setReturnBook(int returnBook){
          this.returnBook=returnBook;
      }
      public void setIssuedBook(int number){
         issuedBook=number;
      }


    public void issueBook(){
        System.out.println("Book is issued...");
        System.out.println();
        int store2 = storeIssueBook.length+issuedBook;
        System.out.println("Number of issued Books:- "+store2);
        System.out.println();
        System.out.println("Total Book Avalaible:- "+(storeAvalaibleBook.length-issuedBook));
    }

    public void returnBook(){
        System.out.println("Returing Books.....");
        System.out.println();
        System.out.println("Number of Books returned:- "+returnBook);
        System.out.println();
        int store5=storeAvalaibleBook.length+returnBook;
        System.out.println("Total Book Avalaible:- "+(store5));
    }

    public void showAvalaibleBook(){

        int total=(storeAvalaibleBook.length+returnBook+NoOfBooksAdded)-issuedBook;
        System.out.println("Total Books Avalaible:- "+total);


    }
    public void addBooks(){
        System.out.println("Books Added:- "+NoOfBooksAdded);
        System.out.println();
        int storeAdd = storeAvalaibleBook.length+NoOfBooksAdded;
        System.out.println("Total No. of books:- "+storeAdd);
    }

}
public class LibraryProject {
    public static void main(String[] args) {
    Library book = new Library();
    book.setIssuedBook(4);
    book.setIssuedBook(4);
    book.issueBook();


    }
}
