package com.kineesio.TicketGuru;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kineesio.TicketGuru.domain.models.Kayttaja;
import com.kineesio.TicketGuru.domain.repositories.KayttajaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class KayttajaRepositoryTest {
	
	@Autowired
	private KayttajaRepository kRepository;
	
	@Test
	public void createNewKayttaja() {
	Kayttaja kayttaja = new Kayttaja("Mestari","" , "Sasu", "Korhonen", null, null, "Sasu@Gmail.com");
	kRepository.save(kayttaja);
	assertThat(kayttaja.getKayttajaid()).isNotNull();
	}
}