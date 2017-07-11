package onlineRadioDatabase.exceptions;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song> playlist;

    public PlayList() {
        this.playlist = new ArrayList<>();
    }

    public void addedSongs(Song song) {
        playlist.add(song);
    }

    public int getSongsNumber() {
        return this.playlist.size();
    }

    public String getPlaylistLength() {
        int minutes = 0;
        int seconds = 0;

        for (Song song : playlist) {
            minutes += song.getMinutes();
            seconds += song.getSeconds();
        }

        int totalTime = (minutes * 60) + seconds;
        int hours = totalTime / 3600;
        minutes = (totalTime % 3600) / 60;
        seconds = (totalTime % 3600) % 60;

        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }
}
