/*
 * Copyright 2017 David Crosson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dummy

object Dummy {
  import MetaInfo._
  private val logger = org.slf4j.LoggerFactory.getLogger(getClass)
  private val userName = util.Properties.userName
  private val message = s"Hello ${userName} by ${project} release ${version}."
  def theMessage = {
    logger.info(message)
    message
  }
}
