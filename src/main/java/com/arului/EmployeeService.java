package com.arului;

import com.arului.modal.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Produces(MediaType.APPLICATION_XML)
@Path ("/employee/service")
public class EmployeeService {
    @Inject
    EntityManager entityManager;

    @GET
    @Transactional
    @Path ("/all")
    public Response getEmployeeDetails(){
        return  Response.ok (entityManager.createNamedQuery("Employee.findAll", Employee.class)
                .getResultList().toArray(new Employee[0])).build ();
    }
}
