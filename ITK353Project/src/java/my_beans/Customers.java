/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my_beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mjjarre
 */
@Entity
@Table(name = "CUSTOMERS", catalog = "", schema = "DEAL")
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByPassword", query = "SELECT c FROM Customers c WHERE c.password = :password"),
    @NamedQuery(name = "Customers.findByFirstname", query = "SELECT c FROM Customers c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customers.findByLastname", query = "SELECT c FROM Customers c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Customers.findByUsername", query = "SELECT c FROM Customers c WHERE c.username = :username"),
    @NamedQuery(name = "Customers.findByPhone", query = "SELECT c FROM Customers c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customers.findByEmail", query = "SELECT c FROM Customers c WHERE c.email = :email"),
    @NamedQuery(name = "Customers.findByStreetaddress", query = "SELECT c FROM Customers c WHERE c.streetaddress = :streetaddress"),
    @NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city"),
    @NamedQuery(name = "Customers.findByState", query = "SELECT c FROM Customers c WHERE c.state = :state"),
    @NamedQuery(name = "Customers.findByZipcode", query = "SELECT c FROM Customers c WHERE c.zipcode = :zipcode"),
    @NamedQuery(name = "Customers.findByCcno", query = "SELECT c FROM Customers c WHERE c.ccno = :ccno"),
    @NamedQuery(name = "Customers.findByCcname", query = "SELECT c FROM Customers c WHERE c.ccname = :ccname"),
    @NamedQuery(name = "Customers.findByCcexpmonth", query = "SELECT c FROM Customers c WHERE c.ccexpmonth = :ccexpmonth"),
    @NamedQuery(name = "Customers.findByCcexpyear", query = "SELECT c FROM Customers c WHERE c.ccexpyear = :ccexpyear"),
    @NamedQuery(name = "Customers.findByCctype", query = "SELECT c FROM Customers c WHERE c.cctype = :cctype")})
public class Customers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PASSWORD", length = 12)
    private String password;
    @Column(name = "FIRSTNAME", length = 20)
    private String firstname;
    @Column(name = "LASTNAME", length = 20)
    private String lastname;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME", nullable = false, length = 20)
    private String username;
    @Column(name = "PHONE", length = 10)
    private String phone;
    @Column(name = "EMAIL", length = 40)
    private String email;
    @Column(name = "STREETADDRESS", length = 50)
    private String streetaddress;
    @Column(name = "CITY", length = 30)
    private String city;
    @Column(name = "STATE", length = 2)
    private String state;
    @Column(name = "ZIPCODE", length = 6)
    private String zipcode;
    @Column(name = "CCNO", length = 16)
    private String ccno;
    @Column(name = "CCNAME", length = 40)
    private String ccname;
    @Column(name = "CCEXPMONTH", length = 2)
    private String ccexpmonth;
    @Column(name = "CCEXPYEAR", length = 4)
    private String ccexpyear;
    @Column(name = "CCTYPE", length = 16)
    private String cctype;

    public Customers() {
    }

    public Customers(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCcno() {
        return ccno;
    }

    public void setCcno(String ccno) {
        this.ccno = ccno;
    }

    public String getCcname() {
        return ccname;
    }

    public void setCcname(String ccname) {
        this.ccname = ccname;
    }

    public String getCcexpmonth() {
        return ccexpmonth;
    }

    public void setCcexpmonth(String ccexpmonth) {
        this.ccexpmonth = ccexpmonth;
    }

    public String getCcexpyear() {
        return ccexpyear;
    }

    public void setCcexpyear(String ccexpyear) {
        this.ccexpyear = ccexpyear;
    }

    public String getCctype() {
        return cctype;
    }

    public void setCctype(String cctype) {
        this.cctype = cctype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my_beans.Customers[username=" + username + "]";
    }

}
