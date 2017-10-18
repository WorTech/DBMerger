package application.discogsDB.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an actual artist. In most cases this are musicians, however
 * sound-engineers, producers, and bands etc. may also appear as artists
 * 
 */

public class Artist {
	
	@Id
	private long id;
	private String name;
	private String releasesUrl;
	private String resourceUrl;
	private List<Member> members;

	
	public Artist() {
		
	}
	public Artist(long id, String name, String releasesUrl, String resourceUrl, List<Member> member) {
		//super();
		this.id = id;
		this.name = name;
		this.releasesUrl = releasesUrl;
		this.resourceUrl = resourceUrl;
		this.members = members;
	}
	
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleasesUrl() {
		return releasesUrl;
	}
	public void setReleasesUrl(String releasesUrl) {
		this.releasesUrl = releasesUrl;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", members=" + members + "]";
	}
}