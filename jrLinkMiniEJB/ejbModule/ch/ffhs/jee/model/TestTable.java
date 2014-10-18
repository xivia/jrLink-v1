package ch.ffhs.jee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tTest database table.
 * 
 */
@Entity
@Table(name="tTest")
@NamedQuery(name="TestTable.findAll", query="SELECT t FROM TestTable t ORDER BY t.key")
public class TestTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="tstProp")
	private String key;

	@Column(name="tstValue") 
	private String value;

	public TestTable() {
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}