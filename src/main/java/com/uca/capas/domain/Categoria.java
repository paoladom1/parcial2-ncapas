package com.uca.capas.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(schema = "public", name = "cat_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_categoria")
    private Integer codigoCategoria;

    @Column(name = "s_categoria")
    @NotEmpty(message = "El campo nombre categoria no puede estar vacio")
    @Size(max = 50, message = "El campo sobrepasa la cantidad de 50 caracteres")
    private String nombreCategoria;

    public Categoria() {
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
