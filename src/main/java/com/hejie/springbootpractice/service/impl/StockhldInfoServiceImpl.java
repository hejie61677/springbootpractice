package com.hejie.springbootpractice.service.impl;

import com.hejie.springbootpractice.dao.StockhldInfoDao;
import com.hejie.springbootpractice.entity.StockhldInfoEntity;
import com.hejie.springbootpractice.service.StockhldInfoService;
import com.hejie.springbootpractice.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Program: springbootpractice
 * @Description:
 * @Author: hejie
 * @Create: 2020-05-25 16:13
 */
@Service
@CacheConfig(cacheNames = "stockhld")
public class StockhldInfoServiceImpl implements StockhldInfoService {

    @Autowired
    StockhldInfoDao stockhldInfoDao;

    @Override
    @Cacheable(key = "'stockhld' + #p0.offset + '-' + #p0.pageSize")
    public Page4Navigator<StockhldInfoEntity> selList(Pageable pageable) {
        Page<StockhldInfoEntity> pageJpa = stockhldInfoDao.findAll(pageable);
        Page4Navigator<StockhldInfoEntity> page = new Page4Navigator<>(pageJpa, 10);
        return page;
    }

    @Override
    @CacheEvict(allEntries = true)
    public void insStock(StockhldInfoEntity stockhldInfoEntity) {
        stockhldInfoDao.save(stockhldInfoEntity);
    }

    @Override
    @CacheEvict(allEntries = true)
    public void delStock(String client_no) {
        stockhldInfoDao.deleteById(client_no);
    }

    @Override
    public void updStock(StockhldInfoEntity stockhldInfoEntity) {

    }

    @Override
    @Cacheable(key = "'stockhld' + #p0")
    public StockhldInfoEntity selStock(String client_no) {
        return null;
    }
}
