package com.uca.capas.controller;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    CategoriaService categoriaService;

    @Autowired
    LibroService libroService;

    @GetMapping("/index")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/nuevaCategoria")
    public ModelAndView nuevaCategoria() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("categoria", new Categoria());
        mav.setViewName("categoriaForm");

        return mav;
    }

    @RequestMapping("/nuevoLibro")
    public ModelAndView nuevoLibro(@ModelAttribute Libro libro) {
        ModelAndView mav = new ModelAndView();
        List<Categoria> categoriaList = null;

        try {
            categoriaList = categoriaService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("libro", libro);
        mav.addObject("categoriaList", categoriaList);
        mav.setViewName("libroForm");
        return mav;
    }

    @RequestMapping("/libros")
    public ModelAndView mostrarLibros() {
        ModelAndView mav = new ModelAndView();
        List<Libro> libros = null;

        try {
            libros = libroService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("libros", libros);
        mav.setViewName("listaLibros");
        return mav;
    }

    @PostMapping("/guardarLibro")
    public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult br) throws ParseException {
        ModelAndView mav = new ModelAndView();
        List<Categoria> categoriaList = categoriaService.findAll();
        String mensaje = "Libro guardado con exito";

        if (br.hasErrors()) {
            mav.addObject("categoriaList", categoriaList);
            mav.setViewName("libroForm");
        } else {
            try {
                libro.setFechaIngreso(new Date());
                libroService.save(libro);
                mav.addObject("mensaje", mensaje);
                mav.setViewName("index");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mav;
    }

    @PostMapping("/guardarCategoria")
    public ModelAndView guardarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult br) throws ParseException {
        ModelAndView mav = new ModelAndView();
        String mensaje = "Categoria guardada con exito";
        if (br.hasErrors()) {
            mav.setViewName("categoriaForm");
        } else {
            try {
                categoriaService.save(categoria);
                mav.addObject("mensaje", mensaje);
                mav.setViewName("index");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mav;
    }
}
