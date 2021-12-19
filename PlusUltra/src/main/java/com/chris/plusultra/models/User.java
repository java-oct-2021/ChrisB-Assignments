package com.chris.plusultra.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String email;
	@Size(min=8)
	private String password;
	@Transient 
	private String confirmPassword;
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Picture> pics;
	
	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Share> myShare;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "share_id")
    )
    private List<Share> sharesLiked;
	// Maybe add followers?
//	@ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "follows", 
//        joinColumns = @JoinColumn(name = "user_id"), 
//        inverseJoinColumns = @JoinColumn(name = "following_id")
//    )
//    private List<User> following;
//	
//	@ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "follows", 
//        joinColumns = @JoinColumn(name = "following_id"), 
//        inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    private List<User> followers;
	
	public User() {
		super();
	}

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public List<Share> getMyShare() {
		return myShare;
	}


	public void setMyShare(List<Share> myShare) {
		this.myShare = myShare;
	}


	public List<Share> getSharesLiked() {
		return sharesLiked;
	}


	public void setSharesLiked(List<Share> sharesLiked) {
		this.sharesLiked = sharesLiked;
	}


	public List<Picture> getPics() {
		return pics;
	}


	public void setPics(List<Picture> pics) {
		this.pics = pics;
	}
	
	
}
