package com.open_data_visualization.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "visualization_data")
public class VisualizationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="visualization_id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="data")
    private String data;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

}
