package main.com.njupt.kb.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Check;

@Entity
@Table(name="file")
public class File {
	
	private Integer id;
	private String originalName;
	private String newName;
	private String path;
	private Date date;
	private String type;
	private Category category;
	private Set<AssociateFile> associateFiles;
	private String commonUse;
	private String docPath;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cid",nullable=false)
	@JsonIgnore
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@OneToMany(mappedBy="file")
	@JsonIgnore
	public Set<AssociateFile> getAssociateFiles() {
		return associateFiles;
	}
	public void setAssociateFiles(Set<AssociateFile> associateFiles) {
		this.associateFiles = associateFiles;
	}
	

	public String getCommonUse() {
		return commonUse;
	}
	public void setCommonUse(String commonUse) {
		this.commonUse = commonUse;
	}
	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	
	
	
}
