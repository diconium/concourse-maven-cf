# Concourse Maven+Cloud Foundry Example

This example project demonstrates how to:
- Build, verify and package a Spring Boot project with Maven into a deployable artifact
- Deploy to Cloud Foundry

## Prerequisites

You should either have working local installations of both Concourse and Cloud Foundry or otherwise have access to remote instances of each.

If you want to set up a local environment, please follow the Concourse [Hello World](http://concourse.ci/hello-world.html) guide to get up and running with Concourse locally (uses Vagrant and VirtualBox) and also the Cloud Foundry ([PCF Dev](http://pivotal.io/pcf-dev)) Getting Started docs.

You should have downloaded the Concourse fly CLI tool and configured it on your system PATH.

You should also have logged in with the fly CLI to your target Concourse CI server.

## Instructions

Copy pipeline-secrets-example.yml to pipeline-secrets.yml and update with your values.

You should not set actual secrets there since they will still be visible with the fly `get-pipeline` command, instead use a credentials manager like AWS Secrets Manager and use `((secret-param-name))` as the pipeline param value, e.g.: `cf-password: ((cf-password))`.

Replace `<cf-target>` with the target name assigned to your Concourse server upon login.

```
$ git clone https://github.com/diconium/concourse-maven-cf.git
$ cd concourse-maven-cf
$ fly -t <cf-target> set-pipeline -p maven-cf-example -c pipeline.yml -l pipeline-secrets.yml
$ fly -t <cf-target> unpause-pipeline -p maven-cf-example
```
When it is all said and done, you should have the application running on Cloud Foundry!

Example: http://concourse-maven-cf-example.local.pcfdev.io/
