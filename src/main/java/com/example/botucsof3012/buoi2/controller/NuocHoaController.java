package com.example.botucsof3012.buoi2.controller;

import com.example.botucsof3012.buoi2.model.NuocHoa;
import com.example.botucsof3012.buoi2.repo.NuocHoaReposistory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "NuocHoaController", value = {
        "/buoi2/hien-thi", //get
        "/buoi2/them",//post
        "/buoi2/chi-tiet",//get
        "/buoi2/view-update",//get
        "/buoi2/update",
        "/buoi2/xoa"
})
public class NuocHoaController extends HttpServlet {
    NuocHoaReposistory nHRepo = new NuocHoaReposistory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (uri.contains("chi-tiet")) {
            chiTiet(req, resp);
        }else if (uri.contains("view-update")) {
            viewUpdate(req, resp);
        }else if (uri.contains("xoa")) {
            xoaNuocHoa(req, resp);
        }
    }
    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("nuocHoa", nHRepo.chiTiet(id));
        req.getRequestDispatcher("/buoi2/viewUpdate.jsp").forward(req, resp);
    }

    private void chiTiet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("nuocHoa", nHRepo.chiTiet(id));
        req.getRequestDispatcher("/buoi2/chiTiet.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach", nHRepo.getAll());
        req.getRequestDispatcher("/buoi2/hienThi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("them")) {
            themNuocHoa(req, resp);
        }else if(uri.contains("update")) {
            updateNuocHoa(req, resp);
        }
    }
    private void updateNuocHoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Float gia = Float.valueOf(req.getParameter("gia"));

        NuocHoa nh = new NuocHoa(id, ten, soLuong, gia);
        nHRepo.update(nh);
        resp.sendRedirect("/buoi2/hien-thi");
    }
    private void themNuocHoa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        Float gia = Float.valueOf(req.getParameter("gia"));
        NuocHoa nh = new NuocHoa(null, ten, soLuong, gia);
        nHRepo.them(nh);
        resp.sendRedirect("/buoi2/hien-thi");
    }
    private void xoaNuocHoa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        nHRepo.xoa(id);
        resp.sendRedirect("/buoi2/hien-thi");
    }
}
