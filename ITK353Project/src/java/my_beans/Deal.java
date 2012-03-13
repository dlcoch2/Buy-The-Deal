/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my_beans;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Matthew
 */
@Entity
@Table(name = "DEAL", catalog = "", schema = "DEAL")
@NamedQueries(
{
    @NamedQuery(name = "Deal.findAll", query = "SELECT d FROM Deal d"),
    @NamedQuery(name = "Deal.findByDealid", query = "SELECT d FROM Deal d WHERE d.dealid = :dealid"),
    @NamedQuery(name = "Deal.findByTitle", query = "SELECT d FROM Deal d WHERE d.title = :title"),
    @NamedQuery(name = "Deal.findByPrice", query = "SELECT d FROM Deal d WHERE d.price = :price"),
    @NamedQuery(name = "Deal.findByDescription", query = "SELECT d FROM Deal d WHERE d.description = :description")
})
public class Deal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEALID", nullable = false, length = 4)
    private String dealid;
    @Column(name = "TITLE", length = 25)
    private String title;
    @Column(name = "PRICE", precision = 7, scale = 2)
    private BigDecimal price;
    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    public Deal()
    {
    }

    public Deal(String dealid)
    {
        this.dealid = dealid;
    }

    public String getDealid()
    {
        return dealid;
    }

    public void setDealid(String dealid)
    {
        this.dealid = dealid;
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
        hash += (dealid != null ? dealid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deal))
        {
            return false;
        }
        Deal other = (Deal) object;
        if ((this.dealid == null && other.dealid != null) || (this.dealid != null && !this.dealid.equals(other.dealid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "my_beans.Deal[dealid=" + dealid + "]";
    }

}
