package com.open_data_visualization.model;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "cart")
public class Cart {
	public Cart(){}
	public Cart(String username, String contents, String userRequest){
		this.username = username;
		this.contents = contents;
		this.user_request = userRequest;
	}
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUser_request() {
		return user_request;
	}

	public void setUser_request(String user_request) {
		this.user_request = user_request;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "contents")
    private String contents;

    @Column(name = "user_request")
    private String user_request;

}