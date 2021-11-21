import configuration.Configuration_Oracle;
import entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import service.SingerService;

import static service.CommonService.*;
import static service.CommonService.logSinger;

public class Executor {

    private static Logger logger = LoggerFactory.getLogger(Executor.class);

    public static void main(String[] args) throws InterruptedException {

        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration_Oracle.class);

        SingerService singerService = ctx.getBean(SingerService.class);

        // -Dorg.slf4j.simpleLogger.defaultLogLevel=DEBUG

        System.out.println("-- SingerService findAll --");
        listSingers(singerService.findAll());
        Thread.sleep(1000);

        System.out.println("-- SingerService save --");
        Singer newSinger = singerService.save(createSinger());
        logSinger(newSinger);
        updateSinger(newSinger);
        logSinger(newSinger);
        Singer updatedSinger = singerService.save(newSinger);
        logSinger(updatedSinger);
        Singer singerForDelete = singerService.findById(updatedSinger.getId());
        logSinger(singerForDelete);
        singerService.delete(singerForDelete);
        Thread.sleep(1000);

        System.out.println("-- SingerService countAll --");
        logger.info(singerService.countAll().toString());
    }
}