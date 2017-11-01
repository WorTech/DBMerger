package application.operation;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.discogsDB.models.Artist;
import application.discogsDB.repositories.DiscogsArtistRepository;
import application.musiccruxDB.models.entity.Entity;
import application.musiccruxDB.models.entity.EntityType;
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
@Order(value = 3)
public class GenerateRelationshipModels implements CommandLineRunner {

	@Autowired
	private DiscogsArtistRepository discogsArtistRepository;
	@Autowired
	private EntityRepository entityRepository;
	@Autowired
	private RelationshipRepository db;

	/**
	 * From the entities of type BAND within the MusicCrux database, look through
	 * the Discogs database for 'artists' which match that entity and create a
	 * 'member' relationship between the Band and Artist entities
	 * 
	 * Note: In the Discogs database, the 'artist' collection contains both bands
	 * and actual artists.
	 */
	private void createBandToArtistRelationship() {

		for (Entity targetEntity : entityRepository.findByType(EntityType.BAND)) {

			Artist discogsArtist = discogsArtistRepository.findByName(targetEntity.getLabel());// Find the band ('artist' in
																							// discogs)
			if (discogsArtist != null) {

				String[] memberLabels = discogsArtist.getMembers().getNames();
				for (String label : memberLabels) {
					Entity sourceEntity = entityRepository.findByLabel(label);
					
					Relationship relationship = new Relationship();
					relationship.setTargetEntity(targetEntity);
					relationship.setSourceEntity(sourceEntity);
					relationship.setType(RelationshipType.MEMBER);
					db.save(relationship);
				}

			}

		}
	}
	// private void constructRelationshipFromArtist() {
	//
	//
	// for (Artist artist : discogsArtistRepository.findAllArtistsWithMembers()) {
	// long[] Ids = artist.getMembers().getId();
	//
	// for (long id : Ids) {
	// Relationship relationship = new Relationship();
	// relationship.setType(RelationshipType.MEMBER);
	// relationship.setSourceEntity(entityRepository.findById(id));
	// relationship.setTargetEntity(entityRepository.findById(artist.getId()));
	// db.save(relationship);
	// }
	// }
	// for (Relationship r : db.findAll()) {
	// System.out.println(r);
	// }
	// }

	public void run(String... args) throws Exception {
		// constructRelationshipFromArtist();

		createBandToArtistRelationship();

	}
}