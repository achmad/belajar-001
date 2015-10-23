/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hanafi.achmad.app001.dao;

import com.hanafi.achmad.app001.ApplicationBelajar001Application;
import com.hanafi.achmad.app001.entity.Peserta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.persistence.SqlResultSetMappings;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author achmad
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationBelajar001Application.class)
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = "/data/peserta.sql"
)
public class PesertaDaoTest {
    
    @Autowired
    private PesertaDao pd;
    
    @Autowired
    private DataSource ds;
       
    @Test
    public void testInsert() throws SQLException{
        Peserta p = new Peserta();
        p.setNama("achmad");
        p.setEmail("moeksin@gmail.com");
        p.setTanggalLahir(new Date());
        pd.save(p);
        String sql = "select count(*) as jumlah "
                + "from peserta "
                + "where email='moeksin@gmail.com'";
        Connection c = ds.getConnection();
        ResultSet rs = c.createStatement().executeQuery(sql);
        Assert.assertTrue(rs.next());
        Long jumlahRow = rs.getLong("jumlah");
        Assert.assertEquals(1L, jumlahRow.longValue());
        
        c.close();
    }
    
    @Test
    public void testHitung(){
        Long jumlah = pd.count();
        Assert.assertEquals(3L, jumlah.longValue());
    }
    
    @Test
    public void testCariById(){
        Peserta p = pd.findOne("aa1");
        Assert.assertNotNull(p);
        Assert.assertEquals("peserta test 001", p.getNama());
        Assert.assertEquals("peserta.test001@gmail.com", p.getEmail());
        
        Peserta px = pd.findOne("aa1x");
        Assert.assertNull(px);
    }
    
    @After
    public void hapusData() throws SQLException{
        String sql = "delete from peserta where email ='moeksin@gmail.com' ";
        try(Connection c = ds.getConnection()){
            c.createStatement().executeUpdate(sql);
        }
    }
    
}
