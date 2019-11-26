package com.info.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
   name = "CONTACT_BOOK"
)
@NamedQueries({@NamedQuery(
   name = "ContactBook.getContactById",
   query = "from ContactBook c where c.id=:id"
)})
@Scope("session")
public class ContactBook  extends SuperEntity{
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_SEQUENCE")
   @SequenceGenerator(name="ID_SEQUENCE",sequenceName="CONTACTBOOK_SEQUENCE",allocationSize=1)
   @Column(
      name = "ID"
   )
   private Integer id;
   @ManyToOne
   @JoinColumn(
      name = "SRC_USER_ID"
   )
   private User sourceUser;
   @Column(
      name = "NAME"
   )
   private String name;
   @Column(
      name = "USER_ID"
   )
   private Integer userId;
   @Column(
      name = "EMAIL"
   )
   private String email;
   @Column(
      name = "DOB"
   )
   @Temporal(TemporalType.DATE)
   @DateTimeFormat(
      pattern = "dd/MM/yyyy"
   )
   private Date dob;
   @Column(
      name = "PHONE"
   )
   private String phone;
   @Column(
      name = "CITY"
   )
   private String city;
   @Transient
   private Integer[] selectedContacts;

   public Integer getId() {
      return this.id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getUserId() {
      return this.userId;
   }

   public void setUserId(Integer userId) {
      this.userId = userId;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Date getDob() {
      return this.dob;
   }

   public void setDob(Date dob) {
      this.dob = dob;
   }

   public String getPhone() {
      return this.phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public User getSourceUser() {
      return this.sourceUser;
   }

   public void setSourceUser(User sourceUser) {
      this.sourceUser = sourceUser;
   }

   public Integer[] getSelectedContacts() {
      return this.selectedContacts;
   }

   public void setSelectedContacts(Integer[] selectedContacts) {
      this.selectedContacts = selectedContacts;
   }

@Override
public void loadDataFromDB(SuperEntity entity) {
	// TODO Auto-generated method stub
	
}

@Override
public void loadDataFromUI(SuperEntity entity) {
	// TODO Auto-generated method stub
	
}

@Override
public int compare(SuperEntity o1, SuperEntity o2) {
	// TODO Auto-generated method stub
	return 0;
}
}