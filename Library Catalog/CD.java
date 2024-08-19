public class CD extends LibraryItem{
    String artist;
    int numOfTracks;

    public CD(String title, int year, String artist, int numOfTracks){
        super(title, year);
        this.artist = artist;
        this.numOfTracks = numOfTracks;
    }

    public String getArtist() {
        return artist;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setNumOfTracks(int numOfTracks) {
        this.numOfTracks = numOfTracks;
    }

    @Override
    public String toString() {
        return "\nCD: " + super.toString() + "\nArtist: " + artist + "\nNumber of Tracks: " + numOfTracks;
    }
}
/*
artist: String
numOfTracks: int
 */
