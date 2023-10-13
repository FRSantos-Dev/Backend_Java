# Back-end Java: Microsservices, Spring Boot and Kubernetes.  

> 

## 🏁 Development Status
 Project under development 🚧

## 💻 Plataform
Windows

## 📝 Project Description
The application is composed of three microservices, the user-api, the product-api and the shopping-api. 
The user-api has the services to manage the application's users.
The product-api has the services to manage the products available for purchases.
The shopping-api provides services for users to make purchases, which in turn interact with the other two microservices.

![image](https://user-images.githubusercontent.com/16382981/119489556-316a5a00-bd32-11eb-9734-521193c5243d.png)

## Environment
[IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download), [Maven](https://maven.apache.org), 
[Docker](https://www.docker.com/products/docker-desktop), [pgAdmin](https://www.pgadmin.org/download) and 
[PostgreSQL](https://www.postgresql.org/download) (if you prefer, can use the[image](https://hub.docker.com/_/postgres) docker of PostgreSQL)

`
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=mypassword postgres
`

## 🔨 Requisitos do projeto
* 
* 
* 

## ✏️ Languages and frameworks
* Java
* JavaFX
  
## 📚 Library and dependencies
* Spring Boot, Spring Web, Spring Data, [Flyway](https://github.com/flyway/flyway) and [PostgreSQL](https://mvnrepository.com/artifact/org.postgresql/postgresql)

## 🛠️ Open and execute the project
* Due to the sharing of the shopping-client project classes among other projects, it is necessary to install them through Maven, so that the project jar is available in the local Maven repository on your machine. 
* It is necessary to configure the Maven settings.xml file to allow the use of the spotify plugin to run the application in docker containers. Normally the file in a Windows operating system.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings 
    xmlns="http://maven.apache.org/SETTINGS/1.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">

    <pluginGroups>
        <pluginGroup>com.spotify</pluginGroup>
    </pluginGroups>
</settings>
```  
### Using Docker
* In each API, you will need to run the following commands:
```cmd
mvn clean install
mvn dockerfile:build
```

When you finish executing the commands, there should be the following images on your machine:
```cmd
C:\Users\Vinicius\Documentos\Projetos\Java\backend-java\shopping-api>docker images
REPOSITORY          TAG            IMAGE ID       CREATED          SIZE
shopping/shopping-api   latest         98c61ad141eb   15 seconds ago   144MB
shopping/product-api    latest         77e78088219a   2 minutes ago    144MB
shopping/user-api       latest         7904c9f83d84   6 minutes ago    144MB
postgres            latest         26c8bcd8b719   5 weeks ago      314MB
```
Once this is done, simply run the following command to upload the applications:

```
docker-compose up
```

and the command below to stop applications:

```
docker-compose down
```

## Kubernetes
One of the ways to interact with Kubernetes is through the command line. 
To do this we will install Kubectl. 
On the Windows operating system, simply access the official Kubernetes page and follow the [documentation](https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/). 
To check if everything went well during the installation, or if you want to check if you already have Kubectl installed, simply type the following command:

```
kubectl version --client
```

The next step now is to create a cluster with the Postgres database. 
To do this, run the following commands:

```
// Moving up the cluster
kubectl create -f postgres-deployment.yaml
kubectl create -f postgres-service.yaml

// Mapping the OS port to the pod port allowing access within the cluster
kubectl port-forward svc/postgres 5000:5432

// Mapping environment variables
kubectl create -f config-map.yaml
```

The same needs to be done to create our API clusters:

```
kubectl create -f user-api/deploy/deployment.yaml
kubectl create -f user-api/deploy/service.yaml

kubectl create -f product-api/deploy/deployment.yaml
kubectl create -f product-api/deploy/service.yaml

kubectl create -f shopping-api/deploy/deployment.yaml
kubectl create -f shopping-api/deploy/service.yaml
kubectl create -f shopping-api/deploy/configmap.yaml
```

## Nginx

Nginx is an open source web server that can be used on Kubernetes. 
With it, it is possible to access Kubernetes services directly, without having to open a port from the local machine to the container. 
It is an independent service that can be installed on the cluster, just as we did with Postgres and our applications. 
To install Nginx on the server, run the following command:
```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v0.46.0/deploy/static/provider/cloud/deploy.yaml
```

## Ingress
The last step now is to create an Ingress, which is a Kubernetes element to allow external access to the cluster without the need to execute the port-forward command.
Basically, Ingress redirects access to the cluster to an application Service.
Run the following command to create the Ingress:
```
kubectl create -f ingress.yaml

// check if the ingress was created correctly
kubectl get ingresses.v1.networking.k8s.io
```

With Ingress configured, now simply direct requests from the IP shown in the previous command to the URL shopping.com. 
On Windows, just edit the file C:\windows\system32\drivers\etc\hosts and add the line:
```
129.168.99.100 shopping.com
```

Okay, now you can access the APIs using shopping.com/users, shopping.com/products, etc.

* Geração release:
    * 
    * 
    > 

    *  
    >


## 📁 Acesso ao projeto
- `Código fonte`: 
- `Documentação`:

## ➕ Mais informações

# Autores

| [<img src="https://gitlab.com/uploads/-/system/user/avatar/13638955/avatar.png?width=400" width=100><br><sub>Felipe Rocha dos Santos</sub><br><sub><i>Back-end Developer</i></sub>](https://github.com/FRSantos-Dev) |
| :---: |

