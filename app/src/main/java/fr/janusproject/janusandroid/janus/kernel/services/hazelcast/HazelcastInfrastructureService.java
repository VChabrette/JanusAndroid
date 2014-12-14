/*
 * $Id$
 *
 * Janus platform is an open-source multiagent platform.
 * More details on http://www.janusproject.io
 *
 * Copyright (C) 2014 Sebastian RODRIGUEZ, Nicolas GAUD, Stéphane GALLAND.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.janusproject.janusandroid.janus.kernel.services.hazelcast;

import fr.janusproject.janusandroid.janus.services.AbstractDependentService;
import fr.janusproject.janusandroid.janus.services.infrastructure.InfrastructureService;

import com.google.common.util.concurrent.Service;
import com.google.inject.Inject;
import com.hazelcast.core.HazelcastInstance;

/** This class supports the management of the hazelcast infrastructure.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class HazelcastInfrastructureService extends AbstractDependentService implements InfrastructureService {

	@Inject
	private HazelcastInstance hazelcastInstance;

	/**
	 */
	public HazelcastInfrastructureService() {
		//
	}

	@Override
	public final Class<? extends Service> getServiceType() {
		return InfrastructureService.class;
	}

	@Override
	protected void doStart() {
		notifyStarted();
	}

	@Override
	protected void doStop() {
		this.hazelcastInstance.shutdown();
		notifyStopped();
	}

}