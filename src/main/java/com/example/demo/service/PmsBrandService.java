package com.example.demo.service;


import java.util.List;

import com.example.demo.mbg.model.PmsBrand;

public  interface PmsBrandService {

    List<PmsBrand> listAll();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listAll(int pageNum, int pageSize);
}