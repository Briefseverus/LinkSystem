package com.example.appname.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



import java.util.List;





@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "pass")
    private String pass;

    @Column(name = "exp")
    private int exp;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Link> links;

    @Column(name = "domain")
    private String domain;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<ReceivedData> receivedData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role role;
    public User() {}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<ReceivedData> getReceivedData() {
        return receivedData;
    }

    public void setReceivedData(List<ReceivedData> receivedData) {
        this.receivedData = receivedData;
    }

	public User orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isAdmin() {
	    return this.getRole().getName().equals("AD");
	}
}
