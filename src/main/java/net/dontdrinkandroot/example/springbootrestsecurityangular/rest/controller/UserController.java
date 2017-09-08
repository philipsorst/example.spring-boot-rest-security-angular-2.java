package net.dontdrinkandroot.example.springbootrestsecurityangular.rest.controller;

import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model.User;
import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.service.security.SecurityService;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@RepositoryRestController
public class UserController
{
    private SecurityService securityService;

    public UserController(
            SecurityService securityService
    )
    {
        this.securityService = securityService;
    }

    @RequestMapping(value = "/users/current", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resource<?>> current(PersistentEntityResourceAssembler assembler)
    {
        User user = this.securityService.getCurrentUser();
        if (null == user) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PersistentEntityResource persistentEntityResource = assembler.toFullResource(user);
        return new ResponseEntity<>(persistentEntityResource, null, HttpStatus.OK);
    }
}
