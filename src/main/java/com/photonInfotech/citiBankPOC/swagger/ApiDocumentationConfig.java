package com.photonInfotech.citiBankPOC.swagger;

import io.swagger.annotations.*;

@SwaggerDefinition(
        info = @Info(
                description = "CitiBank API ",
                version = "V12.0.12",
                title = "CitiBank API",
                contact = @Contact(
                        name = "Photon Infotech",
                        email = "manish.maganbhai@photoninfotech.net",
                        url = "http://www.photon.in/"
                ),
                license = @License(
                        name = "Photon Infotech",
                        url = "http://www.photon.in/"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "http://www.photon.in/")
)
public interface ApiDocumentationConfig {

}