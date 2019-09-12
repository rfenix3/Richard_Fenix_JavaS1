package com.company.reccolldao.service;

import com.company.reccolldao.dao.*;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ServiceLayerTest {
    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;
    private ServiceLayer service;



    @Before
    public void setUp() throws Exception {
        setUpAlbumDaoMock();
        setUpArtistDaoMock();
        setUpLabelDaoMock();
        setUpTrackDaoMock();

        service = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);

    }

//    @After
//    public void tearDown() throws Exception {
//    }


    @Test
    public void saveFindFindAllAlbum() {
        AlbumViewModel avm = new AlbumViewModel();

        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999, 05, 15));
        avm.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setAlbumId(5);     // Need to have album id as well.
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");
        List<Track> tList = new ArrayList<>();
        tList.add(track);

        avm.setTracks(tList);
        avm = service.saveAlbum(avm);

        AlbumViewModel fromService = service.findAlbum(avm.getId());
        assertEquals(avm, fromService);

    }

    @Test
    public void updateAlbum() {

        // In ServiceLayer,  check method's parameters: updateAlbum(albumViewModel viewModel);
        // We will see the call to albumDao.updateAlbum(album);

        //Instantiate an Album;
        AlbumViewModel avm = new AlbumViewModel();


        // Since we are not actually working with a db, we do not need to
        // insert a new row.
        avm.setId(1);  // <-- artificial Album ID number;
        avm.setListPrice(new BigDecimal("15.99"));
        // plus other album properties...;
        avm.setReleaseDate(LocalDate.of(1999, 04, 17));
        avm.setTitle("Greatest Hits vol 1");

        // Instantiate an artist
        Artist artist = new Artist();
        artist.setId(45);

        avm.setArtist(artist);

        // instantiate a label.
        Label label = new Label();
        label.setId(4);

        avm.setLabel(label);

        ArgumentCaptor<Album>  albumCaptor = ArgumentCaptor.forClass((Album.class));
        doNothing().when(albumDao).updateAlbum(albumCaptor.capture());

        // Act phase. execution.
        service.updateAlbum(avm);

        // A phase. must be invoked one time only.
        verify(albumDao, times(1)).updateAlbum(albumCaptor.getValue());

        Album album = albumCaptor.getValue();

        assertEquals(1, album.getId());
        assertEquals(avm.getListPrice(), album.getListPrice());
        assertEquals(avm.getReleaseDate(), album.getReleaseDate());

    }


    @Test
    public void removeAlbum() {


    }

    @Test
    public void saveFindFindAllArtist() {
        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        artist = service.saveArtist(artist);
        Artist fromService = service.findArtist(artist.getId());
        TestCase.assertEquals(artist, fromService);

        List<Artist> aList = service.findAllArtists();
        TestCase.assertEquals(1, aList.size());
        TestCase.assertEquals(artist, aList.get(0));
    }


    @Test
    public void updateArtist() {

//        Artist UpdatedArtist = new Artist();
//
//        //artistDao = mock(ArtistDaoJdbcTemplateImpl.class);
//
//        UpdatedArtist.setInstagram("@RockStar");
//        UpdatedArtist.setName("The Greatest Of All Time");
//        UpdatedArtist.setTwitter("@TheRockStar");
//
//        when(service.findArtist(1)).thenReturn(UpdatedArtist);
//
//        verify(service, atLeastOnce()).updateArtist(UpdatedArtist);
//
//        assertEquals();

    }

    @Test
    public void removeArtist() {
        // When we remove an artist, we capture an Integer value.
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(artistDao).deleteArtist(integerCaptor.capture());

        service.removeArtist(5);

        verify(artistDao, atLeastOnce()).deleteArtist(integerCaptor.getValue());

        assertEquals(5, integerCaptor.getValue().intValue());
    }


    @Test
    public void saveFindFindAllLabel() {
        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        label = service.saveLabel(label);
        Label fromService = service.findLabel(label.getId());
        TestCase.assertEquals(label, fromService);

        List<Label> lList = service.findAllLabels();
        TestCase.assertEquals(1, lList.size());
        TestCase.assertEquals(label, lList.get(0));
    }

    @Test
    public void updateLabel() {
    }

    @Test
    public void removeLabel() {
        // Check if we are passing the argument
        // Check if we are running the method.

        // When we remove a label, we capture an Integer value.
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(labelDao).deleteLabel(integerCaptor.capture());

        service.removeLabel(10);

        verify(labelDao, atLeastOnce()).deleteLabel(integerCaptor.getValue());

        assertEquals(10, integerCaptor.getValue().intValue());

    }

    // Helper methods
    private void setUpAlbumDaoMock() {
        albumDao = mock(AlbumDaoJdbcTemplateImpl.class);
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));

        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        doReturn(album).when(albumDao).addAlbum(album2);
        doReturn(album).when(albumDao).getAlbum(1);
        doReturn(aList).when(albumDao).getAllAlbums();
    }

    private void setUpArtistDaoMock() {
        artistDao = mock(ArtistDaoJdbcTemplateImpl.class);
        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        Artist artist2 = new Artist();
        artist2.setInstagram("@RockStar");
        artist2.setName("The GOAT");
        artist2.setTwitter("@TheRockStar");

        List<Artist> aList = new ArrayList();
        aList.add(artist);

        doReturn(artist).when(artistDao).addArtist(artist2);
        doReturn(artist).when(artistDao).getArtist(45);
        doReturn(aList).when(artistDao).getAllArtists();
    }

    private void setUpLabelDaoMock() {
        labelDao = mock(LabelDaoJdbcTemplateImpl.class);
        Label label = new Label();
        label.setId(10);
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        Label label2 = new Label();
        label2.setName("Blue Note");
        label2.setWebsite("www.bluenote.com");

        List<Label> lList = new ArrayList<>();
        lList.add(label);

        doReturn(label).when(labelDao).addLabel(label2);
        doReturn(label).when(labelDao).getLabel(10);
        doReturn(lList).when(labelDao).getAllLabels();
    }

    private void setUpTrackDaoMock() {
        trackDao = mock(TrackDaoJdbcTemplateImpl.class);
        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        Track track2 = new Track();
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        List<Track> tList = new ArrayList<>();
        tList.add(track);

        doReturn(track).when(trackDao).addTrack(track2);
        doReturn(track).when(trackDao).getTrack(1);
        doReturn(tList).when(trackDao).getAllTracks();
        doReturn(tList).when(trackDao).getTracksByAlbum(1);
    }


}