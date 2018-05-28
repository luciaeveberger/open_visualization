package com.open_data_visualization.model;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "uv_data")
public class UVData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="uv_data_id")
    private int id;
    @Column(name="date")
    private java.util.Date date;

    @Column(name="RE1_UVB")
    private int RE1_UVB;

    @Column(name="RE1_T_UVB")
    private int RE1_T_UVB;

    @Column(name="RE1_UVA")
    private int RE1_UVA;

    @Column(name="RE1_T_UVA")
    private int RE1_T_UVA;

    @Column(name="LS1_UVB")
    private int LS1_UVB;

    @Column(name="LS1_T_UVB")
    private int LS1_T_UVB;

    @Column(name="LS1_UVA")
    private int LS1_UVA;

    @Column(name="LS1_T_UVA")
    private int LS1_T_UVA;

    public int getId() {
        return id;
    }
    public  java.util.Date getDate() {
        return date;
    }
    public int getRE1_UVB() {
        return RE1_UVB;
    }
    public int getRE1_T_UVB() {
        return RE1_T_UVB;
    }
    public int getRE1_UVA() {
        return RE1_UVA;
    }
    public int getRE1_T_UVA(){return RE1_T_UVA;}
    public int getLS1_UVB(){return LS1_UVB;}
    public int getLS1_T_UVB(){return LS1_T_UVB;}
    public int getLS1_UVA(){return LS1_UVA;}
    public int getLS1_T_UVA(){return LS1_T_UVA;}

}
