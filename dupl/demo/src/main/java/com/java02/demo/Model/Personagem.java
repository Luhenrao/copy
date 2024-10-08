package com.java02.demo.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Personagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false, unique = true)
    private String nome;
    @Column(nullable = true, unique = false)
    private Long ki;
    @Column(nullable = false, unique = false)
    private String raca;
    @Column(nullable = true, unique = false)
    private String genero;
    @Column(nullable = true, unique = false)
    private String afiliacao;

    @ManyToOne
    private Planeta planetaOrigem;

}
