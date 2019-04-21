package com.service.impl;


import com.entity.SupplyDetails;
import com.service.SupplyDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SupplyDetailsImpl implements SupplyDetailsService {

    @Override
    public int addSupplyDetails(SupplyDetails supply) {
        return 0;
    }

    @Override
    public int deleteSupplyDetailsById(String id) {
        return 0;
    }

    @Override
    public int updateSupplyDetails(SupplyDetails supply) {
        return 0;
    }

    @Override
    public SupplyDetails querySupplyDetailsById(String id) {
        return null;
    }
}
