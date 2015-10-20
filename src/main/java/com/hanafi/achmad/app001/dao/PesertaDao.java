/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hanafi.achmad.app001.dao;

import com.hanafi.achmad.app001.entity.Peserta;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author achmad
 */
public interface PesertaDao extends PagingAndSortingRepository<Peserta, String>{
    
}

