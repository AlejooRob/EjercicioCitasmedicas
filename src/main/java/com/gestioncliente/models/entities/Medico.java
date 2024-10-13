package com.gestioncliente.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Debe agregar un nombre")
    private String nombre;
    @NotBlank(message = "Debe agregar un apellido")
    private String apellidos;
    @Pattern(regexp = "^\\d{10}$", message = "La cédula debe tener 10 dígitos")
    private String cedula;
    @Email(message = "Debe ingresar un email válido")
    private String email;
    private String telefono;

}
