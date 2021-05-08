package com.gxwz.medical.entity;

import java.util.Date;

//慢性病报销类
public class Billdetail {

	//自增主键
    private Integer id;

	//自增主键
    private String billno;

 
    private String mbno;

  
    private String cardno;


    private Long allcost;

 
    private Long bxpay;


    private Date treattime;


    private Date recordtime;

    private String treatinno;

   
    private String treatagenname;

 
    private String userid;


    
    private Integer fid;
    public Integer getFid() {
        return fid;
    }
    public void setFid(Integer fid) {
        this.fid = fid;
    }
    
    
    
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

  
    public String getBillno() {
        return billno;
    }


    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }


    public String getMbno() {
        return mbno;
    }


    public void setMbno(String mbno) {
        this.mbno = mbno == null ? null : mbno.trim();
    }


    public String getCardno() {
        return cardno;
    }


    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }


    public Long getAllcost() {
        return allcost;
    }


    public void setAllcost(Long allcost) {
        this.allcost = allcost;
    }


    public Long getBxpay() {
        return bxpay;
    }


    public void setBxpay(Long bxpay) {
        this.bxpay = bxpay;
    }


    public Date getTreattime() {
        return treattime;
    }


    public void setTreattime(Date treattime) {
        this.treattime = treattime;
    }


    public Date getRecordtime() {
        return recordtime;
    }


    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public String getTreatinno() {
        return treatinno;
    }

    
    public void setTreatinno(String treatinno) {
        this.treatinno = treatinno == null ? null : treatinno.trim();
    }

    public String gettreatagenname() {
        return treatagenname;
    }

   
    public void settreatagenname(String treatagenname) {
        this.treatagenname = treatagenname == null ? null : treatagenname.trim();
    }


    public String getUserid() {
        return userid;
    }


    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}