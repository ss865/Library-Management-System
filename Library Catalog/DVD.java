public class DVD extends LibraryItem{
    String director;
    int duration;

    public DVD(String title, int year, String director, int duration){
        super(title, year);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "\nDVD: " + super.toString() + "\nDirector: " + director + "\nDuration: " + duration + " minutes";
    }
}
/*
director: String
duration: int (in minutes)
 */
