package com.apigateway.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
//    		"/auth/authenticate",
//    		"/auth/registerDealer",
//    		"/auth/registerFarmer",
//    		"/auth/welcome",
    		"/auth/",
    		"/dealer-service/addDealer",
    		"/farmer-service/addFarmer",
            "/crop-service/"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}