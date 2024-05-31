package co.develhope.checkpoint.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String CodFiscale;

    @Column(nullable = false)
    private String jobPosion;

    @Column(nullable = false, unique = true)
    private String email;

    public Employee() {
    }

    public Employee(Long id, String fullName, String codFiscale, String jobPosion, String email) {
        this.id = id;
        this.fullName = fullName;
        CodFiscale = codFiscale;
        this.jobPosion = jobPosion;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCodFiscale() {
        return CodFiscale;
    }

    public void setCodFiscale(String codFiscale) {
        CodFiscale = codFiscale;
    }

    public String getJobPosion() {
        return jobPosion;
    }

    public void setJobPosion(String jobPosion) {
        this.jobPosion = jobPosion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
