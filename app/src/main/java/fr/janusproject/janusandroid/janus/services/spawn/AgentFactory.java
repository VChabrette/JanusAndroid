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
package fr.janusproject.janusandroid.janus.services.spawn;

import io.sarl.lang.core.Agent;

import java.util.UUID;

/** Create of agent instance.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public interface AgentFactory {

	/** Create an instance of agent, and inject the
	 * fields.
	 *
	 * @param <T> - type of the agent to create.
	 * @param type - type of the agent to create.
	 * @param agentID - id of the new agent, or <code>null</code>
	 *                  if the agent identifier must be randomly
	 *                  computed.
	 * @param contextID - id of the parent context.
	 * @return the agent.
	 * @throws Exception - when the instance of the agent cannot be created.
	 */
	<T extends Agent> T newInstance(Class<T> type, UUID agentID, UUID contextID) throws Exception;

}