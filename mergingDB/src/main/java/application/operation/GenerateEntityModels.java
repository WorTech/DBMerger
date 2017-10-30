package application.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.discogsDB.models.Artist;
import application.discogsDB.repositories.ArtistRepository;
import application.musiccruxDB.models.entity.Entity;
import application.musiccruxDB.models.entity.EntityType;
import application.musiccruxDB.repositories.EntityRepository;

/*
 * Read the Discogs database and create Entities collection from Artists.
 */

@Component
@Order(value = 1)
public class GenerateEntityModels implements CommandLineRunner {

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
			} else {
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