package org.example.jclo_2026_02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Jclo202602ApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	private static final GenericContainer<?> devapp = new GenericContainer<>("devapp")  // имя контейнера из docker-compose.yml
			.withExposedPorts(8080); // нестатичное поле - контейнер будет создаваться каждый раз
	private static final GenericContainer<?> prodapp = new GenericContainer<>("prodapp")  // имя контейнера из docker-compose.yml
			.withExposedPorts(8081); // статичное поле - контейнер будет один на все тесты

	@BeforeAll
	public static void setUp() {
		devapp.start();
		prodapp.start();

	}

	@Test
	void contextLoads() {
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devapp.getMappedPort(8080), String.class);
		System.out.println(forEntity.getBody());
	}
}
