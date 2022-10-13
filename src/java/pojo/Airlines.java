package pojo;
// Generated Oct 10, 2022 3:35:36 PM by Hibernate Tools 4.3.1


import dao.AirlinesDao;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;

/**
 * Airlines generated by hbm2java
 */
@ManagedBean
public class Airlines  implements java.io.Serializable {


     private Integer id;
     private String code;
     private String name;
     private Set airplaneses = new HashSet(0);
     AirlinesDao dao = new AirlinesDao();

    public Airlines() {
    }

	
    public Airlines(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public Airlines(String code, String name, Set airplaneses) {
       this.code = code;
       this.name = name;
       this.airplaneses = airplaneses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getAirplaneses() {
        return this.airplaneses;
    }
    
    public void setAirplaneses(Set airplaneses) {
        this.airplaneses = airplaneses;
    }

    public List<Airlines> getAll() {
        return dao.getAll();
    }
    
    public String getById() {
        Airlines airline = dao.getById(id);
        this.id = airline.getId();
        this.code = airline.getCode();
        this.name = airline.getName();
        
        return "./edit_airlines.xhtml";
    }
    
    public String update() {
        boolean isUpdated = dao.update(this);
        
        return isUpdated ? "../airlines.xhtml" : "./edit_airlines.xhtml";
    }

    public String create() {
        boolean isCreated = dao.create(this);
        
        return isCreated ? "../airlines.xhtml" : "./create_airlines.xhtml";
    }
    
    public String delete() {
        boolean isDeleted = dao.delete(this);
        
        return isDeleted ? "../airlines.xhtml" : "./edit_airlines.xhtml";
    }
}


