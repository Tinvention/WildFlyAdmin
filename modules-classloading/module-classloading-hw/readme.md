#  Hello World Application for WildFly module & classloading training

A simple Hello world endpoint, have a look at the class **HelloController**.
This example needs opencsv lib in the run-time classpath, but as you can see in *pom.xml* or in the war file this is not included.

### War file without runtime dependency, and default manifest file
* Create the war file, using `>mvn clean package` ( with no active maven profiles )
* Check the Manifest file, there no dependencies are declared 
* Deploy and try the application in order to verify that a `java.lang.NoClassDefFoundError: com/opencsv/CSVReader` is launched as expected.

### War file without runtime dependency, but with dependencies declared
* Undeploy and rebuild war using the `ManifestDep` maven profile
* Verify the Manifest file war included, in order to check declared dependencies 
* Try to deploy the war and verify that the deployment cannot be successful. It checks if direct dependencies are present/declared.
* Expected error: ` org.jboss.modules.ModuleNotFoundException: com.opencsv` 

### War file without runtime dependency, but with dependencies declared, dependency as module
* Shutdown the application
* Download the jar file of the needed dependency
 * can be downloaded from [maven central](https://search.maven.org/classic)
 * search for `com.opencsv` and select the jar format with the same version declared in the *pom.xml* 
* Add as wildfly module the dependency, for example using the CLI:
    *`[...]module add --name=com.opencsv --resources=/c:/temp/opencsv-4.6.jar` 
* Verify that the deploy is successful, but calling the REST end-point an error is launched
* Expected error: ` java.lang.NoClassDefFoundError: org/apache/commons/lang3/ObjectUtils` 
* Why there is this error ? What part of the application depends on this lib ? 
* You can try to solve it adding this dependency ( see the opencsv pom.xml for the correct GAV - Group, Artifact, Version ) to the war file. Does it works ? if it does not, what is the cause ? 

### War file without runtime dependency, but with dependencies declared, dependency as module with its dependency
* Undeploy the application
* Rebuild war using the `ManifestDep` maven profile, without *commons lang3 lib* and *opencsv* into the war file.
* Remove the module added before and add it with its dependency declared:
    * `[.../] module remove --name=com.opencsv`
    * `[.../] module add --name=com.opencsv --resources=/c:/temp/opencsv-4.6.jar --dependencies=org.apache.commons.lang3`
    * NB. on windows `module remove` fails. It is needed to restart the AS and then remove the module

* Verify that the deploy is successful, and calling the REST end-point check if it is working as expected
* Where is placed the *commons lang3 lib* jar/classes needed as dependency ? 





