public class LibraryItem {
    String title;
    int year;

    public LibraryItem(String title, int year){
        this.title = title;
        this.year = year;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "\nTitle: " + title + "\nYear: " + year;
    }


}

/*
Attributes:
title: String
year: int
Methods :
getters/setters()
toString()
 */
