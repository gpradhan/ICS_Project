package com.info.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.context.annotation.Scope;

@Entity
@Table(
   name = "MESSAGES"
)
@NamedQuery(
   name = "Message.findByToUser",
   query = "select o from Message o where o.toUser=:toUser"
)
@Scope("session")
public class Message  extends SuperEntity{
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ID_SEQUENCE")
   @SequenceGenerator(name="ID_SEQUENCE",sequenceName="MESSAGE_SEQUENCE",allocationSize=1)
   @Column(
      name = "ID"
   )
   private Integer id;
   @Column(
      name = "FROM_USER"
   )
   private Integer fromUser;
   @Column(
      name = "TO_USER"
   )
   private Integer toUser;
   @Column(
      name = "TIME"
   )
   @Temporal(TemporalType.TIMESTAMP)
   private Date time;
   @Column(
      name = "SUBJECT"
   )
   private String subject;
   @Column(
      name = "MESSAGE_BODY"
   )
   private String messageBody;
   @Transient
   private String fromUserName;
   @Transient
   private String toUserName;

   public Integer getId() {
      return this.id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getFromUser() {
      return this.fromUser;
   }

   public void setFromUser(Integer fromUser) {
      this.fromUser = fromUser;
   }

   public Integer getToUser() {
      return this.toUser;
   }

   public void setToUser(Integer toUser) {
      this.toUser = toUser;
   }

   public Date getTime() {
      return this.time;
   }

   public void setTime(Date time) {
      this.time = time;
   }

   public String getSubject() {
      return this.subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getMessageBody() {
      return this.messageBody;
   }

   public void setMessageBody(String messageBody) {
      this.messageBody = messageBody;
   }

   public String getFromUserName() {
      return this.fromUserName;
   }

   public void setFromUserName(String fromUserName) {
      this.fromUserName = fromUserName;
   }

   public String getToUserName() {
      return this.toUserName;
   }

   public void setToUserName(String toUserName) {
      this.toUserName = toUserName;
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