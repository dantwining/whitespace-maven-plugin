# whitespace-maven-plugin
Maven plugin for removing trailing whitespace errors

# Example Usage

Add the following to your pom and run any maven phase that would include the `process-sources` phase.

    <plugin>
    	<artifactId>whitespace-maven-plugin</artifactId>
    	<groupId>com.github.dantwining.whitespace-maven-plugin</groupId>
    	<version>1.0.4</version>
    	<executions>
    		<execution>
    			<phase>process-sources</phase>
    			<goals>
    				<goal>trim</goal>
    			</goals>
    		</execution>
    	</executions>
    </plugin>

