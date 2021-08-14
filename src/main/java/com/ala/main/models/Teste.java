package com.ala.main.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teste implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Number num;

}
