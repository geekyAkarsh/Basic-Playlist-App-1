public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Gloria","Sam Smith");
        album1.addSong(new Song("Unholy","Sam Smith", 2));
        album1.addSong(new Song("Perfect","Sam Smith", 3));
        album1.addSong(new Song("Gloria","Sam Smith", 2));

        Album album2 = new Album("Honestly, Nevermind", "Drake");
        album2.addSong(new Song("Her Loss","Drake", 1));
        album2.addSong(new Song("Views","Drake", 1));
        album2.addSong(new Song("Take Care","Drake",2));

        Playlist myPlaylist = new Playlist("myPlaylist");

        myPlaylist.addSongFromAlbum(album1, 0); //unholy
        myPlaylist.addSongFromAlbum(album1,1); //perfect
        myPlaylist.addSongFromAlbum(album1,2); //gloria
        myPlaylist.addSongFromAlbum(album2, 0); //her loss
        myPlaylist.addSongFromAlbum(album2, 1); //views
        myPlaylist.addSongFromAlbum(album2, 2); //take care
        System.out.println(myPlaylist.playlistSize());

        System.out.println(myPlaylist.playCurrent()); //unholy
        System.out.println(myPlaylist.playPrevious()); // nothing
        System.out.println(myPlaylist.playNext()); //perfect
        System.out.println(myPlaylist.playNext()); //gloria
        System.out.println(myPlaylist.playPrevious()); //perfect
        System.out.println(myPlaylist.playNext()); //gloria
        System.out.println(myPlaylist.playNext()); //her loss
        System.out.println(myPlaylist.playNext()); //views
        System.out.println(myPlaylist.playNext()); //take care
        System.out.println(myPlaylist.playNext()); //end of playlist
        System.out.println(myPlaylist.playCurrent()); //take care
        System.out.println(myPlaylist.playPrevious()); // views
    }
}