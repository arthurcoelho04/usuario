package com.arthur.usuario.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "endereco")
@Builder

public class Endereco implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Long numero;
    @Column(name = "complemento", length = 100)
    private String complemento;
    @Column(name = "cidade", length = 150)
    private String cidade;
    @Column(name = "estado", length = 2)
    private String estado;
    @Column(name = "cep", length = 9)
    private String cep;
    @Column(name = "usuarioid" )
    private Long usuarioid;

}
