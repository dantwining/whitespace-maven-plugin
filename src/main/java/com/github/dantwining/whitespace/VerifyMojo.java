package com.github.dantwining.whitespace;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

import java.io.File;

/**
 * Goal which detects whitespace in all src/.../*.java and xml files.
 *
 * @goal verify
 * @phase process-sources
 */
public class VerifyMojo
		extends AbstractMojo {
	/**
	 * Location of the file.
	 *
	 * @parameter project.basedir="${project.basedir}/src"
	 * @required
	 */
	private File projectBasedir;

	public void execute()
			throws MojoExecutionException, MojoFailureException {

		boolean verify = true;

		Log mavenLog = getLog();

		WhitespaceUtils.detectWhitespace(verify, projectBasedir, mavenLog);

	}

}
