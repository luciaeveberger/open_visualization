package com.open_data_visualization.model;

import javax.persistence.*;

@Entity
@Table(name = "pollen_weekly_data")
public class PollenWeeklyData {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSTAT_ID() {
		return STAT_ID;
	}

	public void setSTAT_ID(int sTAT_ID) {
		STAT_ID = sTAT_ID;
	}

	public String getSTAT_CODE() {
		return STAT_CODE;
	}

	public void setSTAT_CODE(String sTAT_CODE) {
		STAT_CODE = sTAT_CODE;
	}

	public String getSTAT_NAME_I() {
		return STAT_NAME_I;
	}

	public void setSTAT_NAME_I(String sTAT_NAME_I) {
		STAT_NAME_I = sTAT_NAME_I;
	}

	public String getSTAT_NAME_D() {
		return STAT_NAME_D;
	}

	public void setSTAT_NAME_D(String sTAT_NAME_D) {
		STAT_NAME_D = sTAT_NAME_D;
	}

	public int getPART_SEQ() {
		return PART_SEQ;
	}

	public void setPART_SEQ(int pART_SEQ) {
		PART_SEQ = pART_SEQ;
	}

	public int getPART_LEVEL() {
		return PART_LEVEL;
	}

	public void setPART_LEVEL(int pART_LEVEL) {
		PART_LEVEL = pART_LEVEL;
	}

	public String getPART_NAME_L() {
		return PART_NAME_L;
	}

	public void setPART_NAME_L(String pART_NAME_L) {
		PART_NAME_L = pART_NAME_L;
	}

	public String getPART_FATHER_NAME_L() {
		return PART_FATHER_NAME_L;
	}

	public void setPART_FATHER_NAME_L(String pART_FATHER_NAME_L) {
		PART_FATHER_NAME_L = pART_FATHER_NAME_L;
	}

	public java.util.Date getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(java.util.Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public int getDAY1() {
		return DAY1;
	}

	public void setDAY1(int dAY1) {
		DAY1 = dAY1;
	}

	public int getDAY2() {
		return DAY2;
	}

	public void setDAY2(int dAY2) {
		DAY2 = dAY2;
	}

	public int getDAY3() {
		return DAY3;
	}

	public void setDAY3(int dAY3) {
		DAY3 = dAY3;
	}

	public int getDAY4() {
		return DAY4;
	}

	public void setDAY4(int dAY4) {
		DAY4 = dAY4;
	}

	public int getDAY5() {
		return DAY5;
	}

	public void setDAY5(int dAY5) {
		DAY5 = dAY5;
	}

	public int getDAY6() {
		return DAY6;
	}

	public void setDAY6(int dAY6) {
		DAY6 = dAY6;
	}

	public int getDAY7() {
		return DAY7;
	}

	public void setDAY7(int dAY7) {
		DAY7 = dAY7;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="pollen_weekly_id")
    private int id;

    @Column(name="STAT_ID")
    private int STAT_ID;

    @Column(name="STAT_CODE")
    private String STAT_CODE;

    @Column(name="STAT_NAME_I")
    private String STAT_NAME_I;

    @Column(name="STAT_NAME_D")
    private String STAT_NAME_D;

    @Column(name="PART_SEQ")
    private int PART_SEQ;

    @Column(name="PART_LEVEL")
    private int PART_LEVEL;


    @Column(name="PART_NAME_L")
    private String PART_NAME_L;

    @Column(name="PART_FATHER_NAME_L")
    private String PART_FATHER_NAME_L;

    @Column(name="START_DATE")
    private java.util.Date START_DATE;

    @Column(name="DAY1")
    private int DAY1;

    @Column(name="DAY2")
    private int DAY2;

    @Column(name="DAY3")
    private int DAY3;

    @Column(name="DAY4")
    private int DAY4;

    @Column(name="DAY5")
    private int DAY5;

    @Column(name="DAY6")
    private int DAY6;

    @Column(name="DAY7")
    private int DAY7;



}
