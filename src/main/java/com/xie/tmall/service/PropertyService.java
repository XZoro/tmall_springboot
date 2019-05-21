package com.xie.tmall.service;

import com.xie.tmall.dao.PropertyDAO;
import com.xie.tmall.pojo.Category;
import com.xie.tmall.pojo.Property;
import com.xie.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    CategoryService categoryService;

    public void add(Property bean){
        propertyDAO.save(bean);
    }

    public void delete(int id){
        propertyDAO.deleteById(id);
    }

    public Property get(int id){
        return propertyDAO.getOne(id);
    }

    public void update(Property bean){
        propertyDAO.save(bean);
    }

    public Page4Navigator<Property> list(int cid, int start,int size,int navigatePages){
        Category category = categoryService.get(cid);

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);

        Page<Property> pageFormJPA = propertyDAO.findByCategory(category,pageable);

        return new Page4Navigator<>(pageFormJPA,navigatePages);
    }

}
