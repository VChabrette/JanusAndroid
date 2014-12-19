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
package fr.janusproject.janusandroid.janus.modules.kernel;

import fr.janusproject.janusandroid.janus.kernel.services.jdk.distributeddata.StandardDistributedDataStructureService;
import fr.janusproject.janusandroid.janus.services.distributeddata.DistributedDataStructureService;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/** Configure the {@link DistributedDataStructureService} for a local usage in the JVM.
 *
 * @author $Author: srodriguez$
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public class LocalDistributedDataStructureServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(DistributedDataStructureService.class).to(StandardDistributedDataStructureService.class)
				.in(Singleton.class);
	}

}
