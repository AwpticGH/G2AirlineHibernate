/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Admins;

/**
 *
 * @author WahyuAu
 */
public class AdminsDao extends BaseDao {
    
    
    HibernateUtil hibernateUtil = new HibernateUtil();
    
    public List<Admins> getAll() {
        List<Object> results = super.getAll(Admins.class);
        List<Admins> list = new ArrayList<>();
        
        results.forEach((result) -> {
            list.add(Admins.class.cast(result));
        });
        
        return list;
    }
    
    public Admins getById() {
        return Admins.class.cast(super.getById(Admins.class, 1));
    }
    
    public Admins getByUsernameAndPassword(String username, String password) {
        Admins admin = null;
        
        Session session = hibernateUtil.openSession(Admins.class);
        Transaction trans = session.beginTransaction();
        
        String hql = "FROM Admins WHERE username = :username AND password = :password";
        Query query = session.createQuery(hql);
        query.setString("username", username);
        query.setString("password", password);
        
        admin = (Admins)query.uniqueResult();
        session.get(Admins.class, admin.getId());
        
        trans.commit();
        session.close();
        
        return admin;
    }
    
    public static void main(String[] args) {
        AdminsDao adminsDao = new AdminsDao();
        
        List<Admins> admins = adminsDao.getAll();
        
        System.out.println(admins.toString());
        System.out.println(adminsDao.getByUsernameAndPassword("superadmin", "superadmin123"));
    }
    
}
