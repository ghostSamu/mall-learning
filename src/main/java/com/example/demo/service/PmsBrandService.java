package com.example.demo.service;


import com.example.demo.mbg.model.PmsBrand;

import java.util.List;

public  interface PmsBrandService {

    List<PmsBrand> listAll();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listAll(int pageNum, int pageSize);
}