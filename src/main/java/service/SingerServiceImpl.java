package service;

import com.google.common.collect.Lists;
import entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.SingerRepository;

import java.util.List;

@Service("jpaSingerService")
@Transactional
public class SingerServiceImpl implements SingerService {

    private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

    private SingerRepository singerRepository;

    @Autowired
    public void setSingerRepository(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return singerRepository.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public void delete(Singer singer) {
        singerRepository.delete(singer);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public Long countAll() {
        return singerRepository.countAllSingers();
    }
}













