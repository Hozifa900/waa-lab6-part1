package persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class PersonController {
	int id = 0;
	@Autowired
	private PersonRepository personRepository;

	@GetMapping(value = "/persons", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Person> getAllPersons() {
		return personRepository.findByChatRoom("app1");
	}

	@PostMapping("/persons")
	public void savePersonMessage(@RequestBody Person person) {
		savePerson(person);

	}

	private void savePerson(Person person) {
		System.out.println("Saving person " + id);
		id++;
		personRepository.save(new Person(id + "", person.getName(), person.getMessage(), "app1")).block();

	}

}
