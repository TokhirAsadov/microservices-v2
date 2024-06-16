package uz.takhir.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // URI Versioning - Twitter
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Tom Cruse");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Tom","Cruse"));
    }

    // Request Parameter versioning - Amazon
    @GetMapping(value = "/person",params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParam(){
        return new PersonV1("Tom Cruse");
    }

    @GetMapping(value = "/person",params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParam(){
        return new PersonV2(new Name("Tom","Cruse"));
    }

    // (Custom) headers versioning - Microsoft
    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("Tom Cruse");
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2(new Name("Tom","Cruse"));
    }

    // Media type versioning (a.k.a "content negotiation" or "accept header") - GitHub
    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonRequestAccept(){
        return new PersonV1("Tom Cruse");
    }

    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonRequestAccept(){
        return new PersonV2(new Name("Tom","Cruse"));
    }
}
