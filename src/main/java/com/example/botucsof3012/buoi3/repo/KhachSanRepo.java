package com.example.botucsof3012.buoi3.repo;

import com.example.botucsof3012.buoi2.utils.HibernateConfig;
import com.example.botucsof3012.buoi3.model.KhachSan;
import org.hibernate.Session;

import java.util.List;

public class KhachSanRepo {
    private Session session = null;

    public KhachSanRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    // Load combobox
    public List<KhachSan> getAllKhachSan() {
        return session.createQuery("FROM KhachSan").list();
    }

    // Them, sua thong tin Phong
    public KhachSan getKhachSan(Integer id) {
        return session.find(KhachSan.class, id);
    }
}
