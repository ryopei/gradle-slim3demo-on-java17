package slim3.demo.model;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    @Sync(true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private Integer schemaVersion = 1;

    private org.slim3.datastore.ModelRef<slim3.demo.model.Address> addressRef =
        new org.slim3.datastore.ModelRef<slim3.demo.model.Address>(
            slim3.demo.model.Address.class);

    private org.slim3.datastore.ModelRef<slim3.demo.model.Department> departmentRef =
        new org.slim3.datastore.ModelRef<slim3.demo.model.Department>(
            slim3.demo.model.Department.class);

    @Attribute(persistent = false)
    private org.slim3.datastore.InverseModelListRef<slim3.demo.model.EmployeeProject, slim3.demo.model.Employee> employeeProjectListRef =
        new org.slim3.datastore.InverseModelListRef<slim3.demo.model.EmployeeProject, slim3.demo.model.Employee>(
            slim3.demo.model.EmployeeProject.class,
            "employeeRef",
            this);

    /**
     * Returns the key.
     * 
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     * 
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     * 
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Returns the schema version.
     * 
     * @return the schema version
     */
    public Integer getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Sets the schema version.
     * 
     * @param schemaVersion
     *            the schema version
     */
    public void setSchemaVersion(Integer schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    /**
     * @return the addressRef
     */
    public org.slim3.datastore.ModelRef<slim3.demo.model.Address> getAddressRef() {
        return addressRef;
    }

    /**
     * @return the departmentRef
     */
    public org.slim3.datastore.ModelRef<slim3.demo.model.Department> getDepartmentRef() {
        return departmentRef;
    }

    /**
     * @return the employeeProjectListRef
     */
    public InverseModelListRef<EmployeeProject, Employee> getEmployeeProjectListRef() {
        return employeeProjectListRef;
    }
}
