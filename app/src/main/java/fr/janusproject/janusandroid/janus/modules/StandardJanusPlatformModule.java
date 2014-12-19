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
package fr.janusproject.janusandroid.janus.modules;

import fr.janusproject.janusandroid.janus.JanusConfig;
import fr.janusproject.janusandroid.janus.modules.eventserial.NetworkEventModule;
import fr.janusproject.janusandroid.janus.modules.hazelcast.HazelcastModule;
import fr.janusproject.janusandroid.janus.modules.kernel.LocalDistributedDataStructureServiceModule;
import fr.janusproject.janusandroid.janus.modules.kernel.LocalInfrastructureServiceModule;
import fr.janusproject.janusandroid.janus.modules.kernel.LocalKernelDiscoveryServiceModule;
import fr.janusproject.janusandroid.janus.modules.nonetwork.NoNetworkModule;
import fr.janusproject.janusandroid.janus.modules.zeromq.ZeroMQNetworkModule;

import com.google.inject.AbstractModule;

/**
 * The module configures Janus to run using the standard core modules
 * and a ZeroMQ based network.
 *
 * @author $Author: srodriguez$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class StandardJanusPlatformModule extends AbstractModule {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure() {
		boolean isNetworkEnabled = !JanusConfig.getSystemPropertyAsBoolean(JanusConfig.OFFLINE, false);

		install(new BootModule());

		if (isNetworkEnabled) {
			install(new HazelcastModule());
		} else {
			install(new LocalInfrastructureServiceModule());
			install(new LocalDistributedDataStructureServiceModule());
			install(new LocalKernelDiscoveryServiceModule());
		}

		install(new StandardCoreModule());

		if (isNetworkEnabled) {
			install(new NetworkEventModule());
			install(new ZeroMQNetworkModule());
		} else {
			install(new NoNetworkModule());
		}
	}

}
