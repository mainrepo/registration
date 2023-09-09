# Springboot sample for K8S
#### The focus of this spring-boot application is to implement very basic spring-security and deploy the application on Kubernetes cluster.

## User Guidelines
Please use terminal for ***project installation**, **build** & **running locally** for **testing**. The **integrated terminal of vscode** can also be used. The vscode must have an appropriate extensions installed for development work. The java language server by redhat can be a good choice. **Windows users can use Ubuntu or Al2 machines running on WSL 2***

After cloing the ***[samples](https://github.com/mainrepo/registration)*** repository; cd to the ***registration*** directory and fire below commands as required.

### Build:
```shell
# build the project
./gradlew build

#or if the kafka cluster is not up.
./gradlew build -x test
```

### Running
The kafka cluster must be up & running, it must be properly setup in applicayion.yml replacing the old URL
```shell
# running the application
./gradlew bootRun -x test
```

### Deploying
```shell
# There are some custom tasks created, one is for deploy as well.
# It creates a docker build & requires a docker registry to push the image.
# This image is then deployed in local K8S cluster using "kubectl" command in custom gradle script.

./gradlew deploy
```
## License
[MIT](https://choosealicense.com/licenses/mit/)