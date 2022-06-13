package com.nossareserva.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AREACOMUM")
public class AreaComumModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAreaComum;
    private String name;
    private String photoUrl;
    private String tag;
    private boolean status;

    public long getIdAreaComum() {
        return idAreaComum;
    }

    public void setIdAreaComum(long idAreaComum) {
        this.idAreaComum = idAreaComum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
