package com.xie.tmall.service;

import com.xie.tmall.dao.PropertyValueDAO;
import com.xie.tmall.pojo.Product;
import com.xie.tmall.pojo.Property;
import com.xie.tmall.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService {

    @Autowired
    PropertyValueDAO propertyValueDAO;
    @Autowired
    PropertyService propertyService;

    public void update(PropertyValue bean){
        propertyValueDAO.save(bean);
    }

    public void init(Product product){
        List<Property> properties = propertyService.listByCategory(product.getCategory());
        for(Property property: properties){
            PropertyValue propertyValue = getByPropertyAndProduct(product,property);
            if (null == propertyValue){
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }
    }

    private PropertyValue getByPropertyAndProduct(Product product, Property property) {
        return propertyValueDAO.getByPropertyAndProduct(property,product);
    }

    public List<PropertyValue> list(Product product){
        return propertyValueDAO.findByProductOrderByIdDesc(product);
    }
}
