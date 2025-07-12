package com.example.botucsof3012.buoi3.repo;

import com.example.botucsof3012.buoi3.model.Phong;
import com.example.botucsof3012.buoi3.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class PhongRepo {
    private Session session = null;

    public PhongRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<Phong> getAllPhong() {
        return session.createQuery("FROM Phong").list();
    }

    public Phong getPhong(Integer id) {
        return session.find(Phong.class, id);
    }

    public void themPhong(Phong phong) {
        try {
            session.getTransaction().begin();
            session.save(phong);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void suaPhong(Phong phong) {
        try {
            session.getTransaction().begin();
            session.merge(phong);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoaPhong(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getPhong(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
