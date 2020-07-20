package com.arului.modal;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQuery (name = "Employee.findAll",
        query = "SELECT e FROM Employee e ORDER BY e.name",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") )
public class Employee {
    private Long id;
    private String name;

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator="giftSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
