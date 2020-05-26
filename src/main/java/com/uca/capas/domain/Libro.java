package com.uca.capas.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_libro")
    private Integer codigoLibro;

    @Column(name = "s_titulo")
    @Size(max = 500, message = "El campo sobrepasa la cantidad de 500 caracteres")
    @NotEmpty(message = "El campo no puede estar vacio")
    private String nombre;

    @Column(name = "s_autor")
    @Size(max = 150, message = "El campo sobrepasa la cantidad de 150 caracteres")
    @NotEmpty(message = "El campo no puede estar vacio")
    private String autor;

    @JoinColumn(name = "c_categoria")
    @OneToOne
    private Categoria categoria;

    @Column(name = "f_ingreso")
    private Date fechaIngreso;

    @Column(name = "s_isbn")
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 10, message = "El campo sobrepasa la cantidad de 10 caracteres")
    private String isbn;

    @Column(name = "b_estado")
    private Boolean estado;

    public Libro() {
    }

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
