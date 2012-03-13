/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my_beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Matthew
 */
@Entity
@Table(name = "PURCHASE", catalog = "", schema = "DEAL")
@NamedQueries(
{
    @NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p"),
    @NamedQuery(name = "Purchase.findByPurchaseid", query = "SELECT p FROM Purchase p WHERE p.purchaseid = :purchaseid"),
    @NamedQuery(name = "Purchase.findByDealid", query = "SELECT p FROM Purchase p WHERE p.dealid = :dealid"),
    @NamedQuery(name = "Purchase.findByTimestamp", query = "SELECT p FROM Purchase p WHERE p.timestamp = :timestamp"),
    @NamedQuery(name = "Purchase.findByTotalprice", query = "SELECT p FROM Purchase p WHERE p.totalprice = :totalprice"),
    @NamedQuery(name = "Purchase.findByUsername", query = "SELECT p FROM Purchase p WHERE p.username = :username"),
    @NamedQuery(name = "Purchase.findByTitle", query = "SELECT p FROM Purchase p WHERE p.title = :title"),
    @NamedQuery(name = "Purchase.findByPrice", query = "SELECT p FROM Purchase p WHERE p.price = :price"),
    @NamedQuery(name = "Purchase.findByDescription", query = "SELECT p FROM Purchase p WHERE p.description = :description")
})
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PURCHASEID", nullable = false)
    private Integer purchaseid;
    @Column(name = "DEALID", length = 4)
    private String dealid;
    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "TOTALPRICE", precision = 7, scale = 2)
    private BigDecimal totalprice;
    @Column(name = "USERNAME", length = 20)
    private String username;
    @Column(name = "TITLE", length = 25)
    private String title;
    @Column(name = "PRICE", precision = 7, scale = 2)
    private BigDecimal price;
    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    public Purchase()
    {
    }

    public Purchase(Integer purchaseid)
    {
        this.purchaseid = purchaseid;
    }

    public Integer getPurchaseid()
    {
        return purchaseid;
    }

    public void setPurchaseid(Integer purchaseid)
    {
        this.purchaseid = purchaseid;
    }

    public String getDealid()
    {
        return dealid;
    }

    public void setDealid(String dealid)
    {
        this.dealid = dealid;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public BigDecimal getTotalprice()
    {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice)
    {
        this.totalprice = totalprice;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (purchaseid != null ? purchaseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase))
        {
            return false;
        }
        Purchase other = (Purchase) object;
        if ((this.purchaseid == null && other.purchaseid != null) || (this.purchaseid != null && !this.purchaseid.equals(other.purchaseid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "my_beans.Purchase[purchaseid=" + purchaseid + "]";
    }

}
