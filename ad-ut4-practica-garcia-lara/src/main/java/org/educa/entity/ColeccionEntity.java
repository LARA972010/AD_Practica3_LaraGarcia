package org.educa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coleccion")
public class ColeccionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Column(name="fec_cre")
    private Timestamp fecCre;
    @Column(name="fec_mod")
    private Timestamp fecMod;
    @Column(name="usu_cre")
    private String usuCre;
    @Column(name="usu_mod")
    private String usuMod;
}
