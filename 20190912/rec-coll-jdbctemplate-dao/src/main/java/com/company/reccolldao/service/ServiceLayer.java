package com.company.reccolldao.service;

import com.company.reccolldao.dao.AlbumDao;
import com.company.reccolldao.dao.ArtistDao;
import com.company.reccolldao.dao.LabelDao;
import com.company.reccolldao.dao.TrackDao;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;

    @Autowired
    public ServiceLayer(AlbumDao albumDao, ArtistDao artistDao, LabelDao labelDao, TrackDao trackDao) {
        this.albumDao = albumDao;
        this.artistDao = artistDao;
        this.labelDao = labelDao;
        this.trackDao = trackDao;
    }

    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel) {

        // Persist Album
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());
        a = albumDao.addAlbum(a);
        viewModel.setId(a.getId());

        // Add Album Id to Tracks and Persist Tracks
        List<Track> tracks = viewModel.getTracks();

        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    trackDao.addTrack(t);
                });

        tracks = trackDao.getTracksByAlbum(viewModel.getId());
        viewModel.setTracks(tracks);

        return viewModel;
    }

    public AlbumViewModel findAlbum(int id) {

        // Get the album object first
        Album album = albumDao.getAlbum(id);

        // return using the helper method
        return buildAlbumViewModel(album);

    }

    @Transactional
    public void updateAlbum(AlbumViewModel viewModel) {

        // Update the album information
        Album album = new Album();
        album.setId(viewModel.getId());
        album.setArtistId(viewModel.getArtist().getId());
        album.setLabelId(viewModel.getLabel().getId());
        album.setListPrice(viewModel.getListPrice());
        album.setTitle(viewModel.getTitle());
        album.setReleaseDate(viewModel.getReleaseDate());

        albumDao.updateAlbum(album);

        // We don't know if any track have been removed so delete all associated tracks
        // and then associate the tracks in the viewModel with the album
        List<Track> trackList = trackDao.getTracksByAlbum(album.getId());
        trackList.stream()
                .forEach(track -> trackDao.deleteTrack(track.getId()));

        List<Track> tracks = viewModel.getTracks();
        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    t = trackDao.addTrack(t);
                });
    }

    public List<AlbumViewModel> findAllAlbums() {

        List<Album> albumList = albumDao.getAllAlbums();

        List<AlbumViewModel> avmList = new ArrayList<>();

        for (Album album : albumList) {
            AlbumViewModel avm = buildAlbumViewModel(album);
            avmList.add(avm);
        }

        return avmList;
    }


    @Transactional
    public void removeAlbum(int id) {

        // Remove all associated tracks first
        List<Track> trackList = trackDao.getTracksByAlbum(id);

        trackList.stream()
                .forEach(track -> trackDao.deleteTrack(track.getId()));

        // Remove album
        albumDao.deleteAlbum(id);

    }

//
    // Artist API
    //

    public Artist saveArtist(Artist artist) {

        return artistDao.addArtist(artist);
    }

    public Artist findArtist(int id) {

        return artistDao.getArtist(id);
    }

    public List<Artist> findAllArtists() {

        return artistDao.getAllArtists();
    }

    public void updateArtist(Artist artist) {

        artistDao.updateArtist(artist);
    }

    public void removeArtist(int id) {

        artistDao.deleteArtist(id);
    }

    //
    // Label API
    //

    public Label saveLabel(Label label) {

        return labelDao.addLabel(label);
    }

    public Label findLabel(int id) {

        return labelDao.getLabel(id);
    }

    public List<Label> findAllLabels() {

        return labelDao.getAllLabels();
    }

    public void updateLabel(Label label) {

        labelDao.updateLabel(label);
    }

    public void removeLabel(int id) {

        labelDao.deleteLabel(id);
    }

    // Helper Methods
    private AlbumViewModel buildAlbumViewModel(Album album) {

        // Get the associated artist
        Artist artist = artistDao.getArtist(album.getArtistId());

        // Get the associated label
        Label label = labelDao.getLabel(album.getLabelId());

        // Get the tracks associated with the album
        List<Track> trackList = trackDao.getTracksByAlbum(album.getId());

        // Assemble the AlbumViewModel
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getId());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getReleaseDate());
        avm.setListPrice(album.getListPrice());
        avm.setArtist(artist);
        avm.setLabel(label);
        avm.setTracks(trackList);

        // Return the AlbumViewModel
        return avm;

    }


}
