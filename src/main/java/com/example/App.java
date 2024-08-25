package com.example;

import org.deepsymmetry.cratedigger.Database;
import org.deepsymmetry.cratedigger.RekordboxPdb;

import java.io.File;

public class App {
    public static void main(String[] args) {
        try {
            File pdbFile = new File("/Volumes/MJO-WHITE/PIONEER/rekordbox/export.pdb");  // Replace with actual path to your Rekordbox PDB file
            Database database = new Database(pdbFile);

            for (RekordboxPdb.PlaylistRow playlist : database.getPlaylists()) {
                System.out.println("Playlist: " + database.getText(playlist.name()));
                for (int i = 0; i < playlist.tracks().size(); i++) {
                    RekordboxPdb.TrackRow track = playlist.tracks().get(i);
                    String title = database.getText(track.title());
                    String artist = database.getText(track.artist());
                    String filePath = database.getText(track.filePath());
                    System.out.println("Track " + (i + 1) + ": " + title + " by " + artist + " [" + filePath + "]");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}