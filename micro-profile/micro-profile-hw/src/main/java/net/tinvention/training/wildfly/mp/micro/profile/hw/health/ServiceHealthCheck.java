/*******************************************************************************
 *    Copyright 2019, Tinvention SRL
 *    This project includes software developed by Tinvention SRL .
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
package net.tinvention.training.wildfly.mp.micro.profile.hw.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class ServiceHealthCheck implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.named("Wlf-Training-" + ServiceHealthCheck.class.getSimpleName()).up().build();
	}
}
