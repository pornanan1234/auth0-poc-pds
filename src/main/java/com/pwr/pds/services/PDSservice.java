package com.pwr.pds.services;


import java.util.ArrayList;
import java.util.List;
import com.pwr.pds.Model.PDS;
import com.pwr.pds.Model.PDSrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PDSservice {

    @Autowired
    PDSrepository pDSrepository;

    public List getAllPDSs() {
        List PDSs = new ArrayList();
        pDSrepository.findAll().forEach(pds -> PDSs.add(pds));
        return PDSs;
    }

    public PDS getPDSById(int id) {
        return pDSrepository.findById(id).get();
    }



    public void saveOrUpdate(PDS pds) {
        pDSrepository.save(pds);
    }

    public void delete(int id) {
        pDSrepository.deleteById(id);
    }
}
