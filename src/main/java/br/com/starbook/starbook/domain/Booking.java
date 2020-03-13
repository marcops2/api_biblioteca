package br.com.starbook.starbook.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class Booking {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idBooking;

    @ManyToMany(mappedBy = "bookins")
    Set<User> bookss;

    @NotEmpty
    @Column(nullable = false)
    private Calendar calendar;

    @NotEmpty
    @Column(nullable = false)
    private Calendar reservationDay;

    @NotEmpty
    @Column(nullable = false)
    private Date finalDayForDevolution;

    public Booking(Calendar calendar, Calendar reservationDay, Date finalDayForDevolution) {

        //Codigo do livro, usuario id, nickname, email, token

    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Calendar getReservationDay() {
        return reservationDay;
    }

    public void setReservationDay(Calendar reservationDay) {
        this.reservationDay = reservationDay;
    }

    public Date getFinalDayForDevolution() {
        return finalDayForDevolution;
    }

    public void setFinalDayForDevolution(Date finalDayForDevolution) {
        this.finalDayForDevolution = finalDayForDevolution;
    }
}
