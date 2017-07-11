package onlineRadioDatabase.exceptions;

import onlineRadioDatabase.exceptions.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PlayList playList = new PlayList();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
           String[] songInfo = reader.readLine().split(";");
           String artistName = songInfo[0];
           String songName = songInfo[1];
           String[] time = songInfo[2].split(":");
           String minutes = time[0];
           String seconds = time[1];

           try {
               Song song = new Song(artistName, songName, minutes, seconds);
               playList.addedSongs(song);
               System.out.println("Song added.");
           } catch (InvalidSongException ise) {
               System.out.println(ise.getMessage());
           }
        }

        System.out.println(String.format("Songs added: %d", playList.getSongsNumber()));
        System.out.println(playList.getPlaylistLength());
    }
}
