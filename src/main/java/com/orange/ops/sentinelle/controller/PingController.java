package com.orange.ops.sentinelle.controller;

import com.orange.ops.sentinelle.domain.CommandFactory;
import com.orange.ops.sentinelle.domain.InvocationResponse;
import com.orange.ops.sentinelle.domain.InvocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sebastien Bortolussi
 */
@RestController
public class PingController {

    @Autowired
    InvocationService invocationService;

    @Autowired
    CommandFactory commandFactory;

    @RequestMapping(value = "/ping/{destination}", method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity<String> ping(@PathVariable String destination) {
        final InvocationResponse invocationResponse = invocationService.run(commandFactory.ping(destination));
        return new ResponseEntity<>(invocationResponse.output(), invocationResponse.success() ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

