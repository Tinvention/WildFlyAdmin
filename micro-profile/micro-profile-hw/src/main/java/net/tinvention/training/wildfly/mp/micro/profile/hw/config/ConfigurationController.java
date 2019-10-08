/*******************************************************************************
 *    Copyright 2019, Tinvention SRL
 *    This project includes software developed by Tinvention - Ingegneria Informatica .
 *    http://tinvention.net/
 *    
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the Licens
 *    
 *******************************************************************************/
package net.tinvention.training.wildfly.mp.micro.profile.hw.config;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/config")
@RequestScoped
public class ConfigurationController {

    @Inject
    @ConfigProperty(name = "config.param.1")
    private String configParam1;
    
    @Inject 
    private Config config;

    @Path("/configParam-1")
    @GET
    public String getConfigValue1() {
        return "config.param.1 value is: " + configParam1;
    }

    @Path("/configParam-2")
    @GET
    public String getLookupConfigValue() {
        Config configLocal = ConfigProvider.getConfig();
        String value = configLocal.getValue("config.param.2", String.class);
        return "config.param.2 value , by Lookup, is: " + value;
    }
    
    @Path("/configParams")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response configParams() {
    	Map<String, String> result = new HashMap<>();
    	config.getPropertyNames().forEach(
    			(currName) -> result.put(currName, config.getValue(currName, String.class))
    	);    
    	
    	return Response
    		      .status(Response.Status.OK)
    		      .entity(result)
    		      .build();
    }
}
