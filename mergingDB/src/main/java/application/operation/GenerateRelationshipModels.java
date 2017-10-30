package application.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.discogsDB.models.Artist;
import application.discogsDB.repositories.ArtistRepository;
import application.musiccruxDB.models.relationship.Relationship;
import application.musiccruxDB.models.relationship.RelationshipType;
import application.musiccruxDB.repositories.EntityRepository;
import application.musiccruxDB.repositories.RelationshipRepository;

/**
 * Creates a Relationship collection and adds relationship documents by querying
 * the Artist Collection for all Artists with members. From those members, we
 * create relationships using the Artist's members property.
 */
@Component
@Order(value = 1)
public class GenerateRelationshipModels implements CommandLineRunner {

	@Autowired
	private ArtistRepository discogsArtistRepository;
	@Autowired
	private EntityRepository entityRepository;
	@Autowired
	private RelationshipRepository db;

	private void constructRelationshipFromArtist() {
		for (Artist artist : discogsArtistRepository.findAllArtistsWithMembers()) {
			long[] Ids = artist.getMembers().getId();

			for (long id : Ids) {
				Relationship relationship = new Relationship();
				relationship.setType(RelationshipType.MEMBER);
				relationship.setSourceEntity(entityRepository.findById(id));
				relationship.setTargetEntity(entityRepository.findById(artist.getId()));
				db.save(relationship);
			}
		}
		for (Relationship r : db.findAll()) {
			System.out.println(r);
		}
	}

	public void run(String... args) throws Exception {
		constructRelationshipFromArtist();

	}
}