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

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Goal which trims whitespace from all src/.../*.java files.
 *
 * @goal trim
 * @phase process-sources
 */
public class MyMojo
		extends AbstractMojo {
	/**
	 * Location of the file.
	 *
	 * @parameter expression="${project.basedir}/src"
	 * @required
	 */
	private File projectBasedir;

	public void execute()
			throws MojoExecutionException {
		File f = projectBasedir;

		String[] extensions = {"java", "xml"};
		Collection<File> matchingFiles = FileUtils.listFiles(f, extensions, true);

		for (File matchingFile : matchingFiles) {
			System.out.println("matching file: " + matchingFile.getAbsolutePath());

			List<String> lines;
			try {
				lines = FileUtils.readLines(matchingFile, "UTF-8");
			} catch (IOException e) {
				throw new MojoExecutionException("Failed to read lines from " + matchingFile.getAbsolutePath(), e);
			}

			Boolean isFileModified = false;
			List<String> trimmedLines = new ArrayList<>(lines.size());
			for (String line : lines) {

				String trimmedLine = StringUtils.stripEnd(line, null);

				Boolean isLineModified = (trimmedLine.equals(line));
				isFileModified = (isFileModified || isLineModified);

				trimmedLines.add(trimmedLine);

			}

			if (isFileModified) {

				try {
					FileUtils.writeLines(matchingFile, "UTF-8", trimmedLines);
				} catch (IOException e) {
					throw new MojoExecutionException("Failed to write lines to " + matchingFile.getAbsolutePath(), e);
				}

			}
		}

	}
}
