package com.example.botucsof3012.buoi2.repo;

import com.example.botucsof3012.buoi2.model.NuocHoa;
import com.example.botucsof3012.buoi2.utils.HibernateConfig;
import jakarta.servlet.http.HttpServlet;
import org.hibernate.Session;

import java.util.List;

public class NuocHoaReposistory  {
    private Session session = null;
    public NuocHoaReposistory(){
        session= HibernateConfig.getFACTORY().openSession();
    }
    public List<NuocHoa> getAll() {
        return session.createQuery("FROM NuocHoa").list();
    }
    public NuocHoa chiTiet(Integer id) {
        return session.find(NuocHoa.class, id);
    }
    public void them(NuocHoa nuocHoa) {
        try {
            session.getTransaction().begin();
            session.save(nuocHoa);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
