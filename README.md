# whitespace-maven-plugin

The whitespace plugin will remove any trailing whitespace from `.java`, `.xml` and `.scala` files in your project.

## Usage

The plugin works best if it is run every time during Maven compilation. However, if you wish to perform a simple test of what the plugin does, then run the following within your Maven project:

`mvn com.github.dantwining.whitespace-maven-plugin:whitespace-maven-plugin:trim`

To enable the plugin for every Maven compilation, add the following to your pom and run any maven phase that would include the `process-sources` phase:

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

