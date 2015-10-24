/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hanafi.achmad.app001.controller;

import com.hanafi.achmad.app001.dao.PesertaDao;
import com.hanafi.achmad.app001.entity.Peserta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author achmad
 */
@RestController
public class PesertaController {
    
    @Autowired
    private PesertaDao pd;
    
    @RequestMapping(value="/peserta",method = RequestMethod.GET)
    public Page<Peserta> cariPeserta(Pageable page){
        return pd.findAll(page);
    }
    
    @RequestMapping(value="/peserta" , method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertPeserta(@RequestBody Peserta p){
        pd.save(p);
    }
    
    @RequestMapping(value="/peserta/{id}" , method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)    
    public void updatePeserta(@PathVariable("id") String id,@RequestBody Peserta p){
        p.setId(id);
        pd.save(p);
    }
    
    @RequestMapping(value="/peserta/{id}" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)    
    public Peserta cariPesertaById(@PathVariable("id") String id){
        return pd.findOne(id);
    }
    
    
}
