import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {

    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist, List<Song> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public String addSong(Song song){

        if(findSong(song)){
            return "Song already exists in the album";
        }

        songs.add(song);
        return "Song successfully added in the album";
    }

    public String addSong(String title){

        Optional<Song> optSong = findSong(title);
        if(optSong.isPresent()){
            return "Song already exists in the album";
        }

        songs.add(optSong.get());
        return "Song successfully added in the album";
    }

    public Optional<Song> findSong(String title){

        for(Song currSong : songs){
            if(title.equals(currSong.getTitle()))
                return Optional.of(currSong);
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(int trackNo){

        if(trackNo>=0 && trackNo<songs.size())
            return Optional.of(songs.get(trackNo));

        return Optional.empty();
    }

    public Optional<Song> findSong(String title,String artist){

        for(Song currSong : songs){
            if(title.equals(currSong.getTitle()) && artist.equals(currSong.getArtist()))
                return Optional.of(currSong);
        }
        return Optional.empty();
    }

    public boolean findSong(Song song) {

        for(Song currSong : songs){
            if(currSong.getTitle().equals(song.getTitle()) &&
                    currSong.getArtist().equals(song.getArtist())) return true;
        }
        return false;
    }
}
