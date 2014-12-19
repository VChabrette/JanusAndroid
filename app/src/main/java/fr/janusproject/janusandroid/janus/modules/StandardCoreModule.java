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

import fr.janusproject.janusandroid.janus.kernel.services.arakhne.ArakhneLocaleLogService;
import fr.janusproject.janusandroid.janus.kernel.services.jdk.contextspace.StandardContextSpaceService;
import fr.janusproject.janusandroid.janus.kernel.services.jdk.spawn.StandardSpawnService;
import fr.janusproject.janusandroid.janus.modules.executors.JdkExecutorModule;
import fr.janusproject.janusandroid.janus.modules.kernel.MandatoryKernelModule;
import fr.janusproject.janusandroid.janus.services.contextspace.ContextSpaceService;
import fr.janusproject.janusandroid.janus.services.distributeddata.DistributedDataStructureService;
import fr.janusproject.janusandroid.janus.services.executor.ExecutorService;
import fr.janusproject.janusandroid.janus.services.kerneldiscovery.KernelDiscoveryService;
import fr.janusproject.janusandroid.janus.services.logging.LogService;
import fr.janusproject.janusandroid.janus.services.network.NetworkService;
import fr.janusproject.janusandroid.janus.services.spawn.SpawnService;

import com.google.common.util.concurrent.Service;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;

/**
 * The Core Janus Module configures the minimum requirements
 * for Janus to run properly.
 * The network-based modules are skipped in this StandardCoreModule.
 * See {@link StandardJanusPlatformModule} for the configuration
 * of the network-based modules
 *
 *
 * @author $Author: srodriguez$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class StandardCoreModule extends AbstractModule {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure() {
		bind(LogService.class).to(ArakhneLocaleLogService.class).in(Singleton.class);
		bind(ContextSpaceService.class).to(StandardContextSpaceService.class).in(Singleton.class);
		bind(SpawnService.class).to(StandardSpawnService.class).in(Singleton.class);

		install(new JdkExecutorModule());

		// Install the elements for the Janus kernel
		install(new MandatoryKernelModule());

		// Check if all the services are binded
		requireBinding(DistributedDataStructureService.class);
		requireBinding(KernelDiscoveryService.class);
		requireBinding(ExecutorService.class);
		requireBinding(ContextSpaceService.class);
		requireBinding(LogService.class);
		requireBinding(NetworkService.class);
		requireBinding(SpawnService.class);

		// Create a binder for: Set<Service>
		// (This set is given to the service manager to launch the services).
		Multibinder<Service> serviceSetBinder = Multibinder.newSetBinder(binder(), Service.class);
		serviceSetBinder.addBinding().to(LogService.class);
		serviceSetBinder.addBinding().to(ExecutorService.class);
		serviceSetBinder.addBinding().to(ContextSpaceService.class);
		serviceSetBinder.addBinding().to(KernelDiscoveryService.class);
		serviceSetBinder.addBinding().to(SpawnService.class);
		serviceSetBinder.addBinding().to(DistributedDataStructureService.class);
	}

}
