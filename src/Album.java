import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    Album()
    {

    }
    Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Song findSong(String title)
    {
        for(Song s : this.songs)
        {
            if(s.getTitle().equals(title)) return s;
        }
        return null;
    }
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null)
        {
            this.songs.add(new Song(title, duration));
            System.out.println("Song " + title + " is successfully added to " + this.name + " album.");
            return true;
        }
        System.out.println("song name " + title + " is already in album name " + this.name);
        return false;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> Playlist)
    {
        int index  = trackNumber - 1;
        if(index > 0 && index <= this.songs.size())
        {
            Playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have the song with tracknumber " + trackNumber);
        return false;
    }
    public boolean addToPlaylist(String title, LinkedList<Song> Playlist)
    {
        for(Song s:this.songs)
        {
            if(s.getTitle().equals(title))
            {
                Playlist.add(s);
                return true;
            }
        }
        System.out.println("this album does not have the song with title " + title);
        return false;
    }
}
