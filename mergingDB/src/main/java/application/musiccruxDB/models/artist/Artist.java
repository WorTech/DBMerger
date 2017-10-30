package application.musiccruxDB.models.artist;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Artist {
	@Id
	private BigInteger id;
	@Indexed
	private String label;

	public Artist() {
		
	}
	
	public Artist(BigInteger id, String label) {
		this.id = id;
		this.label = label;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", label=" + label + "]";
	}

}
