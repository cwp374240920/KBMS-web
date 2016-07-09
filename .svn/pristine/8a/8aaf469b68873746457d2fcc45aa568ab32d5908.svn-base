package main.com.njupt.kb.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="associateFile")
public class AssociateFile {
	
	private Integer id;
	private File file;				//关联文件
	private String information;		//关联信息
	private String associateKey;	//关联键程序分配
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fid")
	@JsonIgnore
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getAssociateKey() {
		return associateKey;
	}
	public void setAssociateKey(String associateKey) {
		this.associateKey = associateKey;
	}

}
