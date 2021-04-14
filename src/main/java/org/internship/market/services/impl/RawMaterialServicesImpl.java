package org.internship.market.services.impl;

import org.internship.market.database.dao.RawMaterialDAO;
import org.internship.market.database.entity.RawMaterialEntity;
import org.internship.market.services.RawMaterialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class RawMaterialServicesImpl implements RawMaterialServices {

    @Autowired
    RawMaterialDAO rawMaterialDAO;

    @Override
    public List<RawMaterialEntity> listOfMaterials() {
        System.out.println("listOfMaterials");
        return rawMaterialDAO.getAllMaterial();
    }
}
