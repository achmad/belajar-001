/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hanafi.achmad.app001.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author achmad
 */
@RestController
public class HalloController {
    
    @RequestMapping("/halo")
    public Map<String,Object> halo(){
        Map<String,Object> hasil = new HashMap<>();
        hasil.put("waktu", new Date());
        return hasil;
    }
}
