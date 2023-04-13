import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Playlist {

    private String title;
    private List<Song> songs;
    private ListIterator<Song> itr;
    private boolean isNext;

    public Playlist(String title) {
        this.title = title;
        songs = new ArrayList<>();
        itr = songs.listIterator();
    }

    public int playlistSize(){
        return this.songs.size();
    }

    public String addSongFromAlbum(Album album,String songTitle){

        Optional<Song> optionalSongInPlaylist = findSong(songTitle);
        if(optionalSongInPlaylist.isPresent()){
            return "Song already present in the Playlist";
        }

        Optional<Song> optionalSongInAlbum = album.findSong(songTitle);
        if(optionalSongInAlbum.isPresent()){
            songs.add(optionalSongInAlbum.get());
            itr = songs.listIterator();
            return "Song added to Playlist !!!";
        }else{
            return "Song not found in Album :(";
        }
    }

    private Optional<Song> findSong(String songTitle) {

        for(Song currSong : songs){
            if(songTitle.equals(currSong.getTitle()))
                return Optional.of(currSong);
        }

        return Optional.empty();
    }

    public String addSongFromAlbum(Album album,int trackNo){

        Optional<Song> optionalSongInAlbum = album.findSong(trackNo);
        if(optionalSongInAlbum.isEmpty())
            return "Song not found in Album :(";

        Optional<Song> optionalSongInPlaylist = findSong(optionalSongInAlbum.get().getTitle());
        if(optionalSongInPlaylist.isPresent()){
            return "Song already present in the Playlist";
        }

            songs.add(optionalSongInAlbum.get());
            itr = songs.listIterator();
            return "Song added to Playlist !!!";
    }

    public Optional<Song> findSong(int trackNo){

        if(trackNo>=0 && trackNo<songs.size())
            return Optional.of(songs.get(trackNo));

        return Optional.empty();
    }

    public String playCurrent(){

        if(isNext){
            isNext = false;
            return "Current song is " + itr.previous();
        }else{
            isNext = true;
            return "Current song is " + itr.next();
        }
    }

    public String playNext(){

        if(!isNext){

            itr.next();
            isNext = true;
        }

        if(itr.hasNext()){
            isNext = true;
            return "The next song is " + itr.next();
        }

        return "You have reached the end of Playlist !!!";
    }

    public String playPrevious(){

        if(isNext){
            itr.previous();
            isNext = false;
        }

        if(itr.hasPrevious()){
            isNext = false;
            return "The previous song is " + itr.previous();
        }

        return "You have reached the start of the Playlist !!!";
    }
}
