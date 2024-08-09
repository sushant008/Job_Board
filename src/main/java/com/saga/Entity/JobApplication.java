package com.saga.Entity;

import com.saga.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class JobApplication extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 46835149772133977L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id",nullable = false)
    private Job job;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;


    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "Educational_Qualification")
    private String qualification;

    @Column(name = "Job_Experience")
    private String experience;

    @Column(name = "Job_Position")
    private String position;

    @Column(name="Previous_Company")
    private String company;

    @Lob
    @Column(name = "Resume")
    private byte[] resume;

    @Column(name = "FileName")
    private String fileName;
}