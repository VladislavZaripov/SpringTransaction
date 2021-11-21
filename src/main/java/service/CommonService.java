package service;

import entity.Album;
import entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CommonService {

    private static Logger logger = LoggerFactory.getLogger(CommonService.class);

    public static void listSingers(List<Singer> singers) {
        for (Singer singer : singers)
            logger.info(singer.toString());
    }

    public static void listAlbums(List<Album> albums) {
        for (Album album : albums)
            logger.info(album.toString());
    }

    public static void logSinger(Singer singer) {
        logger.info(singer.toString());
    }

    public static Singer createSinger() {
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date((new GregorianCalendar(1940, 8, 16)).getTime().getTime()));
        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new Date((new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
        singer.addAlbum(album);
        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new Date((new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
        singer.addAlbum(album);
        return singer;
    }

    public static void updateSinger(Singer singer) {
        singer.setFirstName("AA");
        singer.setLastName("Queen");
        singer.getAlbums().removeIf(album -> album.getTitle().equals("My Kind of Blues"));
    }
}