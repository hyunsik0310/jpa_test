package com.hs.manage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
@NamedQueries({
   @NamedQuery(
         name = "Calendar.jointest",
         query = "select c from Calendar c LEFT JOIN c.wbs_2020"
         ),
})
public class Calendar {

   @Id
   private String yyyymmdd;
   private String yyyy;
   private String mm;
   private String dd;
   private String day;
   private String holiday;

   @OneToOne
   @JoinColumn(name="yyyymmdd")
   private Wbs_2020 wbs_2020 = new Wbs_2020();

   public String getYyyymmdd() {
      return yyyymmdd;
   }

   public void setYyyymmdd(String yyyymmdd) {
      this.yyyymmdd = yyyymmdd;
   }

   public String getYyyy() {
      return yyyy;
   }

   public void setYyyy(String yyyy) {
      this.yyyy = yyyy;
   }

   public String getMm() {
      return mm;
   }

   public void setMm(String mm) {
      this.mm = mm;
   }

   public String getDd() {
      return dd;
   }

   public void setDd(String dd) {
      this.dd = dd;
   }

   public String getDay() {
      return day;
   }

   public void setDay(String day) {
      this.day = day;
   }

   public String getHoliday() {
      return holiday;
   }

   public void setHoliday(String holiday) {
      this.holiday = holiday;
   }

   public Wbs_2020 getWbs_2020() {
      return wbs_2020;
   }

   public void setWbs_2020(Wbs_2020 wbs_2020) {
      this.wbs_2020 = wbs_2020;
   }

   @Override
   public String toString() {
      return "Calendar [yyyymmdd=" + yyyymmdd + ", yyyy=" + yyyy + ", mm=" + mm + ", dd=" + dd + ", day=" + day
            + ", holiday=" + holiday + ", wbs_2020=" + wbs_2020 + "]";
   }


}