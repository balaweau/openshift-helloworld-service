# openshift-helloworld-service
Basic Spring Boot microservice for use in OpenShift Container Platform.

This repository is a micro-service starter project that uses Spring Boot and exposes ReSTful APIs. It has been developed for use with Unisys HCI technology challenges where a micro-service architecture is preferred. Docker images include the Contrast Security Java agent. The solution includes a Jenkinsfile with multiple steps for Maven-based build and unit testing, and for deployment via Docker image into a RedHat OpenShift cluster.

Additional steps can be added to the Jenkinsfile as needed, such as to call SonarQube for static analysis.

## Using this Repository
You cannot fork the code into the same organization; instead, create a new, empty repository for your service and clone it to your workstation. Then clone this repository and copy its files and directory structure into your new repository. Then commit and push it.

You will need to change the component name in the Maven pom.xml file. 
You will need to change the deployment name in the Jenkinsfile (e.g., replace "helloworld" with a name for your service).
You will need to change the name of the source file in the COPY directive within the Dockerfile.

## Deploying and testing the starter
Once you've made the required changes, and once your OpenShift runtime environments are ready, you may use Jenkins to build and deploy the job. HCI Tech Challenges often use multi-tenant platform elements like OpenShift to run containers. Be sure to know and follow the procedures for building and deploying, so that you don't affect any other teams' environments.

Once it's deployed and running, you can verify it's OK by navigating in a browser to its exposed URL and the /customers path, e.g., https://my-service.my-project.ose.hcitc-unisys.com/customers. This should bring back some well-formatted JSON data about customers.
