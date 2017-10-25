package application.operation;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.discogsDB.model.Artist;
import application.discogsDB.service.ArtistRepository;
import application.musiccruxDB.model.entity.Entity;
import application.musiccruxDB.model.entity.EntityType;
import application.musiccruxDB.service.EntityRepository;



@Component
@Order(value = 2)
public class GenerateEntityModels implements CommandLineRunner{

	//This needs to read the Discogs database.
	//As it reads through each entry in the database,
	//create entities and append them to the list.
	@Autowired
	private ArtistRepository discogsArtistRepository;
	
	@Autowired
	private EntityRepository db;
	
	private List<Entity> entityModels = new ArrayList<Entity>();
	public List<Entity> getEntityModels() {
		return entityModels;
	}
	
	private void constructEntityFromArtist() {
		
		for (Artist artist : discogsArtistRepository.findAll()) {
			Entity entity = new Entity();
			entity.setLabel(artist.getName());
			entity.setId(artist.getId());
			
			if (artist.getMembers() == null) {
				entity.setType(EntityType.ARTIST);
			}else {
				entity.setType(EntityType.BAND);
			}
			System.out.println(entity);
			db.save(entity);			
		}
		for (Entity entity : db.findAll()) {
			System.out.println(entity);
		}
	}

	public void run(String... args) throws Exception {
		constructEntityFromArtist();
		
	}	
}