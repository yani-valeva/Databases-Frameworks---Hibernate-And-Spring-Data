package onlineRadioDatabase.exceptions;

import onlineRadioDatabase.exceptions.exceptions.*;

public class Song {
    private String artist;
    private String songName;
    private Integer minutes;
    private Integer seconds;

    public Song(String artist, String songName, String minutes, String seconds) {
        this.setArtist(artist);
        this.setSongName(songName);
        this.checkNumber(minutes, seconds);
        this.setMinutes(Integer.parseInt(minutes));
        this.setSeconds(Integer.parseInt(seconds));
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist.length() < 3 || artist.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }

        this.songName = songName;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }

        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }

        this.seconds = seconds;
    }

    private void checkNumber(String minutes, String seconds) {
        try {
            int currentMinutes = Integer.parseInt(minutes);
            int currentSeconds = Integer.parseInt(seconds);
        } catch (NumberFormatException nfe) {
            throw new InvalidSongLengthException("Invalid song length.");
        }
    }
}
