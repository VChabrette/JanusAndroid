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
package fr.janusproject.janusandroid.janus.util;


/** An object that is delegate to a collection object.
 *
 * @author $Author: galland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
public final class DataViewDelegate {

	private DataViewDelegate() {
		//
	}

	/** Find the delegated object.
	 *
	 * @param object - the object.
	 * @return the delegator object.
	 */
	public static Object undelegate(Object object) {
		Object o = object;
		while (o instanceof Delegator) {
			o = ((Delegator<?>) o).getDelegatedObject();
		}
		return o;
	}

	/** An object that is delegate to a collection object.
	 *
	 * @param <E> - the type of the delegated object.
	 * @author $Author: sgalland$
	 * @version $FullVersion$
	 * @mavengroupid $GroupId$
	 * @mavenartifactid $ArtifactId$
	 */
	public interface Delegator<E> {

		/** Replies the delegated object.
		 *
		 * @return the delegated object.
		 */
		E getDelegatedObject();

	}

}