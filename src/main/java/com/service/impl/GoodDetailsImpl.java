package com.service.impl;


import com.entity.Good;

import com.entity.GoodDetails;
import com.service.GoodDetailsService;
import org.springframework.stereotype.Service;

@Service
public class GoodDetailsImpl implements GoodDetailsService {


    @Override
    public int addGoodDetails(GoodDetails goodDetails) {
        return 0;
    }

    @Override
    public int deleteGoodDetailsById(String id) {
        return 0;
    }

    @Override
    public int updateGoodDetails(GoodDetails supply) {
        return 0;
    }

    @Override
    public GoodDetails queryGoodDetailsById(String id) {
        return null;
    }
}
