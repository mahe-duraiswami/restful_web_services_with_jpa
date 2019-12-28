package com.mahe.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	//URI Versioning
	
	@GetMapping(path="/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Mahe Duraiswami");
	}
	
	@GetMapping(path="/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Mahe","Duraiswami"));
	}

	//Param Versioning

	@GetMapping(value="/person",params="version=1")
	public PersonV1 getPersonParamV1() {
		return new PersonV1("Mahe Duraiswami");
	}
	
	@GetMapping(path="/person",params="version=2")
	public PersonV2 getPersonParamV2() {
		return new PersonV2(new Name("Mahe","Duraiswami"));
	}
	
	//Custom Header Versioning

	@GetMapping(value="/person",headers="API-VERSION=1")
	public PersonV1 getPersonHeaderV1() {
		return new PersonV1("Mahe Duraiswami");
	}
	
	@GetMapping(path="/person",headers="API-VERSION=2")
	public PersonV2 getPersonHeaderV2() {
		return new PersonV2(new Name("Mahe","Duraiswami"));
	}

	//Accept Header Versioning

	@GetMapping(value="/person",produces="application/v1+json")
	public PersonV1 getPersonProducesV1() {
		return new PersonV1("Mahe Duraiswami");
	}
	
	@GetMapping(path="/person",produces="application/v2+json")
	public PersonV2 getPersonProducesV2() {
		return new PersonV2(new Name("Mahe","Duraiswami"));
	}


}
