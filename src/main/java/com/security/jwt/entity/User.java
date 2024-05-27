package com.security.jwt.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIncludeProperties
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username",nullable = false)
	private String username;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="email",nullable = false)
	private String email;
	
	@Column(name="is_active",nullable = true)
	private Boolean isActive = true;

	@Column(name="mobile_no",nullable = false)
	private String mobileNo;
	
	@Column(name="login_count",nullable = true)
	private Long loginCount;
	
	@Column(name="created_at",nullable = true)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at",nullable = true)
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void before() {
		LocalDateTime dateTime = LocalDateTime.now();
		
		if(id == null && createdAt == null) {
			this.createdAt = dateTime;
		} 
		
		this.updatedAt = dateTime;
	}
	
}	
