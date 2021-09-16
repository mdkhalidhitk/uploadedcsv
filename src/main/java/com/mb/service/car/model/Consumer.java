package com.mb.service.car.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name = "tutorials")
@Data
@AllArgsConstructor
public class Consumer {
	   @Id
	  @Column(name = "id")
	  private long id;

	  @Column(name = "title")
	  private String title;

	  @Column(name = "description")
	  private String description;

	  @Column(name = "published")
	  private boolean published;	
	  
	  public Consumer() {}

}
