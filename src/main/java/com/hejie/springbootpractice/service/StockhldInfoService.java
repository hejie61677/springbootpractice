package com.hejie.springbootpractice.service;

import com.hejie.springbootpractice.entity.StockhldInfoEntity;
import com.hejie.springbootpractice.util.Page4Navigator;
import org.springframework.data.domain.Pageable;

public interface StockhldInfoService {

    Page4Navigator<StockhldInfoEntity> selList(Pageable pageable);

    void insStock(StockhldInfoEntity stockhldInfoEntity);

    void delStock(String client_no);

    void updStock(StockhldInfoEntity stockhldInfoEntity);

    StockhldInfoEntity selStock(String client_no);
}
