#  Hello World MicroProfile Application

## Hello World

A simple Hello world endpoint is created, have a look at the class **HelloController**.

### Config

Configuration of your application parameters. Specification [here](https://microprofile.io/project/eclipse/microprofile-config)
The class **ConfigurationController** shows you how to inject a configuration parameter and how you can retrieve it programmatically.

## Refs
This is a modified version of a generated , by [start.microprofile-wizard](https://start.microprofile.io/index.xhtml),  MP application

# TBC

### Health

The health status can be used to determine if the 'computing node' needs to be discarded/restarted or not. Specification [here](https://microprofile.io/project/eclipse/microprofile-health)

The class **ServiceHealthCheck** contains an example of a custom check which can be integrated to health status checks of the instance.  The index page contains a link to the status data.



### Metrics

The Metrics exports _Telemetric_ data in a uniform way of system and custom resources. Specification [here](https://microprofile.io/project/eclipse/microprofile-metrics)

The example class **MetricController** contains an example how you can measure the execution time of a request.  The index page also contains a link to the metric page (with all metric info)


### Open Tracing

Allow the participation in distributed tracing of your requests through various micro services. Specification [here](https://microprofile.io/project/eclipse/microprofile-opentracing)

Example needs to be created.


