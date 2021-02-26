package com.example.demo.service.impl;


import com.example.demo.mbg.mapper.PmsBrandMapper;
import com.example.demo.mbg.model.PmsBrand;
import com.example.demo.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper brandMapper;

    public void create(PmsBrand entity){
        brandMapper.insert(entity);
    }

    @Override
    public List<PmsBrand> listAll(){
        return brandMapper.select(SelectDSLCompleter.allRows());
    }

    @Override
    public  int createBrand(PmsBrand brand){
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand){
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id){
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return brandMapper.select(SelectDSLCompleter.allRows());
    }

}
